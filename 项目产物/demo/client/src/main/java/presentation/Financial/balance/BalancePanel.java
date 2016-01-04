package presentation.Financial.balance;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import businesslogic.balancebl.BalancePack.BalanceviewController;
import businesslogicservice.balanceblservice.BalanceviewBlService;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import vo.BalanceviewVO;

public class BalancePanel extends WorkPanel implements ActionListener{
	private MyTextField inField;
	private MyTextField outField;
	private MyTextField interestField;
	private MyButton_LightBlue button;
    private BalanceviewVO vo=null;
	/**
	 * Create the panel.
	 */
	public BalancePanel() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		JLabel label = new JLabel("成本收益：");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label.setBounds(150, 27, 91, 27);
		add(label);
		
		JLabel label_1 = new JLabel("总收入：");
		label_1.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		label_1.setBounds(227, 84, 68, 27);
		add(label_1);
		
		JLabel label_2 = new JLabel("总支出：");
		label_2.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		label_2.setBounds(227, 149, 68, 27);
		add(label_2);
		
		JLabel label_3 = new JLabel("总利润：");
		label_3.setFont(new Font("微软雅黑 Light", Font.PLAIN, 15));
		label_3.setBounds(227, 225, 68, 27);
		add(label_3);
		
		inField = new MyTextField();
		inField.setBounds(374, 84, 145, 32);
		add(inField);
		inField.setColumns(10);
		
		outField = new MyTextField();
		outField.setColumns(10);
		outField.setBounds(374, 154, 145, 32);
		add(outField);
		
		interestField = new MyTextField();
		interestField.setColumns(10);
		interestField.setBounds(374, 220, 145, 32);
		add(interestField);
		
		button = new MyButton_LightBlue("生成");
		button.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		button.setBounds(318, 353, 117, 38);
		add(button);
		
		inField.setEditable(false);
		outField.setEditable(false);
		interestField.setEditable(false);
		button.addActionListener(this);
	}
    private void getBalanceview(){
    	BalanceviewBlService balanceviewBlService=new BalanceviewController();
    	vo=balanceviewBlService.getBalanceview();
    }
    private void display(){
    	if(vo==null){
    		inField.setText("");
    		outField.setText("");
    		interestField.setText("");
    	}
    	else {
    		inField.setText(Double.toString(vo.getIn()));
    		outField.setText(Double.toString(vo.getOut()));
    		interestField.setText(Double.toString(vo.getInterest()));
    	}
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(button)){
			getBalanceview();
			display();
		}
	}
}
