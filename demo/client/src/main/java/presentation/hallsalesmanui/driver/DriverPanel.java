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
import vo.DriverVO;

public class DriverPanel extends JPanel implements ActionListener {

	private JTextField textNameToSearch;
	private JTextField textCodeToSearch;
	private JTable table;
	private JTextField textName;
	private JTextField textCode;
	private JTextField textPhone;
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
	private int row;
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
		
		textCodeToSearch = new JTextField();
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
		label_2.setBounds(292, 17, 85, 15);
		add(label_2);
		
		textName = new JTextField();
		textName.setBounds(330, 117, 143, 21);
		add(textName);
		textName.setColumns(10);
		textName.setEditable(isrev);
		
		JLabel label_3 = new JLabel("性别：");
		label_3.setBounds(524, 120, 54, 15);
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
		label_5.setBounds(524, 183, 54, 15);
		add(label_5);
		
		textPhone = new JTextField();
		textPhone.setBounds(584, 180, 143, 21);
		add(textPhone);
		textPhone.setColumns(10);
		textPhone.setEditable(isrev);
		
		JLabel label_6 = new JLabel("出生日期：");
		label_6.setBounds(266, 244, 66, 15);
		add(label_6);
		
		JLabel label_7 = new JLabel("行驶期限：");
		label_7.setBounds(524, 244, 66, 15);
		add(label_7);
		
		JLabel lblNewLabel = new JLabel("身份证号：");
		lblNewLabel.setBounds(266, 310, 66, 15);
		add(lblNewLabel);
		
		textidentity = new JTextField();
		textidentity.setBounds(330, 307, 143, 21);
		add(textidentity);
		textidentity.setColumns(10);
		textidentity.setEditable(isrev);
		
		BTNdelete = new JButton("删除");
		BTNdelete.setBounds(383, 388, 76, 23);
		add(BTNdelete);
		
		BTNupdate = new JButton("修改");
		BTNupdate.setBounds(606, 388, 76, 23);
		add(BTNupdate);
		
		SexSelect = new JComboBox<String>();
		SexSelect.setEditable(isrev);
		SexSelect.setEnabled(false);
		SexSelect.setBounds(588, 117, 143, 21);
		SexSelect.addItem("男");
		SexSelect.addItem("女");
		add(SexSelect);
		
		ByearSelect = new JComboBox<String>();
		ByearSelect.setEditable(isrev);
		ByearSelect.setEnabled(false);
		ByearSelect.setBounds(330, 241, 47, 21);
		addByearItem();
		add(ByearSelect);
		
		BmouthSelect = new JComboBox<String>();
		BmouthSelect.setEditable(isrev);
		BmouthSelect.setEnabled(false);
		BmouthSelect.setBounds(387, 241, 37, 21);
		addBmouthItem();
		add(BmouthSelect);
		
		BdaySelect = new JComboBox<String>();
		BdaySelect.setEditable(isrev);
		BdaySelect.setEnabled(false);
		BdaySelect.setBounds(436, 241, 37, 21);
		addBdayItem();
		add(BdaySelect);
		
		DyearSelect = new JComboBox<String>();
		DyearSelect.setEditable(isrev);
		DyearSelect.setEnabled(false);
		DyearSelect.setBounds(584, 241, 47, 21);
		addDyearItem();
		add(DyearSelect);
		
		DmouthSelect = new JComboBox<String>();
		DmouthSelect.setEditable(isrev);
		DmouthSelect.setEnabled(false);
		DmouthSelect.setBounds(641, 241, 37, 21);
		addDmouthItem();
		add(DmouthSelect);
		
		DdaySelect = new JComboBox<String>();
		DdaySelect.setEditable(isrev);
		DdaySelect.setEnabled(false);
		DdaySelect.setBounds(688, 241, 37, 21);
		addDdayItem();
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
		tableModel.setColumnCount(2);
		tableModel.setRowCount(10);
		
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
	private void addByearItem(){
		for(int i=1950;i<2050;i++){
			ByearSelect.addItem(Integer.toString(i));
		}
	}
	private void addBmouthItem(){
		for(int i=1;i<10;i++){
			BmouthSelect.addItem("0"+Integer.toString(i));
		}
		BmouthSelect.addItem("10");
		BmouthSelect.addItem("11");
		BmouthSelect.addItem("12");
	}
	private void addBdayItem(){
		for(int i=1;i<10;i++){
			BdaySelect.addItem("0"+Integer.toString(i));
		}
		for(int i=10;i<32;i++){
			BdaySelect.addItem(Integer.toString(i));
		}
	}
	private void addDyearItem(){
		for(int i=2015;i<2050;i++){
			DyearSelect.addItem(Integer.toString(i));
		}
	}
	private void addDmouthItem(){
		for(int i=1;i<10;i++){
			DmouthSelect.addItem("0"+Integer.toString(i));
		}
		DmouthSelect.addItem("10");
		DmouthSelect.addItem("11");
		DmouthSelect.addItem("12");
	}
	private void addDdayItem(){
		for(int i=1;i<10;i++){
			DdaySelect.addItem("0"+Integer.toString(i));
		}
		for(int i=10;i<32;i++){
			DdaySelect.addItem(Integer.toString(i));
		}
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
		list.remove(row);
		displayInTable(list);
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
	public String getid(){
		DriverBlService driverBlService=new DriverController();
		String code=null;
		code=driverBlService.getid(orgcode);
		
		return code;
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
		}
		else if(e.getSource().equals(BTNsearchByCode)){
			String code=textCodeToSearch.getText();
			list=new ArrayList<>();
			list.add(this.getDriverbyDN(code));		
			displayInTable(list);
		}
		else if(e.getSource().equals(BTNupdate)){
			if(isrev==false){
				isrev=true;
				BTNupdate.setText("确定");
			}
			else{
				isrev=false;
				String drivername=textName.getText();
				String drivercode=textCode.getText();
				long birthtime=Long.parseLong((String)ByearSelect.getSelectedItem()+BmouthSelect.getSelectedItem()+BdaySelect.getSelectedItem());
				String identifiercode=textidentity.getText();
				String cellphone=textPhone.getText();
				String drivergender=(String)SexSelect.getSelectedItem();
				long timelimit=Long.parseLong((String)DyearSelect.getSelectedItem()+DmouthSelect.getSelectedItem()+DdaySelect.getSelectedItem());
				DriverVO VO=new DriverVO(drivercode, drivername, birthtime, identifiercode, cellphone, drivergender, timelimit);
				vo=VO;
				BTNupdate.setText("修改");
				list.remove(row);
				list.add(row, vo);
				revDriver(VO);
			}
		}
	}
}
