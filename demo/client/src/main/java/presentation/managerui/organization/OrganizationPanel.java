package presentation.managerui.organization;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import po.Organizationtype;
import presentation.enums.OrganizationType;
import vo.CityVO;
import vo.OrganizationVO;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.managerblservice.ConstantsBlService;
import businesslogicservice.managerblservice.OrganizationBlService;

public class OrganizationPanel extends JPanel {
	private JTable table;
	private JComboBox<String> orgSelect;
	private JComboBox<String> citySelect;
	private JButton btnAdd;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private List<OrganizationVO> list;
	private OrganizationBlService organizationBlService;
	/**
	 * Create the panel.
	 */
	public OrganizationPanel() {
		setLayout(null);
		
		organizationBlService = new OrganizationController();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 954, 10);
		add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 930, 326);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		orgSelect = new JComboBox<String>();
		orgSelect.setBounds(0, 0, 174, 31);
		add(orgSelect);
		addOrgTypeItems();
		
		citySelect = new JComboBox<String>();
		citySelect.setBounds(199, 0, 174, 31);
		add(citySelect);
		addCityItems();
		
		ItemListener listener = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				refreshList();
				
			}
		};
		
		citySelect.addItemListener(listener);
		orgSelect.addItemListener(listener);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					AddOrganizationDailog dialog = new AddOrganizationDailog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
			}
		});
		btnAdd.setBounds(587, 0, 113, 31);
		add(btnAdd);
		
		btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(714, 0, 113, 31);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Revise");
		btnNewButton_1.setBounds(841, 0, 113, 31);
		add(btnNewButton_1);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(4);
		tableModel.setRowCount(10);
	}
	
	public void addCityItems() {
		citySelect.removeAllItems();
		ConstantsBlService constantsBlService = new ConstantsController();
		List<CityVO> cityList = constantsBlService.getAllCity();
		citySelect.addItem("全部");
		for (CityVO city : cityList) {
			citySelect.addItem(city.getName());
		}
	}
	
	private void addOrgTypeItems() {
		orgSelect.addItem("全部");
		for (OrganizationType org : OrganizationType.values()) {
			orgSelect.addItem(org.getName());
		}
	}
	
	private void displayByVO() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (OrganizationVO vo : list) {
			String[] row = new String[4];
			row[0] = vo.getOrganizationcode();
			row[1] = vo.getName();
			row[2] = vo.getCity();
			row[3] = getOrganizationStr(vo.getType());

			tableModel.addRow(row);
		}

		if (table.getRowCount() < 11) {
			int n = table.getRowCount();
			for (int i = 0; i < 11 - n; i++) {
				tableModel.addRow(new String[2]);
			}
		}

	}
	
	void refreshList(){
		if(citySelect.getSelectedItem() == null || orgSelect.getSelectedItem() == null)
			return;
		if(citySelect.getSelectedItem().equals("全部") 
				&& orgSelect.getSelectedItem().equals("全部"))
			list = organizationBlService.getOrganizationAll();
		else if(citySelect.getSelectedItem().equals("全部"))
			list = organizationBlService.getOrganizationbyType(getOrganizationType((String) orgSelect.getSelectedItem()));
		else if(orgSelect.getSelectedItem().equals("全部"))
			list = organizationBlService.getOrganizationbyCity((String) citySelect.getSelectedItem());
		else
			list = organizationBlService.getOrganizationbyBoth((String) citySelect.getSelectedItem(), getOrganizationType((String) orgSelect.getSelectedItem()));
		
		displayByVO();
	}
	private Organizationtype getOrganizationType(String str){
		for (OrganizationType org : OrganizationType.values()) {
			if(org.getName().equals(str)){
				return org.getOrg();
			}
		}
		
		return null;
	}
	

	private String getOrganizationStr(Organizationtype org){
		for (OrganizationType orgs : OrganizationType.values()) {
			if(orgs.getOrg() == org){
				return orgs.getName();
			}
		}
		
		return null;
	}
	
}
