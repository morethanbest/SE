package presentation.managerui.staff;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogic.managerbl.StaffPack.StaffController;
import businesslogicservice.managerblservice.ConstantsBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import businesslogicservice.managerblservice.StaffBlService;
import po.Job;
import po.ResultMessage;
import presentation.enums.StaffType;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import presentation.tip.TipDialog;
import vo.CityVO;
import vo.OrganizationVO;
import vo.StaffVO;

public class StaffManagePanel extends WorkPanel implements ActionListener{
	private JTable table;
	MyButton_LightBlue btnAdd;
	MyComboBox<String> staffSelect;
	MyButton_LightBlue btnRevise;
	MyButton_LightBlue btnDelete;
	private List<StaffVO> list;
	private StaffBlService staffBlService;
	private MyComboBox<String> citySelect;
	private MyComboBox<String> orgSelect;
	
	
	/**
	 * Create the panel.
	 */
	public StaffManagePanel() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		staffBlService = new StaffController();
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 60, 954, 8);
		add(separator);
		
		btnAdd = new MyButton_LightBlue("增加");
		btnAdd.setBounds(599, 0, 113, 36);
		add(btnAdd);
		
		staffSelect = new MyComboBox<String>();
		staffSelect.setBounds(0, 0, 131, 35);
		add(staffSelect);
		addStaffTypeItems();
		
		btnRevise = new MyButton_LightBlue("修改");
		btnRevise.setBounds(847, 0, 107, 36);
		add(btnRevise);
		
		btnDelete = new MyButton_LightBlue("删除");
		btnDelete.setBounds(726, 0, 107, 36);
		add(btnDelete);
		
		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(14, 84, 926, 323);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"姓名", "职业", "所在城市", "机构名", "机构类别", "机构编号"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		citySelect = new MyComboBox<String>();
		citySelect.setBounds(137, 0, 131, 35);
		add(citySelect);
		addCityItems();
		
		orgSelect = new MyComboBox<String>();
		orgSelect.setBounds(274, 0, 131, 35);
		add(orgSelect);
		orgSelect.setVisible(false);
		addOrganizationItems();
		
		ItemListener listener = new ItemListener() {
//////////////////////////////////////////////////////////			
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
////////////////////////////////////////////////////////		
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
		tableModel.setColumnCount(6);
		tableModel.setRowCount(10);

		
		refreshList();
		btnAdd.addActionListener(this);
		btnDelete.addActionListener(this);
		btnRevise.addActionListener(this);
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
			AddStaffDialog staffDialog=new AddStaffDialog(this);
			staffDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			staffDialog.setVisible(true);
		}else if(e.getSource().equals(btnDelete)){
			try {				
				StaffVO vo=list.get(table.getSelectedRow());
				if(staffBlService.delStaff(vo)==ResultMessage.failure){
					TipDialog tipDialog=new TipDialog("该员工删除失败！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);	
				}
				refreshList();
		    } catch (Exception  e1) {
			    TipDialog tipDialog=new TipDialog("请选择删除项！");
			    tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			    tipDialog.setVisible(true);		
		    }
		}else if(e.getSource().equals(btnRevise)){
			try {				
				StaffVO vo=list.get(table.getSelectedRow());
				
				RevStaffDialog staffDialog=new RevStaffDialog(this,vo);
				staffDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				staffDialog.setVisible(true);
				refreshList();
		    } catch (Exception  e1) {
			    TipDialog tipDialog=new TipDialog("请选择修改项！");
			    tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			    tipDialog.setVisible(true);		
		    }
			
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
		if(staffSelect.getSelectedItem() == null || citySelect.getSelectedItem() == null){
			return;
		}			
		if(staffSelect.getSelectedItem().equals("全部") && citySelect.getSelectedItem().equals("全部")){
			list = staffBlService.getStaffAll();
		}			
		else if(staffSelect.getSelectedItem().equals("全部"))
			list = staffBlService.getStaffbyOrganization((String) orgSelect.getSelectedItem());
		else if(citySelect.getSelectedItem().equals("全部")){
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
			String[] row = new String[6];
			row[0] = vo.getName();
			row[1] = getJobStr(vo.getJob());
			row[2] = vo.getCity();
			row[3] = vo.getOrganizationname();
			row[4] = vo.getOrganizationtype().getName();
			row[5] = vo.getOrganizationcode();
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
