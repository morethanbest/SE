package presentation.hallsalesmanui.driver;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businesslogic.transportbl.DriverPack.DriverController;
import businesslogicservice.transportblservice.DriverBlService;
import vo.DriverVO;

public class DriverPanel extends JPanel {

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
	private Button BTNdelete;
	private Button BTNupdate;
	private JTextField textSex;
	private JTextField textByear;
	private JTextField textBmouth;
	private JTextField textBday;
	private JTextField textDyear;
	private JTextField textDmouth;
	private JTextField textDday;
	List<DriverVO> list;
	
	public DriverPanel() {
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
		textName.setEditable(false);
		
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
		textPhone.setEditable(false);
		
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
		textidentity.setEditable(false);
		
		BTNdelete = new Button("删除");
		BTNdelete.setBounds(383, 388, 76, 23);
		add(BTNdelete);
		
		BTNupdate = new Button("修改");
		BTNupdate.setBounds(606, 388, 76, 23);
		add(BTNupdate);
		
		textSex = new JTextField();
		textSex.setEditable(false);
		textSex.setColumns(10);
		textSex.setBounds(588, 117, 143, 21);
		add(textSex);
		
		textByear = new JTextField();
		textByear.setEditable(false);
		textByear.setColumns(10);
		textByear.setBounds(330, 241, 47, 21);
		add(textByear);
		
		textBmouth = new JTextField();
		textBmouth.setEditable(false);
		textBmouth.setColumns(10);
		textBmouth.setBounds(387, 241, 37, 21);
		add(textBmouth);
		
		textBday = new JTextField();
		textBday.setEditable(false);
		textBday.setColumns(10);
		textBday.setBounds(436, 241, 37, 21);
		add(textBday);
		
		textDyear = new JTextField();
		textDyear.setEditable(false);
		textDyear.setColumns(10);
		textDyear.setBounds(584, 241, 47, 21);
		add(textDyear);
		
		textDmouth = new JTextField();
		textDmouth.setEditable(false);
		textDmouth.setColumns(10);
		textDmouth.setBounds(641, 241, 37, 21);
		add(textDmouth);
		
		textDday = new JTextField();
		textDday.setEditable(false);
		textDday.setColumns(10);
		textDday.setBounds(688, 241, 37, 21);
		add(textDday);
		
		BTNsearchByName = new JButton("搜索");
		BTNsearchByName.setBounds(188, 13, 66, 23);
		add(BTNsearchByName);
		

	}
	void addDriver(){
		
	}
	
	void delDriver(){
		
	}
	void revDriver(){
		
	}
	
	public DriverVO getDriverbyDN(){
		return null;
	}
	
	public List<DriverVO> getDriverbyName(String name){
		return null;
		
	}
	public String getid(){
		return null;
	}
	public void displayInTable(List<DriverVO> list){
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for(DriverVO vo:list){
			String[] row =new String[2];
			row[0]=vo.getDrivername();
			row[1]=vo.getDrivercode();
			tableModel.addRow(row);
		}
	}
	public void actionPerformed(ActionEvent e){
		DriverBlService driverBlService=new DriverController();
		if(e.getSource().equals(BTNadd)){
			AddDriverDialog dialog=new AddDriverDialog(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		else if(e.getSource().equals(BTNdelete)){
			
		}
		else if(e.getSource().equals(BTNsearchByName)){
			String nameToSearch=textNameToSearch.getText();
			list=this.getDriverbyName(nameToSearch);
			displayInTable(list);
		}
		else if(e.getSource().equals(BTNsearchByCode)){
			String code=textCodeToSearch.getText();
			list=new ArrayList<>();
			list.add(this.getDriverbyDN());		
			displayInTable(list);
		}
	}
}
