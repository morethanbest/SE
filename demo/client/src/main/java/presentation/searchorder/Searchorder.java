package presentation.searchorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import businesslogic.logisticsbl.LogisticsPack.LogisticsSearchController;
import businesslogicservice.logisticsblservice.SearchOrderBlService;
import vo.LogisticsVO;

public class Searchorder extends JPanel implements ActionListener{
	private JTextField textField;
	private JScrollPane scrollPane;
	JButton searchBtn;
	LogisticsVO vo=null;
	/**
	 * Create the panel.
	 */
	public Searchorder() {
		setLayout(null);
		
		JLabel label = new JLabel("输入订单号查询订单");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label.setBounds(176, 78, 165, 41);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(124, 199, 274, 47);
		add(textField);
		textField.setColumns(10);
		
		searchBtn= new JButton("查询");
		searchBtn.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		searchBtn.setBounds(216, 326, 99, 31);
		add(searchBtn);
		searchBtn.addActionListener(this);
		
		scrollPane=new JScrollPane();
		scrollPane.setBounds(350,20,500,400);
		scrollPane.setBorder(null);
		add(scrollPane);
		
		
	}
	
	private void showLogisics(){
		scrollPane.removeAll();
		if(vo!=null){
			System.out.println("111");
			List<String> history=vo.getHistory();
			if(history.size()>0){
				history.get(0);
				JRadioButton radioButton=new  JRadioButton();
				radioButton.setBounds(50, 50, 50, 50);
				
				scrollPane.add(radioButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(searchBtn)){
			SearchOrderBlService logisticsInfoService=new LogisticsSearchController();
			String ordernum=textField.getText();
			vo=logisticsInfoService.getOrderbyOrderNumber(ordernum);
			showLogisics();
		}
		
	}

}
