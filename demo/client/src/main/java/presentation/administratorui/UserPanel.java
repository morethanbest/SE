package presentation.administratorui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JSeparator;

import po.Job;
import po.OrganizationPO;
import po.Organizationtype;
import po.ResultMessage;
import vo.UserVO;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class UserPanel extends JPanel implements ActionListener{
	private String orgcode;
	private JTextField nameToSearch;
	private JTextField nameField;
	private JTextField passwordField;
	private JTextField orgcodeField;
	private JTextField orgnameField;
	private JButton btnSearch;
	private JButton btnAdd;
	private JButton btnupdate;
	private JButton btndelete;
	private JComboBox<String> jobSelect;
	private JComboBox<String> orgSelect;
	private UserVO vo;
	/**
	 * Create the panel.
	 */
	public UserPanel(String orgcode) {
		this.orgcode=orgcode;
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 49, 954, 8);
		add(separator);
		
		JLabel label = new JLabel("账户名搜索：");
		label.setBounds(37, 20, 72, 15);
		add(label);
		
		nameToSearch = new JTextField();
		nameToSearch.setBounds(119, 17, 107, 21);
		add(nameToSearch);
		nameToSearch.setColumns(10);
		
		btnSearch = new JButton("搜索");
		btnSearch.setBounds(264, 16, 93, 23);
		add(btnSearch);
		
		btnAdd = new JButton("增加账号");
		btnAdd.setBounds(677, 16, 93, 23);
		add(btnAdd);
		
		JLabel label_1 = new JLabel("账号：");
		label_1.setBounds(249, 107, 54, 15);
		add(label_1);
		
		nameField = new JTextField();
		nameField.setBounds(341, 104, 182, 21);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel label_2 = new JLabel("密码：");
		label_2.setBounds(249, 154, 54, 15);
		add(label_2);
		
		passwordField = new JTextField();
		passwordField.setBounds(341, 151, 182, 21);
		add(passwordField);
		passwordField.setColumns(10);
		
		JLabel label_3 = new JLabel("职位：");
		label_3.setBounds(249, 201, 54, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("所属机构名：");
		label_4.setBounds(249, 248, 77, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("所属机构类别：");
		label_5.setBounds(249, 298, 93, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("所属机构编号：");
		label_6.setBounds(249, 344, 93, 15);
		add(label_6);
		
		btnupdate = new JButton("修改");
		btnupdate.setBounds(249, 402, 93, 23);
		add(btnupdate);
		
		btndelete = new JButton("删除");
		btndelete.setBounds(468, 402, 93, 23);
		add(btndelete);
		
		orgcodeField = new JTextField();
		orgcodeField.setColumns(10);
		orgcodeField.setBounds(341, 341, 182, 21);
		add(orgcodeField);
		
		orgnameField = new JTextField();
		orgnameField.setColumns(10);
		orgnameField.setBounds(341, 245, 182, 21);
		add(orgnameField);
		
		jobSelect = new JComboBox<String >();
		jobSelect.setBounds(341, 198, 182, 21);
		addJobItem();
		add(jobSelect);
		
		orgSelect = new JComboBox<String>();
		orgSelect.setBounds(341, 295, 182, 21);
		addOrgItem();
		add(orgSelect);
		
		nameField.setEditable(false);
		passwordField.setEditable(false);
		orgcodeField.setEditable(false);
		orgnameField.setEditable(false);
		jobSelect.setEditable(false);
		orgSelect.setEditable(false);
		
		btnSearch.addActionListener(this);
		btnAdd.addActionListener(this);
		btndelete.addActionListener(this);
		btnupdate.addActionListener(this);
	}
	private void addJobItem(){
		jobSelect.addItem("快递员");
		jobSelect.addItem("营业厅业务员");
		jobSelect.addItem("中转中心业务员");
		jobSelect.addItem("仓库管理员");
		jobSelect.addItem("财务人员");
		jobSelect.addItem("司机");
		jobSelect.addItem("总经理");
		jobSelect.addItem("游客");
		jobSelect.addItem("管理员");
	}
	private void addOrgItem(){
		orgSelect.addItem("营业厅");
		orgSelect.addItem("中转中心");
		orgSelect.addItem("总部");
	}
	public ResultMessage addUser(UserVO vo){
		return null;
	}
	public UserVO getUserbyName(String username){
		return null;
	}
	public ResultMessage delUser(UserVO vo){
		return null;
	}
	public ResultMessage revUser(UserVO vo){
		return null;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
