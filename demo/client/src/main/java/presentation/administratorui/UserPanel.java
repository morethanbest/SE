package presentation.administratorui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import businesslogic.userbl.UsersPack.UserController;
import businesslogicservice.userblservice.UserBlService;
import po.Job;
import po.Organizationtype;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.OrganizationVO;
import vo.UserVO;

public class UserPanel extends JPanel implements ActionListener{
	private String orgcode;
	private JTextField nameToSearch;
	private JTextField nameField;
	private JTextField passwordField;
	private NumberField orgcodeField;
	private JTextField orgnameField;
	private JButton btnSearch;
	private JButton btnAdd;
	private JButton btnupdate;
	private JButton btndelete;
	private JComboBox<String> jobSelect;
	private JComboBox<String> orgSelect;
	private UserVO vo=null;
	boolean isrev=false;
	private JTextField cityField;
	/**
	 * Create the panel.
	 */
	public UserPanel(String orgcode) {
		this.orgcode=orgcode;
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 49, 954, 8);
		add(separator);
		
		JLabel label = new JLabel("用户名搜索：");
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
		
		JLabel label_1 = new JLabel("用户名：");
		label_1.setBounds(249, 67, 54, 15);
		add(label_1);
		
		nameField = new JTextField();
		nameField.setBounds(341, 67, 182, 21);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel label_2 = new JLabel("密码：");
		label_2.setBounds(249, 115, 54, 15);
		add(label_2);
		
		passwordField = new JTextField();
		passwordField.setBounds(341, 112, 182, 21);
		add(passwordField);
		passwordField.setColumns(10);
		
