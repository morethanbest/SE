package presentation.managerui;

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
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		setBounds(0, 0, 982, 553);

		btnNewButton = new JButton("审批单据");
		btnNewButton.setForeground(SystemColor.windowBorder);
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 15));
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setBounds(0, 0, 113, 40);
		btnNewButton.addActionListener(this);
		setNoneBorder(btnNewButton);
		add(btnNewButton);

		btnNewButton_1 = new JButton("人员管理");
		btnNewButton_1.setFont(new Font("微软雅黑 Light", Font.BOLD, 15));
		btnNewButton_1.setForeground(SystemColor.windowBorder);
		btnNewButton_1.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_1.setBounds(113, 0, 113, 40);
		btnNewButton_1.addActionListener(this);
		setNoneBorder(btnNewButton_1);
		add(btnNewButton_1);

		btnNewButton_2 = new JButton("机构管理");
		btnNewButton_2.setForeground(SystemColor.windowBorder);
		btnNewButton_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 15));
		btnNewButton_2.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_2.setBounds(226, 0, 113, 40);
		btnNewButton_2.addActionListener(this);
		setNoneBorder(btnNewButton_2);
		add(btnNewButton_2);

		btnNewButton_3 = new JButton("统计分析");
		btnNewButton_3.setFont(new Font("微软雅黑 Light", Font.BOLD, 15));
		btnNewButton_3.setForeground(SystemColor.windowBorder);
		btnNewButton_3.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_3.setBounds(339, 0, 113, 40);
		btnNewButton_3.addActionListener(this);
		setNoneBorder(btnNewButton_3);
		add(btnNewButton_3);

		btnNewButton_4 = new JButton("常量信息");
		btnNewButton_4.setForeground(SystemColor.windowBorder);
		btnNewButton_4.setFont(new Font("微软雅黑 Light", Font.BOLD, 15));
		btnNewButton_4.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_4.setBounds(452, 0, 113, 40);
		btnNewButton_4.addActionListener(this);
		setNoneBorder(btnNewButton_4);
		add(btnNewButton_4);

		btnNewButton_5 = new JButton("薪水策略");
		btnNewButton_5.setFont(new Font("微软雅黑 Light", Font.BOLD, 15));
		btnNewButton_5.setForeground(SystemColor.windowBorder);
		btnNewButton_5.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_5.setBounds(565, 0, 113, 40);
		btnNewButton_5.addActionListener(this);
		setNoneBorder(btnNewButton_5);
		add(btnNewButton_5);

		btnNewButton_6 = new JButton("注销");
		btnNewButton_6.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_6.setBounds(879, 0, 103, 40);
		btnNewButton_6.addActionListener(this);
		setNoneBorder(btnNewButton_6);
		add(btnNewButton_6);

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
		panel.add(staff, "staff");
		panel.add(organization, "organization");
		panel.add(constant, "constant");
		
		hint = new JLabel("");
		hint.setBounds(585, 508, 383, 32);
		hint.setVisible(false);
		add(hint);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		setSelectButton(button);
		if (e.getSource().equals(btnNewButton_1)) {
			card.show(panel, "staff");
		}else if (e.getSource().equals(btnNewButton_2)) {
			card.show(panel, "organization");
			organization.addCityItems();
		}else if (e.getSource().equals(btnNewButton_4)) {
			card.show(panel, "constant");
		}

	}
	private void setNoneBorder(JButton button){
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	};
	
	private void setSelectButton(JButton button){
		List<JButton> list= new ArrayList<JButton>();
		list.add(btnNewButton);
		list.add(btnNewButton_1);
		list.add(btnNewButton_2);
		list.add(btnNewButton_3);
		list.add(btnNewButton_4);
		list.add(btnNewButton_5);
		for(JButton b:list){
			if(b.equals(button)){
				b.setForeground(SystemColor.text);
				b.setBackground(SystemColor.textHighlight);
			}else{
				b.setForeground(SystemColor.windowBorder);
				b.setBackground(SystemColor.inactiveCaptionBorder);
			}
		}
	};
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
