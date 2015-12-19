package presentation.Financial;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import init.ClientInitException;
import init.RMIHelper;
import po.Job;
import presentation.Financial.account.AccountPanel;
import presentation.Financial.balance.BalancePanel;
import presentation.Financial.debitnote.DebitnotePanel;
import presentation.Financial.newbook.NewBookPanel;
import presentation.Financial.recordpay.RecordpayCheckPanel;
import presentation.Financial.recordpay.RecordpayPanel;
import presentation.Financial.recordpay.RecordpayUpdatePanel;
import presentation.Financial.statistics.StatisticsPanel;
import presentation.hallsalesmanui.driver.DriverPanel;
import presentation.hallsalesmanui.vehicle.VehiclePanel;
import presentation.mainui.MainFrame;

public class FinancialPanel extends JPanel implements ActionListener{
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

		btnNewButton = new JButton("结算");
		btnNewButton.setBounds(14, 13, 113, 27);
		btnNewButton.addActionListener(this);
		add(btnNewButton);

		btnNewButton_1 = new JButton("付款");
		btnNewButton_1.setBounds(141, 13, 113, 27);
		btnNewButton_1.addActionListener(this);
		add(btnNewButton_1);

		btnNewButton_2 = new JButton("账户");
		btnNewButton_2.setBounds(268, 13, 113, 27);
		btnNewButton_2.addActionListener(this);
		add(btnNewButton_2);

		btnNewButton_3 = new JButton("成本收益");
		btnNewButton_3.setBounds(395, 13, 113, 27);
		btnNewButton_3.addActionListener(this);
		add(btnNewButton_3);

		btnNewButton_4 = new JButton("经营情况");
		btnNewButton_4.setBounds(522, 13, 113, 27);
		btnNewButton_4.addActionListener(this);
		add(btnNewButton_4);

		btnNewButton_5 = new JButton("期初建账");
		btnNewButton_5.setBounds(649, 13, 113, 27);
		btnNewButton_5.addActionListener(this);
		add(btnNewButton_5);
         
		btnNewButton_6 = new JButton("注销");
		btnNewButton_6.setBounds(855, 13, 113, 27);
		btnNewButton_6.addActionListener(this);
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
		recordpayPanel=new RecordpayPanel(orgcode, switcher, card);
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
	public JPanel getSwitcher() {
		return switcher;
	}
	public RecordpayCheckPanel getRc() {
		return rc;
	}

}
