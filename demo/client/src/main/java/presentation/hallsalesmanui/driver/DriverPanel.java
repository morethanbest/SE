package presentation.hallsalesmanui.driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import businesslogic.transportbl.DriverPack.DriverController;
import businesslogicservice.transportblservice.DriverBlService;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.DriverVO;

public class DriverPanel extends JPanel implements ActionListener {

	private JTextField textNameToSearch;
	private NumberField textCodeToSearch;
	private JTable table;
	private JTextField textName;
	private JTextField textCode;
	private NumberField textPhone;
	private JTextField textidentity;
	private JButton BTNsearchByCode;
	private JButton BTNsearchByName;
	private JButton BTNadd;
	private JButton BTNdelete;
	private JButton BTNupdate;
	private JComboBox<String> SexSelect;
	private JComboBox<String> ByearSelect;
	private JComboBox<String> BmouthSelect;
	private JComboBox<String> BdaySelect;
	private JComboBox<String> DyearSelect;
	private JComboBox<String> DmouthSelect;
	private JComboBox<String> DdaySelect;
	private List<DriverVO> list;
	private DriverVO vo=null;
	private int r;
	private boolean isrev=false;
	private String orgcode;
	
	public DriverPanel(String orgcode) {
		this.orgcode=orgcode;
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 49, 954, 8);
		add(separator);
		
		textNameToSearch = new JTextField();
		textNameToSearch.setBounds(90, 14, 66, 21);
		add(textNameToSearch);
		textNameToSearch.setColumns(10);
		
		textCodeToSearch = new NumberField(12);
		textCodeToSearch.setColumns(10);
		textCodeToSearch.setBounds(401, 14, 103, 21);
		add(textCodeToSearch);
		
		BTNsearchByCode = new JButton("搜索");
		BTNsearchByCode.setBounds(538, 13, 66, 23);
		add(BTNsearchByCode);
		
		BTNadd = new JButton("增加司机信息");
		BTNadd.setBounds(681, 13, 121, 23);
		add(BTNadd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 77, 172, 334);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("姓名：");
		label.setBounds(266, 120, 54, 15);
		add(label);
		
