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

import po.City;
import po.Organizationtype;
import presentation.enums.CityType;
import presentation.enums.OrganizationType;
import vo.OrganizationVO;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.managerblservice.OrganizationBlService;

public class OrganizationPanel extends JPanel {
	private JTable table;
	JComboBox<String> orgSelect;
	JComboBox<String> citySelect;
	JButton btnAdd;
	JButton btnNewButton;
	JButton btnNewButton_1;
	List<OrganizationVO> list;
	OrganizationBlService organizationBlService;
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
		citySelect.setBounds(188, 0, 174, 31);
		add(citySelect);
		addCityTypeItems();
		
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
				try {
					AddOrganizationDailog dialog = new AddOrganizationDailog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e1) {
				}
				
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
	
	private void addCityTypeItems() {
		citySelect.addItem("全部");
		for (CityType city : CityType.values()) {
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
			row[2] = getCityStr(vo.getCity());
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
		if(citySelect.getSelectedItem().equals("全部") && orgSelect.getSelectedItem().equals("全部"))
			list = organizationBlService.getOrganizationAll();
		else if(citySelect.getSelectedItem().equals("全部"))
			list = organizationBlService.getOrganizationbyType(getOrganizationType((String) orgSelect.getSelectedItem()));
		else if(orgSelect.getSelectedItem().equals("全部"))
			list = organizationBlService.getOrganizationbyCity(getCityType((String) citySelect.getSelectedItem()));
		else
			list = organizationBlService.getOrganizationbyBoth(getCityType((String) citySelect.getSelectedItem()), getOrganizationType((String) orgSelect.getSelectedItem()));
		
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
	
	private City getCityType(String str){
		for (CityType city: CityType.values()) {
			if(city.getName().equals(str)){
				return city.getCity();
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
	
	private String getCityStr(City city){
		for (CityType citys : CityType.values()) {
			if(citys.getCity() == city){
				return citys.getName();
			}
		}
		
		return null;
	}
}
