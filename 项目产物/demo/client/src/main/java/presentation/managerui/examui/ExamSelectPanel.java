package presentation.managerui.examui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.WorkPanel;

public class ExamSelectPanel extends WorkPanel {
	private MyButton_LightBlue button_4;
	private MyButton_LightBlue button;
	private MyButton_LightBlue button_1;
	private MyButton_LightBlue button_2;
	private MyButton_LightBlue button_3;
	private MyButton_LightBlue button_5;
	private MyButton_LightBlue button_6;
	private MyButton_LightBlue button_7;
	private MyButton_LightBlue button_10;
	private MyButton_LightBlue button_11;
	private MyButton_LightBlue button_9;

	/**
	 * Create the panel.
	 * @param parent 
	 * @param card 
	 */
	public ExamSelectPanel(ExamPanel parent, CardLayout card) {
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		button = new MyButton_LightBlue("到达单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "gr");
			}
		});
		button.setBounds(166, 114, 113, 27);
		add(button);
		
		button_1 = new MyButton_LightBlue("装车单");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "hl");
			}
		});
		button_1.setBounds(293, 114, 113, 27);
		add(button_1);
		
		button_2 = new MyButton_LightBlue("派件单");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "delivery");
			}
		});
		button_2.setBounds(420, 114, 113, 27);
		add(button_2);
		
		button_3 = new MyButton_LightBlue("收款单");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "collect");
			}
		});
		button_3.setBounds(547, 114, 113, 27);
		add(button_3);
		
		button_4 = new MyButton_LightBlue("订单");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "order");
			}
		});
		button_4.setBounds(166, 59, 113, 27);
		add(button_4);
		
		button_5 = new MyButton_LightBlue("到达单");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "arrival");
			}
		});
		button_5.setBounds(166, 167, 113, 27);
		add(button_5);
		
		button_6 = new MyButton_LightBlue("中转单");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "trans");
			}
		});
		button_6.setBounds(293, 167, 113, 27);
		add(button_6);
		
		button_7 = new MyButton_LightBlue("装车单");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "cl");
			}
		});
		button_7.setBounds(420, 167, 113, 27);
		add(button_7);
		
		button_9 = new MyButton_LightBlue("付款单");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "pay");
			}
		});
		button_9.setBounds(166, 280, 113, 27);
		add(button_9);
		
		button_10 = new MyButton_LightBlue("入库单");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "in");
			}
		});
		button_10.setBounds(166, 222, 113, 27);
		add(button_10);
		
		button_11 = new MyButton_LightBlue("出库单");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(parent, "out");
			}
		});
		button_11.setBounds(293, 222, 113, 27);
		add(button_11);

	}
}