		JLabel label_1 = new JLabel("姓名搜索：");
		label_1.setBounds(22, 17, 68, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("司机代号搜索：");
		label_2.setBounds(292, 17, 99, 15);
		add(label_2);
		
		textName = new JTextField();
		textName.setBounds(330, 117, 143, 21);
		add(textName);
		textName.setColumns(10);
		textName.setEditable(false);
		
		JLabel label_3 = new JLabel("性别：");
		label_3.setBounds(584, 120, 54, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("编号：");
		label_4.setBounds(266, 183, 54, 15);
		add(label_4);
		
		textCode = new JTextField();
		textCode.setBounds(330, 180, 143, 21);
		add(textCode);
		textCode.setColumns(10);
		textCode.setEditable(false);
		
		JLabel label_5 = new JLabel("手机号：");
		label_5.setBounds(584, 183, 54, 15);
		add(label_5);
		
		textPhone = new NumberField(12);
		textPhone.setBounds(681, 180, 143, 21);
		add(textPhone);
		textPhone.setColumns(10);
		textPhone.setEditable(false);
		
		JLabel label_6 = new JLabel("出生日期：");
		label_6.setBounds(266, 244, 66, 15);
		add(label_6);
		
		JLabel label_7 = new JLabel("行驶期限：");
		label_7.setBounds(584, 244, 66, 15);
		add(label_7);
		
		JLabel lblNewLabel = new JLabel("身份证号：");
		lblNewLabel.setBounds(266, 310, 66, 15);
		add(lblNewLabel);
		
		textidentity = new JTextField();
		textidentity.setBounds(330, 307, 143, 21);
		add(textidentity);
		textidentity.setColumns(10);
		textidentity.setEditable(false);
		
		BTNdelete = new JButton("删除");
		BTNdelete.setBounds(383, 388, 76, 23);
		add(BTNdelete);
		
		BTNupdate = new JButton("修改");
		BTNupdate.setBounds(606, 388, 76, 23);
		add(BTNupdate);
		
		SexSelect = new JComboBox<String>();
		SexSelect.setEditable(false);
		SexSelect.setEnabled(false);
		SexSelect.setBounds(681, 117, 143, 21);
		SexSelect.addItem("男");
		SexSelect.addItem("女");
		add(SexSelect);
		
		ByearSelect = new JComboBox<String>();
		ByearSelect.setEditable(false);
		ByearSelect.setEnabled(false);
		ByearSelect.setBounds(330, 241, 76, 21);
		addyearItem(ByearSelect);
		add(ByearSelect);
		
		BmouthSelect = new JComboBox<String>();
		BmouthSelect.setEditable(false);
		BmouthSelect.setEnabled(false);
		BmouthSelect.setBounds(416, 241, 57, 21);
		addmonthItem(BmouthSelect);
		add(BmouthSelect);
		
		BdaySelect = new JComboBox<String>();
		BdaySelect.setEditable(false);
		BdaySelect.setEnabled(false);
		BdaySelect.setBounds(483, 241, 57, 21);
		addDayItem(BdaySelect,BmouthSelect,ByearSelect);
		add(BdaySelect);
		
		DyearSelect = new JComboBox<String>();
		DyearSelect.setEditable(false);
		DyearSelect.setEnabled(false);
		DyearSelect.setBounds(681, 241, 76, 21);
		addyearItem(DyearSelect);
		add(DyearSelect);
		
		DmouthSelect = new JComboBox<String>();
		DmouthSelect.setEditable(false);
		DmouthSelect.setEnabled(false);
		DmouthSelect.setBounds(767, 241, 57, 21);
		addmonthItem(DmouthSelect);
		add(DmouthSelect);
		
		DdaySelect = new JComboBox<String>();
		DdaySelect.setEditable(false);
		DdaySelect.setEnabled(false);
		DdaySelect.setBounds(834, 241, 54, 21);
		addDayItem(DdaySelect,DmouthSelect,DyearSelect);
		add(DdaySelect);
		
		BTNsearchByName = new JButton("搜索");
		BTNsearchByName.setBounds(188, 13, 66, 23);
		add(BTNsearchByName);
		
		BTNadd.addActionListener(this);
		BTNsearchByCode.addActionListener(this);
		BTNsearchByName.addActionListener(this);
		BTNdelete.addActionListener(this);
		BTNupdate.addActionListener(this);
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"姓名", "编号",
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		tableModel.setColumnCount(2);
		tableModel.setRowCount(1);
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				if(row<0){
					textName.setText("");
					SexSelect.setSelectedItem("");
					textCode.setText("");
					textPhone.setText("");
					textidentity.setText("");
					ByearSelect.setSelectedIndex(0);
					BmouthSelect.setSelectedIndex(0);
					BdaySelect.setSelectedIndex(0);
					DyearSelect.setSelectedIndex(0);
					DmouthSelect.setSelectedIndex(0);
					DdaySelect.setSelectedIndex(0);
				}
				else{
					vo=list.get(row);
					r=row;
					textName.setText(vo.getDrivername());
					SexSelect.setSelectedItem(vo.getDrivergender());
					textCode.setText(vo.getDrivercode());
					textPhone.setText(vo.getCellphone());
					textidentity.setText(vo.getIdentifiercode());
					long byear=vo.getBirthtime()/10000;
					long bmouth=vo.getBirthtime()/100-byear*100;
					long bday=vo.getBirthtime()%100;
					ByearSelect.setSelectedItem(Long.toString(byear));
					BmouthSelect.setSelectedItem(Long.toString(bmouth));
					BdaySelect.setSelectedItem(Long.toString(bday));
					long dyear=vo.getTimelimit()/10000;
					long dmouth=vo.getTimelimit()/100-dyear*100;
					long dday=vo.getTimelimit()%100;
					DyearSelect.setSelectedItem(Long.toString(dyear));
					DmouthSelect.setSelectedItem(Long.toString(dmouth));
					DdaySelect.setSelectedItem(Long.toString(dday));
				}
				
			}
		});

	}
	private void addyearItem(JComboBox<String> yearselect){
		for(int i=1950;i<2100;i++){
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
	void addDriver(String drivername,String drivercode,long birthtime,String identifiercode,String cellphone,String drivergender,long timelimit){
		DriverBlService driverBlService=new DriverController();
		DriverVO vo=new DriverVO(drivercode, drivername, birthtime, identifiercode, cellphone, drivergender, timelimit);
		driverBlService.addDriver(vo);
		System.out.println(vo.getDrivercode());
		System.out.println(vo.getDrivername());
		System.out.println(vo.getCellphone());
		System.out.println(vo.getBirthtime());
		System.out.println(vo.getIdentifiercode());
		System.out.println(vo.getCellphone());
		System.out.println(vo.getDrivergender());
	}
	
	void delDriver(DriverVO VO){
		DriverBlService driverBlService=new DriverController();
		driverBlService.delDriver(VO);
		list.remove(r);
		displayInTable(list);
		if(vo!=null){
			vo=null;
			textName.setText("");
			SexSelect.setSelectedItem("");
			textCode.setText("");
			textPhone.setText("");
			textidentity.setText("");
			ByearSelect.setSelectedItem("");
			BmouthSelect.setSelectedItem("");
			BdaySelect.setSelectedItem("");
			DyearSelect.setSelectedItem("");
			DmouthSelect.setSelectedItem("");
			DdaySelect.setSelectedItem("");
		}
		
	}
	void revDriver(DriverVO VO){
		DriverBlService driverBlService=new DriverController();
		driverBlService.revDriver(VO);

	}
	public String getcode(){
		DriverBlService driverBlService=new DriverController();
		String code=null;
		code = driverBlService.getid(orgcode);
		return code;
	}
	
	public DriverVO getDriverbyDN(String driverNumber){
		DriverBlService driverBlService=new DriverController();
		DriverVO VO=null;
		VO = driverBlService.getDriverbyDN(driverNumber, orgcode);
		System.out.println(VO.getDrivername());
		return VO;
	}
	
	public List<DriverVO> getDriverbyName(String name){
		DriverBlService driverBlService=new DriverController();
		List<DriverVO> list=new ArrayList<>();
		list = driverBlService.getDriverbyName(name, orgcode);
		return list;
		
	}

	public void displayInTable(List<DriverVO> list){
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for(DriverVO vo:list){
			String[] rowString =new String[2];
			rowString[0]=vo.getDrivername();
			rowString[1]=vo.getDrivercode();
			tableModel.addRow(rowString);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(BTNadd)){
			AddDriverDialog dialog=new AddDriverDialog(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		else if(e.getSource().equals(BTNdelete)){
			delDriver(vo);
			isrev=false;
		}
		else if(e.getSource().equals(BTNsearchByName)){
			String nameToSearch=textNameToSearch.getText();
			list=this.getDriverbyName(nameToSearch);
			displayInTable(list);
			vo=null;
		}
		else if(e.getSource().equals(BTNsearchByCode)){
			String code=textCodeToSearch.getText();
			list=new ArrayList<>();
			list.add(this.getDriverbyDN(code));		
			displayInTable(list);
			vo=null;
		}
		else if(e.getSource().equals(BTNupdate)){
			if(isrev==false){
				isrev=true;
				textName.setEditable(true);
				textPhone.setEditable(true);
				textidentity.setEditable(true);
				SexSelect.setEnabled(true);
				ByearSelect.setEnabled(true);
				BmouthSelect.setEnabled(true);
				BdaySelect.setEnabled(true);
				DyearSelect.setEnabled(true);
				DmouthSelect.setEnabled(true);
				DdaySelect.setEnabled(true);
				BTNupdate.setText("确定");
			}
			else{
				
				textName.setEditable(false);
				textPhone.setEditable(false);
				textidentity.setEditable(false);
				SexSelect.setEnabled(false);
				ByearSelect.setEnabled(false);
				BmouthSelect.setEnabled(false);
				BdaySelect.setEnabled(false);
				DyearSelect.setEnabled(false);
				DmouthSelect.setEnabled(false);
				DdaySelect.setEnabled(false);
				String drivername=textName.getText();
				String drivercode=textCode.getText();
				long birthtime=Long.parseLong((String)ByearSelect.getSelectedItem()+BmouthSelect.getSelectedItem()+BdaySelect.getSelectedItem());
				String identifiercode=textidentity.getText();
				String cellphone=textPhone.getText();
				String drivergender=(String)SexSelect.getSelectedItem();
				long timelimit=Long.parseLong((String)DyearSelect.getSelectedItem()+DmouthSelect.getSelectedItem()+DdaySelect.getSelectedItem());
				if(textName.getText().equals("")){
					TipDialog Dialog=new TipDialog("请输入姓名！");
					Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					Dialog.setVisible(true);
				}
				else if(textPhone.getText().equals("")) {
					TipDialog Dialog=new TipDialog("请输入手机号！");
					Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					Dialog.setVisible(true);
				}
				else if(textidentity.getText().equals("")){
					TipDialog Dialog=new TipDialog("请输入身份证号！");
					Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					Dialog.setVisible(true);
				}
				else{
					isrev=false;
					DriverVO VO=new DriverVO(drivercode, drivername, birthtime, identifiercode, cellphone, drivergender, timelimit);
					vo=VO;
					BTNupdate.setText("修改");
					list.remove(r);
					list.add(r, vo);
					displayInTable(list);
					revDriver(VO);
				}
				
			}
		}
	}
}
