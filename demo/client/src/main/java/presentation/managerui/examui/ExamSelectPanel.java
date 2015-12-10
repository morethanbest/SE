package presentation.managerui.examui;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExamSelectPanel extends JPanel {
	private JButton button_4;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_10;
	private JButton button_11;
	private JButton button_9;

	/**
	 * Create the panel.
	 * @param parent 
	 * @param card 
	 */
	public ExamSelectPanel(ExamPanel parent, CardLayout card) {
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		button = new JButton("到达单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setBounds(166, 114, 113, 27);
		add(button);
		
		button_1 = new JButton("装车单");
		button_1.setBounds(293, 114, 113, 27);
		add(button_1);
		
		button_2 = new JButton("派件单");
		button_2.setBounds(420, 114, 113, 27);
		add(button_2);
		
		button_3 = new JButton("收款单");
		button_3.setBounds(547, 114, 113, 27);
		add(button_3);
		
		button_4 = new JButton("订单");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "order");
			}
		});
		button_4.setBounds(166, 59, 113, 27);
		add(button_4);
		
		button_5 = new JButton("到达单");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "arrival");
			}
		});
		button_5.setBounds(166, 167, 113, 27);
		add(button_5);
		
		button_6 = new JButton("中转单");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "trans");
			}
		});
		button_6.setBounds(293, 167, 113, 27);
		add(button_6);
		
		button_7 = new JButton("装车单");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "cl");
			}
		});
		button_7.setBounds(420, 167, 113, 27);
		add(button_7);
		
		button_9 = new JButton("付款单");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "pay");
			}
		});
		button_9.setBounds(166, 280, 113, 27);
		add(button_9);
		
		button_10 = new JButton("入库单");
		button_10.setBounds(166, 222, 113, 27);
		add(button_10);
		
		button_11 = new JButton("出库单");
		button_11.setBounds(293, 222, 113, 27);
		add(button_11);

	}
}
