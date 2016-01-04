package presentation.Financial;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import po.Job;
import presentation.Financial.account.AccountPanel;
import presentation.Financial.balance.BalancePanel;
import presentation.Financial.debitnote.DebitnotePanel;
import presentation.Financial.newbook.NewBookPanel;
import presentation.Financial.recordpay.RecordpayCheckPanel;
import presentation.Financial.recordpay.RecordpayPanel;
import presentation.Financial.recordpay.RecordpayUpdatePanel;
import presentation.Financial.statistics.StatisticsPanel;
import presentation.mainui.MainFrame;
import presentation.mycomp.PersonPanel;

public class FinancialPanel extends PersonPanel implements ActionListener{
	private JPanel switcher;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	private JLabel hint;
	private CardLayout card;
	private AccountPanel accountPanel;
	private StatisticsPanel statisticsPanel;
	private RecordpayPanel recordpayPanel;
	private BalancePanel balancePanel;
    private DebitnotePanel debitnotePanel;
    private NewBookPanel newBookPanel;
    private Job job;
    private MainFrame parent;
    
    private RecordpayCheckPanel rc;
	/**
	 * Create the panel.
	 */
	public FinancialPanel(String orgcode,Job job,MainFrame parent) {
		this.parent=parent;
		this.job=job;
		setLayout(null);
		setBounds(0, 0, 982, 553);
		setBackground(SystemColor.inactiveCaptionBorder);

		btnNewButton = new JButton("结算");
		btnNewButton.setBounds(0, 0, 96, 40);
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(SystemColor.windowBorder);
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(btnNewButton);
		add(btnNewButton);

		btnNewButton_1 = new JButton("付款");
		btnNewButton_1.setBounds(97, 0, 96, 40);
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setForeground(SystemColor.windowBorder);
		btnNewButton_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton_1.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(btnNewButton_1);
		add(btnNewButton_1);

		btnNewButton_2 = new JButton("账户");
		btnNewButton_2.setBounds(194, 0, 96, 40);
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setForeground(SystemColor.windowBorder);
		btnNewButton_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton_2.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(btnNewButton_2);
		add(btnNewButton_2);

		btnNewButton_3 = new JButton("成本收益");
		btnNewButton_3.setBounds(291, 0, 96, 40);
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setForeground(SystemColor.windowBorder);
		btnNewButton_3.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton_3.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(btnNewButton_3);
		add(btnNewButton_3);

		btnNewButton_4 = new JButton("经营情况");
		btnNewButton_4.setBounds(389, 0, 96, 40);
		btnNewButton_4.addActionListener(this);
		btnNewButton_4.setForeground(SystemColor.windowBorder);
		btnNewButton_4.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton_4.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(btnNewButton_4);
		add(btnNewButton_4);

		btnNewButton_5 = new JButton("期初建账");
		btnNewButton_5.setBounds(485, 0, 96, 40);
		btnNewButton_5.addActionListener(this);
		btnNewButton_5.setForeground(SystemColor.windowBorder);
		btnNewButton_5.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton_5.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(btnNewButton_5);
		add(btnNewButton_5);
         
		btnNewButton_6 = new JButton("注销");
		btnNewButton_6.setBounds(879, 0, 103, 40);
		btnNewButton_6.addActionListener(this);
		btnNewButton_6.setForeground(SystemColor.windowBorder);
		btnNewButton_6.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton_6.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(btnNewButton_6);
		add(btnNewButton_6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 982, 2);
		add(separator);

		switcher = new JPanel();
		switcher.setBackground(SystemColor.controlHighlight);
		switcher.setBounds(14, 75, 954, 450);
		add(switcher);
		card = new CardLayout();
		switcher.setLayout(card);
		
		//card中添加各种功能面板
		debitnotePanel=new DebitnotePanel();
		switcher.add(debitnotePanel, "debitnote");
		accountPanel=new AccountPanel(orgcode);
		switcher.add(accountPanel, "account");
		statisticsPanel=new StatisticsPanel(orgcode);
		switcher.add(statisticsPanel, "statistics");
		RecordpayUpdatePanel ru = new RecordpayUpdatePanel(this, card);
		rc = new RecordpayCheckPanel(switcher, card, ru);
		recordpayPanel=new RecordpayPanel(orgcode, this, card);
		switcher.add(recordpayPanel, "recordpay");
		switcher.add(rc, "rc");
		switcher.add(ru, "ru");
		balancePanel=new BalancePanel();
		switcher.add(balancePanel, "balance");
		newBookPanel=new NewBookPanel();
		switcher.add(newBookPanel, "newbook");
		hint = new JLabel("");
		hint.setBounds(585, 508, 383, 32);
		hint.setVisible(false);
		add(hint);

}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		setSelectButton(button);
		if (e.getSource().equals(btnNewButton_2)) {
			if(job==Job.advanceFinancial){
				card.show(switcher, "account");
			}
		}else if (e.getSource().equals(btnNewButton_4)) {
			card.show(switcher, "statistics");
		}else if(e.getSource().equals(btnNewButton_1)){
			card.show(switcher, "recordpay");
		}else if(e.getSource().equals(btnNewButton_3)){
			card.show(switcher, "balance");
		}else if(e.getSource().equals(btnNewButton)){
			card.show(switcher, "debitnote");
		}else if(e.getSource().equals(btnNewButton_5)){
			card.show(switcher, "newbook");
		}else if(e.getSource().equals(btnNewButton_6)){
			parent.skipToLogin();;
		}
	}
	private void setNoneBorder(JButton button){
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	}
	
	private void setSelectButton(JButton button){
		List<JButton> list= new ArrayList<JButton>();
		list.add(btnNewButton);
		list.add(btnNewButton_1);
		list.add(btnNewButton_2);
		list.add(btnNewButton_3);
		list.add(btnNewButton_4);
		list.add(btnNewButton_5);
		list.add(btnNewButton_6);
		for(JButton b:list){
			if(b.equals(button)){
				b.setForeground(SystemColor.text);
				b.setBackground(SystemColor.textHighlight);
			}else{
				b.setForeground(SystemColor.windowBorder);
				b.setBackground(SystemColor.inactiveCaptionBorder);
			}
		}
	}
	public JPanel getSwitcher() {
		return switcher;
	}
	public RecordpayCheckPanel getRc() {
		return rc;
	}

}
