package presentation.Financial.newbook;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.accountbl.NewBookPack.NewBookController;
import businesslogicservice.accountblservice.NewBookBlService;
import po.Job;
import vo.AccountVO;
import vo.CommodityVO;
import vo.DriverVO;
import vo.NewbookVO;
import vo.OrganizationVO;
import vo.RecordcollectVO;
import vo.StaffVO;
import vo.VehicleVO;

public class NewBookPanel extends JPanel implements ActionListener{
	private JComboBox<String> yearSelect;
	private JComboBox<String> monthSelect;
	private JComboBox<String> daySelect;
	private JButton btnSearch;
	private JButton btnaccount;
	private JButton btnorg;
	private JButton btnstaff;
	private JButton btncommodity;
	private JButton btnvehicle;
	private JButton btncreate;
	private JTable table;
	private JScrollPane scrollPane;
    private NewbookVO vo=null;
	/**
	 * Create the panel.
	 */
	public NewBookPanel() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 954, 10);
		add(separator);
		
		yearSelect = new JComboBox<String>();
		yearSelect.setBounds(113, 11, 74, 31);
		yearSelect.setEditable(false);
		add(yearSelect);
		addyearItem(yearSelect);

		ItemListener listener= new ItemListener(){			//用于判断这个月的天数
			@Override
			public void itemStateChanged(ItemEvent e) {
				addDayItem(daySelect,monthSelect,yearSelect);
			}
		};
		monthSelect = new JComboBox<String>();
		monthSelect.setBounds(197, 11, 65, 31);
		monthSelect.setEditable(false);
		add(monthSelect);
		addmonthItem(monthSelect);
		
		daySelect = new JComboBox<String>();
		daySelect.setBounds(272, 10, 65, 32);
		daySelect.setEditable(false);
		add(daySelect);
		addDayItem(daySelect,monthSelect,yearSelect);
		
		JLabel label = new JLabel("建账时间：");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label.setBounds(10, 10, 93, 31);
		add(label);
		
		btnSearch = new JButton("搜索");
		btnSearch.setBounds(392, 10, 93, 33);
		add(btnSearch);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(207, 78, 673, 313);
		add(scrollPane);
		
		btnaccount = new JButton("账户");
		btnaccount.setBounds(33, 78, 107, 38);
		add(btnaccount);
		
		btnorg = new JButton("机构");
		btnorg.setBounds(33, 146, 107, 40);
		add(btnorg);
		
		btnstaff = new JButton("人员");
		btnstaff.setBounds(33, 214, 107, 39);
		add(btnstaff);
		
		btncommodity = new JButton("库存");
		btncommodity.setBounds(33, 282, 107, 39);
		add(btncommodity);
		
		btnvehicle = new JButton("车辆");
		btnvehicle.setBounds(33, 352, 107, 39);
		add(btnvehicle);
		
		btncreate = new JButton("期初建账");
		btncreate.setBounds(641, 7, 93, 31);
		add(btncreate);
		
		yearSelect.addItemListener(listener);
		monthSelect.addItemListener(listener);
		btnSearch.addActionListener(this);
		btnaccount.addActionListener(this);
		btnorg.addActionListener(this);
		btnstaff.addActionListener(this);
		btncommodity.addActionListener(this);
		btnvehicle.addActionListener(this);
		btncreate.addActionListener(this);
	}
	private void accountTable(){
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"账号", "余额"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(2);
		tableModel.setRowCount(0);
		
		if(vo!=null){
			List<AccountVO> accountlist=vo.getAccount();
			for(AccountVO accountvo : accountlist){
				String[] rowString =new String[2];
				rowString[0]=accountvo.getAccountname();
				rowString[1]=Double.toString(accountvo.getAccountsum());
				tableModel.addRow(rowString);
			}
		}
	}
    private void orgTable(){
    	table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"机构名", "机构编号", "机构类别", "城市"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(4);
		tableModel.setRowCount(0);
		
		if(vo!=null){
			List<OrganizationVO> orglist=vo.getOrganization();
			for(OrganizationVO orgvo : orglist){
				String[] rowString =new String[4];
				rowString[0]=orgvo.getName();
				rowString[1]=orgvo.getOrganizationcode();
				switch (orgvo.getType()) {
				case hall:
					rowString[2]="营业厅";
					break;
				case transfercenter:
					rowString[2]="中转中心";
					break;
				case headquarters:
					rowString[2]="总部";
					break;
				default:
					break;
				}
				rowString[3]=orgvo.getCity();
				tableModel.addRow(rowString);
			}
		}
	}
    private void staffTable(){
    	table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"编号", "姓名", "职位", "机构", "城市"
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
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(5);
		tableModel.setRowCount(0);
		
		if(vo!=null){
			List<StaffVO> stafflist=vo.getStaff();
			for(StaffVO staffvo : stafflist){
				String[] rowString =new String[5];
				rowString[0]=Long.toString(staffvo.getId());
				rowString[1]=staffvo.getName();
				rowString[2]=staffvo.getJob().getName();
				rowString[3]=staffvo.getOrganizationname();
				rowString[4]=staffvo.getCity();
				tableModel.addRow(rowString);
			}
		}
	}
    private void commotidyTable(){
    	table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"订单号", "目的地", "入库时间", "出库时间"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(4);
		tableModel.setRowCount(0);
		
		if(vo!=null){
			List<CommodityVO> commoditylist=vo.getCommodity();
			for(CommodityVO comvo : commoditylist){
				String[] rowString =new String[4];
				rowString[0]=comvo.getOrdercode();
				rowString[1]=comvo.getDestination();
				rowString[2]=Long.toString(comvo.getIntime());
				rowString[3]=Long.toString(comvo.getOuttime());
				tableModel.addRow(rowString);
			}
		}
	}
    private void vehicleTable(){
    	table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"车辆编号", "车牌号", "行驶期限"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(3);
		tableModel.setRowCount(0);
		
		if(vo!=null){
			List<VehicleVO> vehiclelist=vo.getVehicles();
			for(VehicleVO vehiclevo : vehiclelist){
				String[] rowString =new String[3];
				rowString[0]=vehiclevo.getVehiclecode();
				rowString[1]=vehiclevo.getVehiclenum();
				rowString[1]=Long.toString(vehiclevo.getExtendtime());
				tableModel.addRow(rowString);
			}
		}
    }
    private void Search(){
    	long time=Long.parseLong((String)yearSelect.getSelectedItem()+monthSelect.getSelectedItem()+daySelect.getSelectedItem());
        System.out.println(time);
    	NewBookBlService newBookBlService=new NewBookController();
        vo=newBookBlService.find(time);
        table = new JTable();
        table.setRowHeight(30);
		scrollPane.setViewportView(table);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(0);
		tableModel.setRowCount(0);
		if(vo.getCommodity().size()==0){
			System.out.println("然并卵");
		}
    }
    private void create(){
    	NewBookBlService newBookBlService=new NewBookController();
    	long id=newBookBlService.getid();
    	newBookBlService.NewBook(id);
    }
	private void addyearItem(JComboBox<String> yearselect){
		for(int i=2000;i<2100;i++){
			yearselect.addItem(Integer.toString(i));
		}
	}
	
	private void addmonthItem(JComboBox<String> monthselect){
		for(int i=1;i<=9;i++){
			monthselect.addItem("0"+Integer.toString(i));
		}
		for(int i=10;i<=12;i++){
			monthselect.addItem(Integer.toString(i));
		}
	}
	
	private void addDayItem(JComboBox<String> dayselect,JComboBox<String> monthselect,JComboBox<String> yearselect){
		dayselect.removeAllItems();
		
		//得到这个月的天数
		int days=getDays(Integer.parseInt((String)yearselect.getSelectedItem()),Integer.parseInt((String)monthselect.getSelectedItem()));
			
		for(int i=1;i<=9;i++){
			dayselect.addItem("0"+Integer.toString(i));
		}
		for(int i=10;i<=days;i++){
			dayselect.addItem(Integer.toString(i));
		}
	}
	
	public boolean isleap(Integer year){
		if(year%400==0){
			return true;
		}else if(year%100==0){
			return false;
		}else if(year%4==0){
			return true;
		}else{
			return false;
		}
	}
	
	public int getDays(Integer year,Integer month){				//得到这个月的天数
		int day[]={31,28,31,30,31,30,31,31,30,31,30,31};
		if(month==2&&isleap(year)){
			return 29;
		}
		return day[month-1];
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnSearch)){
			Search();
		}else if(e.getSource().equals(btnaccount)){
			accountTable();
		}else if(e.getSource().equals(btnorg)){
			orgTable();
		}else if(e.getSource().equals(btnstaff)){
			staffTable();
		}else if(e.getSource().equals(btncommodity)){
			commotidyTable();
		}else if(e.getSource().equals(btnvehicle)){
			vehicleTable();
		}else if(e.getSource().equals(btncreate)){
			create();
			Success dialog=new Success(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		
	}
}
