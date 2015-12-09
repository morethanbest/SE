package presentation.searchorder;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
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
		scrollPane.setBounds(450,20,500,500);
		scrollPane.setBorder(null);
		add(scrollPane);
		
		
	}
	
	private void showLogisics(){
		scrollPane.removeAll();
		if(vo!=null){
			List<String> history=vo.getHistory();
			if(history.size()>0){
				JRadioButton radioButtons[]=new JRadioButton[history.size()];
				JLabel labels[]=new JLabel[history.size()];
				JSeparator separator[]=new JSeparator[history.size()];
				if(history.size()>1){
					radioButtons[0]=new JRadioButton(history.get(0),false);
					radioButtons[0].setBounds(200, 50, 50, 21);
					radioButtons[0].setEnabled(false);
					scrollPane.add(radioButtons[0]);
				}else{
					radioButtons[0]=new JRadioButton(history.get(0),true);
					radioButtons[0].setBounds(200, 50, 50, 21);
					radioButtons[0].setEnabled(false);
					scrollPane.add(radioButtons[0]);
				}
				for(int i=1;i<history.size();i++){
					if(history.size()>i+1){
						separator[i]=new JSeparator(separator[i].VERTICAL);
						separator[i].setBounds(210, 50*i+20, 8, 30);
						scrollPane.add(separator[i]);
						radioButtons[i]=new JRadioButton(history.get(i),false);
						radioButtons[i].setBounds(200, 50*(i+1), 50, 21);
						radioButtons[i].setEnabled(false);
						scrollPane.add(radioButtons[i]);

					}else{
						separator[i]=new JSeparator(separator[i].VERTICAL);
						separator[i].setBounds(210, 50*i+20, 8, 30);
						scrollPane.add(separator[i]);
						radioButtons[i]=new JRadioButton(history.get(i),true);
						radioButtons[i].setBounds(200, 50*(i+1), 50, 21);
						radioButtons[i].setEnabled(false);
						scrollPane.add(radioButtons[i]);

					}
				}

				

				scrollPane.repaint();
				

				
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