		JLabel label_3 = new JLabel("职位：");
		label_3.setBounds(249, 155, 54, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("所属机构名：");
		label_4.setBounds(249, 248, 93, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("所属机构类别：");
		label_5.setBounds(249, 298, 93, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("所属机构编号：");
		label_6.setBounds(249, 344, 108, 15);
		add(label_6);
		
		btnupdate = new JButton("修改");
		btnupdate.setBounds(249, 387, 93, 23);
		add(btnupdate);
		
		btndelete = new JButton("删除");
		btndelete.setBounds(469, 387, 93, 23);
		add(btndelete);
		
		orgcodeField = new NumberField(20);
		orgcodeField.setColumns(10);
		orgcodeField.setBounds(341, 341, 182, 21);
		add(orgcodeField);
		
		orgnameField = new JTextField();
		orgnameField.setColumns(10);
		orgnameField.setBounds(341, 245, 182, 21);
		add(orgnameField);
		
		jobSelect = new JComboBox<String >();
		jobSelect.setBounds(341, 152, 182, 21);
		addJobItem();
		add(jobSelect);
		
		orgSelect = new JComboBox<String>();
		orgSelect.setBounds(341, 295, 182, 21);
		addOrgItem();
		add(orgSelect);
		JLabel label_7 = new JLabel("城市：");
		label_7.setBounds(249, 200, 54, 15);
		add(label_7);
		
		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(341, 197, 182, 21);
		add(cityField);
		
		nameField.setEditable(false);
		passwordField.setEditable(false);
		orgcodeField.setEditable(false);
		orgnameField.setEditable(false);
		cityField.setEditable(false);
		jobSelect.setEditable(false);
		orgSelect.setEditable(false);
		jobSelect.setEnabled(false);
		orgSelect.setEnabled(false);
		
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
		jobSelect.addItem("高级财务人员");
		jobSelect.addItem("司机");
		jobSelect.addItem("总经理");
		jobSelect.addItem("管理员");
	}
	private void addOrgItem(){
		orgSelect.addItem("营业厅");
		orgSelect.addItem("中转中心");
		orgSelect.addItem("总部");
	}
	public OrganizationVO getOrgByCode(String orgcode){
		UserBlService userBlService=new UserController();
		OrganizationVO organizationVO=userBlService.findOrgByCode(orgcode);
		return organizationVO;
	}
	public void addUser(UserVO vo){
		UserBlService userBlService=new UserController();
		userBlService.addUser(vo);
	}
	private void getUserbyName(String username){
		UserBlService userBlService=new UserController();
		UserVO VO=userBlService.getUserbyName(username);
		vo=VO;
	}
	private void delUser(UserVO vo){
		UserBlService userBlService=new UserController();
		userBlService.delUser(vo);
	}
	private void revUser(UserVO vo){
		UserBlService userBlService=new UserController();
		userBlService.revUser(vo);
	}
	private void display(){
		if(vo==null){
			nameField.setText("");
			passwordField.setText("");
			jobSelect.setSelectedIndex(0);
			orgcodeField.setText("");
			orgnameField.setText("");
			cityField.setText("");
			orgSelect.setSelectedIndex(0);
		}
		else{
			nameField.setText(vo.getUsername());
			passwordField.setText(vo.getPassword());
			switch (vo.getJob()) {
			case Courier:
				jobSelect.setSelectedIndex(0);
				break;
            case hallsalesman:
            	jobSelect.setSelectedIndex(1);
				break;
            case transfercentersalesman:
            	jobSelect.setSelectedIndex(2);
            	break;
            case CenterDepot:
            	jobSelect.setSelectedIndex(3);
            	break;
            case Financial:
            	jobSelect.setSelectedIndex(4);
            	break;
            case advanceFinancial:
            	jobSelect.setSelectedIndex(5);
            	break;
            case drivers:
            	jobSelect.setSelectedIndex(6);
            	break;
            case manager:
            	jobSelect.setSelectedIndex(7);
            	break;
            case administrator:
            	jobSelect.setSelectedIndex(8);
            	break;
			default:
				break;
			}
			orgcodeField.setText(vo.getOrganizationcode());
			orgnameField.setText(vo.getOrganizationname());
			cityField.setText(vo.getCity());
			switch (vo.getOrganizationtype()) {
			case hall:
				orgSelect.setSelectedIndex(0);
				break;
			case transfercenter:
				orgSelect.setSelectedIndex(1);
				break;
			case headquarters:
				orgSelect.setSelectedIndex(2);
				break;
			default:
				break;
			}
			
		}
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnSearch)){
			getUserbyName(nameToSearch.getText());
			display();
		}else if(e.getSource().equals(btnAdd)){
			AddUserDialog dialog=new AddUserDialog(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}else if(e.getSource().equals(btndelete)){
			delUser(vo);
			vo=null;
			display();
		}else if(e.getSource().equals(btnupdate)){
			if(isrev==false){
				btnupdate.setText("确定");
				isrev=true;
				nameField.setEditable(true);
				passwordField.setEditable(true);
				orgcodeField.setEditable(true);
				cityField.setEditable(true);
				jobSelect.setEnabled(true);
			}
			else {
				
				btnupdate.setText("修改");
				
				Job newjob = null;
				switch (jobSelect.getSelectedIndex()) {
				case 0:
					newjob=Job.Courier;
					break;
	            case 1:
	            	newjob=Job.hallsalesman;
					break;
	            case 2:
	            	newjob=Job.transfercentersalesman;
	            	break;
	            case 3:
	            	newjob=Job.CenterDepot;
	            	break;
	            case 4:
	            	newjob=Job.Financial;
	            	break;
	            case 5:
	            	newjob=Job.advanceFinancial;
	            	break;
	            case 6:
	            	newjob=Job.drivers;
	            	break;
	            case 7:
	            	newjob=Job.manager;
	            	break;
	            case 8:
	            	newjob=Job.administrator;
	            	break;
				default:
					break;
				}

				OrganizationVO organizationVO=getOrgByCode(orgcodeField.getText());
				if(organizationVO==null){
					TipDialog Dialog=new TipDialog("请输入正确的组织编号！");
					Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					Dialog.setVisible(true);
				}
				else if(nameField.getText().equals("")){
					TipDialog Dialog=new TipDialog("请输入用户名！");
					Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					Dialog.setVisible(true);
				}
				else if(passwordField.getText().equals("")){
					TipDialog Dialog=new TipDialog("请输入密码！");
					Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					Dialog.setVisible(true);
				}
				else{
					isrev=false;
					orgnameField.setText(organizationVO.getName());
					switch (organizationVO.getType()) {
					case hall:
						orgSelect.setSelectedIndex(0);
						break;
					case transfercenter:
						orgSelect.setSelectedIndex(1);
						break;
					case headquarters:
						orgSelect.setSelectedIndex(2);
						break;
					default:
						break;
					}
					cityField.setText(organizationVO.getCity());
					vo=new UserVO(nameField.getText(), passwordField.getText(), newjob, orgnameField.getText(),
							orgcodeField.getText(), organizationVO.getType(), cityField.getText());
					revUser(vo);
					nameField.setEditable(false);
					passwordField.setEditable(false);
					orgcodeField.setEditable(false);
					cityField.setEditable(false);
					jobSelect.setEnabled(false);
				}
				
			}
			
		}
	}
}
