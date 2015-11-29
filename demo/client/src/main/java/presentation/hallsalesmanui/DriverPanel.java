package presentation.hallsalesmanui;

import java.awt.Button;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

public class DriverPanel extends JPanel {

	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public DriverPanel() {
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 49, 954, 8);
		add(separator);
		
		textField = new JTextField();
		textField.setBounds(90, 14, 66, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(187, 13, 66, 23);
		add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(402, 14, 103, 21);
		add(textField_1);
		
		JButton button = new JButton("搜索");
		button.setBounds(538, 13, 66, 23);
		add(button);
		
		JButton button_1 = new JButton("增加司机信息");
		button_1.setBounds(681, 13, 121, 23);
		add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 77, 172, 334);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("姓名：");
		label.setBounds(266, 120, 54, 15);
		add(label);
		
		JLabel label_1 = new JLabel("姓名搜索：");
		label_1.setBounds(22, 17, 68, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("司机代号搜索：");
		label_2.setBounds(307, 17, 85, 15);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(330, 117, 143, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("性别：");
		label_3.setBounds(524, 120, 54, 15);
		add(label_3);
		
		Choice choice = new Choice();
		choice.setBounds(584, 120, 143, 21);
		add(choice);
		
		JLabel label_4 = new JLabel("编号：");
		label_4.setBounds(266, 183, 54, 15);
		add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(330, 180, 143, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_5 = new JLabel("手机号：");
		label_5.setBounds(524, 183, 54, 15);
		add(label_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(584, 180, 143, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_6 = new JLabel("出生日期：");
		label_6.setBounds(266, 244, 66, 15);
		add(label_6);
		
		JLabel label_7 = new JLabel("行驶期限：");
		label_7.setBounds(524, 244, 66, 15);
		add(label_7);
		
		JLabel lblNewLabel = new JLabel("身份证号：");
		lblNewLabel.setBounds(266, 310, 66, 15);
		add(lblNewLabel);
		
		textField_5 = new JTextField();
		textField_5.setBounds(330, 307, 143, 21);
		add(textField_5);
		textField_5.setColumns(10);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(330, 244, 54, 21);
		add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(390, 244, 38, 21);
		add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(434, 244, 39, 21);
		add(choice_3);
		
		Choice choice_7 = new Choice();
		choice_7.setBounds(584, 244, 54, 21);
		add(choice_7);
		
		Choice choice_4 = new Choice();
		choice_4.setBounds(644, 244, 38, 21);
		add(choice_4);
		
		Choice choice_5 = new Choice();
		choice_5.setBounds(689, 244, 38, 21);
		add(choice_5);
		
		Button button_2 = new Button("删除");
		button_2.setBounds(383, 388, 76, 23);
		add(button_2);
		
		Button button_3 = new Button("修改");
		button_3.setBounds(606, 388, 76, 23);
		add(button_3);
		

	}
}
