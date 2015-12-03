package presentation.managerui.staff;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import po.Job;
import po.Organizationtype;
import presentation.enums.OrganizationType;
import presentation.enums.StaffType;
import vo.CityVO;
import vo.OrganizationVO;
import vo.StaffVO;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogic.managerbl.StaffPack.StaffController;
import businesslogicservice.managerblservice.ConstantsBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import businesslogicservice.managerblservice.StaffBlService;

public class StaffManagePanel extends JPanel implements ActionListener{
	private JTable table;
	JButton btnAdd;
	JComboBox<String> staffSelect;
	JButton btnRevise;
	JButton btnDelete;
	private List<StaffVO> list;
	private StaffBlService staffBlService;
	private JComboBox<String> citySelect;
	private JComboBox<String> orgSelect;
	
	
	/**
	 * Create the panel.
	 */
	public StaffManagePanel() {
		setLayout(null);
		
		staffBlService = new StaffController();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 60, 954, 8);
		add(separator);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(599, 0, 113, 36);
		add(btnAdd);
		
		staffSelect = new JComboBox<String>();
		staffSelect.setBounds(0, 0, 131, 35);
		add(staffSelect);
		addStaffTypeItems();
		
		btnRevise = new JButton("Revise");
		btnRevise.addActionListener(this);
		btnRevise.setBounds(847, 0, 107, 36);
		add(btnRevise);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(726, 0, 107, 36);
		add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 84, 926, 323);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6240\u5728\u57CE\u5E02", "\u6240\u5728\u673A\u6784", "\u59D3\u540D", "\u804C\u4E1A", "\u6240\u5728\u673A\u6784\u7F16\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		citySelect = new JComboBox<String>();
		citySelect.setBounds(137, 0, 131, 35);
		add(citySelect);
		addCityItems();
		
		orgSelect = new JComboBox<String>();
		orgSelect.setBounds(274, 0, 131, 35);
		add(orgSelect);
		orgSelect.setVisible(false);
		addOrganizationItems();
		
		ItemListener listener = new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(citySelect.getSelectedItem().equals("全部"))
					orgSelect.setVisible(false);
				else{
					orgSelect.setVisible(true);
					addOrganizationItems();
				}
				refreshList();
			}
		};
		
		ItemListener listener2 = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				refreshList();	
			}
			
		};
		citySelect.addItemListener(listener);
		staffSelect.addItemListener(listener2);
		orgSelect.addItemListener(listener2);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(5);
		tableModel.setRowCount(10);

		
		list = staffBlService.getStaffAll();
	}

	private void addStaffTypeItems() {
		staffSelect.addItem("全部");
		for (StaffType staff : StaffType.values()) {
			staffSelect.addItem(staff.getName());
		}
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
	
	public void addOrganizationItems(){
		orgSelect.removeAllItems();
		OrganizationBlService organizationBlService = new OrganizationController();
		List<OrganizationVO> orgList;
		orgList = organizationBlService.getOrganizationbyCity((String) citySelect.getSelectedItem());
		for(OrganizationVO org : orgList){
			orgSelect.addItem(org.getName());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAdd)){
			
		}else if(e.getSource().equals(btnDelete)){
//			staffBlService.delStaff(null);
		}
		
	}
	private Job getJob(String str) {
		for (StaffType job : StaffType.values()) {
			if (job.getName().equals(str)) {
				return job.getJob();
			}
		}

		return null;
	}

	private String getJobStr(Job job) {
		for (StaffType staff : StaffType.values()) {
			if (staff.getJob() == job) {
				return staff.getName();
			}
		}

		return null;
	}
	
	void refreshList(){
		if(staffSelect.getSelectedItem() == null || citySelect.getSelectedItem() == null)
			return;
		if(staffSelect.getSelectedItem().equals("全部") && citySelect.getSelectedItem().equals("全部"))
			list = staffBlService.getStaffAll();
		else if(staffSelect.getSelectedItem().equals("全部"))
			list = staffBlService.getStaffbyOrganization((String) orgSelect.getSelectedItem());
		else if(citySelect.getSelectedItem().equals("全部")){
			System.out.println(getJob((String) staffSelect.getSelectedItem()));
			list = staffBlService.getStaffbyJob(getJob((String) staffSelect.getSelectedItem()));
		}
		else
			list = staffBlService.getStaffbyBoth((String) orgSelect.getSelectedItem(), getJob((String) staffSelect.getSelectedItem()));
		
		displayByVO();
	}
	
	private void displayByVO() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (StaffVO vo : list) {
			String[] row = new String[5];
			row[0] = vo.getCity();
			row[1] = vo.getOrganizationname();
			row[2] = vo.getName();
			row[3] = getJobStr(vo.getJob());
			row[4] = vo.getOrganizationcode();

			tableModel.addRow(row);
		}

		if (table.getRowCount() < 11) {
			int n = table.getRowCount();
			for (int i = 0; i < 11 - n; i++) {
				tableModel.addRow(new String[5]);
			}
		}

	}
}
