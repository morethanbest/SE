package presentation.managerui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;

import presentation.managerui.constant.ConstantPanel;
import presentation.managerui.organization.OrganizationPanel;
import presentation.managerui.staff.StaffManagePanel;

public class ManagerPanel extends JPanel implements ActionListener {
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
	private StaffManagePanel staff;
	private ConstantPanel constant;
	private OrganizationPanel organization;
	/**
	 * Create the panel.
	 */
	public ManagerPanel() {
		setLayout(null);
		setBounds(0, 0, 982, 553);

		btnNewButton = new JButton("审批单据");
		btnNewButton.setBounds(14, 13, 113, 27);
		add(btnNewButton);

		btnNewButton_1 = new JButton("人员管理");
		btnNewButton_1.setBounds(141, 13, 113, 27);
		btnNewButton_1.addActionListener(this);
		add(btnNewButton_1);

		btnNewButton_2 = new JButton("机构管理");
		btnNewButton_2.setBounds(268, 13, 113, 27);
		add(btnNewButton_2);

		btnNewButton_3 = new JButton("统计分析");
		btnNewButton_3.setBounds(395, 13, 113, 27);
		add(btnNewButton_3);

		btnNewButton_4 = new JButton("常量信息");
		btnNewButton_4.setBounds(522, 13, 113, 27);
		btnNewButton_4.addActionListener(this);
		add(btnNewButton_4);

		btnNewButton_5 = new JButton("薪水策略");
		btnNewButton_5.setBounds(649, 13, 113, 27);
		add(btnNewButton_5);

		btnNewButton_6 = new JButton("注销");
		btnNewButton_6.setBounds(855, 13, 113, 27);
		add(btnNewButton_6);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 982, 2);
		add(separator);

		panel = new JPanel();
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(14, 75, 954, 420);
		add(panel);
		card = new CardLayout();
		panel.setLayout(card);
		
		//card中添加各种功能面板
		organization = new OrganizationPanel();
		staff = new StaffManagePanel();
		constant = new ConstantPanel(this);
		panel.add(organization, "organization");
		panel.add(staff, "staff");
		panel.add(constant, "constant");
		
		hint = new JLabel("");
		hint.setBounds(585, 508, 383, 32);
		hint.setVisible(false);
		add(hint);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnNewButton_1)) {
			card.show(panel, "staff");
			constant.refreshList();
		}else if (e.getSource().equals(btnNewButton_2)) {
			card.show(panel, "organization");
		}else if (e.getSource().equals(btnNewButton_4)) {
			card.show(panel, "constant");
		}

	}
	
	public void setHint(String str){
		hint.setText(str);
//		Thread thr = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				for (int i = 0; i < 11; i++) {
//					hint.setLocation(985 - i * 40, 508);
//					Thread.sleep(200);
//				}
//				
//			}
//		});
		
	}
}
