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
import presentation.Financial.recordpay.RecordpayPanel;
import presentation.Financial.statistics.StatisticsPanel;
import presentation.hallsalesmanui.driver.DriverPanel;
import presentation.hallsalesmanui.vehicle.VehiclePanel;
import presentation.mainui.MainFrame;

public class FinancialPanel extends JPanel implements ActionListener{
	private JPanel panel;
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
    private String orgcode;
    private DebitnotePanel debitnotePanel;
    private NewBookPanel newBookPanel;
    private Job job;
	/**
	 * Create the panel.
	 */
	public FinancialPanel(String orgcode,Job job) {
		this.orgcode=orgcode;
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

		panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(14, 75, 954, 450);
		add(panel);
		card = new CardLayout();
		panel.setLayout(card);
		
		//card中添加各种功能面板
		accountPanel=new AccountPanel(orgcode);
		panel.add(accountPanel, "account");
		statisticsPanel=new StatisticsPanel(orgcode);
		panel.add(statisticsPanel, "statistics");
		recordpayPanel=new RecordpayPanel(orgcode);
		panel.add(recordpayPanel, "recordpay");
		balancePanel=new BalancePanel();
		panel.add(balancePanel, "balance");
		debitnotePanel=new DebitnotePanel();
		panel.add(debitnotePanel, "debitnote");
		newBookPanel=new NewBookPanel();
		panel.add(newBookPanel, "newbook");
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
				card.show(panel, "account");
			}
		}else if (e.getSource().equals(btnNewButton_4)) {
			card.show(panel, "statistics");
		}else if(e.getSource().equals(btnNewButton_1)){
			card.show(panel, "recordpay");
		}else if(e.getSource().equals(btnNewButton_3)){
			card.show(panel, "balance");
		}else if(e.getSource().equals(btnNewButton)){
			card.show(panel, "debitnote");
		}else if(e.getSource().equals(btnNewButton_5)){
			card.show(panel, "newbook");
		}else if(e.getSource().equals(btnNewButton_6)){
			try {
		           RMIHelper.init();
		           MainFrame frame= new MainFrame();
		           frame.start();
		        } catch (ClientInitException e1) {
		            e1.printStackTrace();
		            JOptionPane.showMessageDialog(
		                    null,
		                    "Client boots fail!\nCause: " + e1.getMessage(),
		                    "Fatal Error",
		                    JOptionPane.ERROR_MESSAGE
		            );
		        }
		}
	}

}
