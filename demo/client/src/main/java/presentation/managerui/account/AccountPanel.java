package presentation.managerui.account;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JSeparator;

import businesslogic.accountbl.AccountPack.AccountController;
import businesslogicservice.accountblservice.AccountBlService;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.tip.NumberField;
import vo.AccountVO;

public class AccountPanel extends WorkPanel  implements ActionListener{
	private NumberField nameToSearch;
	private MyTextField nameField;
	private MyTextField moneyField;
	private AccountVO vo=null;
	private MyButton_LightBlue btnSearch;
	/**
	 * Create the panel.
	 */
	public AccountPanel() {
        setLayout(null);
        setBackground(SystemColor.inactiveCaptionBorder);
        
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 49, 954, 8);
		add(separator);
		
		JLabel label = new JLabel("账号搜索：");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label.setBounds(24, 21, 74, 15);
		add(label);
		
		nameToSearch = new NumberField(12);
		nameToSearch.setBounds(108, 18, 204, 21);
		add(nameToSearch);
		nameToSearch.setColumns(10);
		
		btnSearch = new MyButton_LightBlue("搜索");
		btnSearch.setBounds(375, 10, 120, 29);
		add(btnSearch);
		
		JLabel label_1 = new JLabel("账户信息：");
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 16));
		label_1.setBounds(108, 84, 92, 29);
		add(label_1);
		
		JLabel label_2 = new JLabel("账号：");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_2.setBounds(241, 141, 54, 29);
		add(label_2);
		
		nameField = new MyTextField();
		nameField.setBounds(335, 146, 133, 21);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel label_3 = new JLabel("余额：");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_3.setBounds(241, 220, 54, 18);
		add(label_3);
		
		moneyField = new MyTextField();
		moneyField.setColumns(10);
		moneyField.setBounds(335, 220, 133, 21);
		add(moneyField);
		
		nameField.setEditable(false);
		moneyField.setEditable(false);
		
		btnSearch.addActionListener(this);

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
		}
	}

}
