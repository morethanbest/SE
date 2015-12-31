package presentation.searchorder;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

import businesslogic.logisticsbl.LogisticsPack.LogisticsSearchController;
import businesslogicservice.logisticsblservice.SearchOrderBlService;
import presentation.mainui.MainFrame;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.myscrollpane.MyScrollPane;
import presentation.tip.TipDialog;
import vo.LogisticsVO;

public class Searchorder extends WorkPanel implements ActionListener{
	private MyTextField textField;
	private MyScrollPane scrollPane;
	MyButton_LightBlue searchBtn;
	LogisticsVO vo=null;
	private MyButton_LightBlue button;
	private MainFrame parent;
	/**
	 * Create the panel.
	 */
	public Searchorder(MainFrame parent) {
		this.parent=parent;
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		JLabel label = new JLabel("输入订单号查询订单");
		label.setBounds(195, 83, 274, 47);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		add(label);
		
		textField = new MyTextField();
		textField.setBounds(124, 159, 274, 47);
		add(textField);
		textField.setColumns(10);
		
		searchBtn= new MyButton_LightBlue("查询");
		searchBtn.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		searchBtn.setBounds(216, 286, 99, 31);
		add(searchBtn);
		searchBtn.addActionListener(this);
		
		scrollPane=new MyScrollPane();
		scrollPane.setBounds(450,38,500,350);
		scrollPane.setBorder(null);
		add(scrollPane);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		
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
					radioButtons[0]=new JRadioButton("",false);
					radioButtons[0].setBounds(200, 50, 50, 21);
					radioButtons[0].setEnabled(false);
					radioButtons[0].setOpaque(false);
					labels[0]=new JLabel(history.get(0));
					labels[0].setBounds(250,50,200,21);
					scrollPane.add(labels[0]);
					scrollPane.add(radioButtons[0]);
				}else{
					radioButtons[0]=new JRadioButton("",true);
					radioButtons[0].setBounds(200, 50, 50, 21);
					radioButtons[0].setEnabled(false);
					radioButtons[0].setOpaque(false);
					labels[0]=new JLabel(history.get(0));
					labels[0].setBounds(250,50,200,21);
					scrollPane.add(labels[0]);
					scrollPane.add(radioButtons[0]);
				}
				for(int i=1;i<history.size();i++){
					if(history.size()>i+1){
						separator[i]=new JSeparator(separator[i].VERTICAL);
						separator[i].setBounds(210, 50*i+20, 8, 30);
						scrollPane.add(separator[i]);
						radioButtons[i]=new JRadioButton("",false);
						radioButtons[i].setBounds(200, 50*(i+1), 50, 21);
						radioButtons[i].setEnabled(false);
						radioButtons[i].setOpaque(false);
						labels[i]=new JLabel(history.get(i));
						labels[i].setBounds(250,50*(i+1),200,21);
						scrollPane.add(labels[i]);
						scrollPane.add(radioButtons[i]);

					}else{
						separator[i]=new JSeparator(separator[i].VERTICAL);
						separator[i].setBounds(210, 50*i+20, 8, 30);
						scrollPane.add(separator[i]);
						radioButtons[i]=new JRadioButton("",true);
						radioButtons[i].setBounds(200, 50*(i+1), 50, 21);
						radioButtons[i].setEnabled(false);
						radioButtons[i].setOpaque(false);
						labels[i]=new JLabel(history.get(i));
						labels[i].setBounds(250,50*(i+1),200,21);
						scrollPane.add(labels[i]);
						scrollPane.add(radioButtons[i]);

					}
				}

				scrollPane.repaint();
				

				
			}else{
				TipDialog dialog=new TipDialog("该订单不存在！");
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);		
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
