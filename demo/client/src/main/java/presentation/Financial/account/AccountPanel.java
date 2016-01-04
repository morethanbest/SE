package presentation.Financial.account;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import businesslogic.accountbl.AccountPack.AccountController;
import businesslogicservice.accountblservice.AccountBlService;
import po.ResultMessage;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.tip.NumberField;
import vo.AccountVO;

public class AccountPanel extends WorkPanel implements ActionListener{
	private String orgcode;
	private NumberField nameToSearch;
	private NumberField nameField;
	private MyTextField moneyField;
	
	private MyButton_LightBlue btnSearch;
	private MyButton_LightBlue btnadd;
	private MyButton_LightBlue btnupdate;
	private MyButton_LightBlue btndelete;
	
	private AccountVO vo=null;
	
	private boolean isrev;
	/**
	 * Create the panel.
	 */
	public AccountPanel(String orgcode) {
		this.orgcode=orgcode;
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 49, 954, 8);
		add(separator);
		
		JLabel label = new JLabel("账号搜索：");
		label.setBounds(24, 21, 74, 15);
		add(label);
		
		nameToSearch = new NumberField(12);
		nameToSearch.setBounds(108, 18, 204, 21);
		add(nameToSearch);
		nameToSearch.setColumns(10);
		
		btnSearch = new MyButton_LightBlue("搜索");
		btnSearch.setBounds(375, 16, 93, 23);
		add(btnSearch);
		
		btnadd = new MyButton_LightBlue("增加账户");
		btnadd.setBounds(632, 17, 108, 23);
		add(btnadd);
		
		JLabel label_1 = new JLabel("账户信息：");
		label_1.setBounds(108, 84, 93, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("账号：");
		label_2.setBounds(241, 141, 54, 15);
		add(label_2);
		
		nameField = new NumberField(12);
		nameField.setBounds(335, 138, 133, 21);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel label_3 = new JLabel("余额：");
		label_3.setBounds(241, 220, 54, 15);
		add(label_3);
		
		moneyField = new MyTextField();
		moneyField.setColumns(10);
		moneyField.setBounds(335, 217, 133, 21);
		add(moneyField);
		
		btnupdate = new MyButton_LightBlue("修改");
		btnupdate.setBounds(202, 356, 93, 23);
		add(btnupdate);
		
		btndelete = new MyButton_LightBlue("删除");
		btndelete.setBounds(460, 356, 93, 23);
		add(btndelete);
		
		nameField.setEditable(false);
		moneyField.setEditable(false);
		
		btnSearch.addActionListener(this);
		btnadd.addActionListener(this);
		btnupdate.addActionListener(this);
		btndelete.addActionListener(this);
	}
	public ResultMessage addAccount(AccountVO vo) {
		AccountBlService accountBlService=new AccountController();
		return accountBlService.addAccount(vo);
	}
	
	private void delAccount(AccountVO vo) {
		AccountBlService accountBlService=new AccountController();
		accountBlService.delAccount(vo);
	}
	private void revAccount(AccountVO vo){
		AccountBlService accountBlService=new AccountController();
		accountBlService.revAccount(vo);
	}
	
	private void getAccountbyName(String accountname) {
		AccountBlService accountBlService=new AccountController();
		AccountVO VO=accountBlService.getAccountbyName(accountname);
		vo=VO;
	}
	
	private void display(){
		if(vo==null){
			nameField.setText("");
			moneyField.setText("");
		}
		else{
			nameField.setText(vo.getAccountname());
			moneyField.setText(Double.toString(vo.getAccountsum()));
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnSearch)){
			getAccountbyName(nameToSearch.getText());
			display();
		}else if(e.getSource().equals(btnadd)){
			AddAccountDialog dialog=new AddAccountDialog(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}else if(e.getSource().equals(btnupdate)){
			if(isrev==false){
				btnupdate.setText("确定");
				nameField.setEditable(true);
				isrev=true;
			}
			else {
				isrev=false;
				btnupdate.setText("修改");
				nameField.setEditable(false);
				AccountVO newvo=new AccountVO(vo.getId(), nameField.getText(), vo.getAccountsum());
				vo=newvo;
				revAccount(vo);
			}
		}else if(e.getSource().equals(btndelete)){
			delAccount(vo);
			vo=null;
			display();
		}
	}
}
