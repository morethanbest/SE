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

public class VehiclePanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_3;

	public VehiclePanel() {
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 49, 954, 8);
		add(separator);
		
		textField = new JTextField();
		textField.setBounds(104, 14, 103, 21);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(217, 13, 66, 23);
		add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(402, 14, 103, 21);
		add(textField_1);
		
		JButton button = new JButton("搜索");
		button.setBounds(515, 13, 66, 23);
		add(button);
		
		JButton button_1 = new JButton("增加车辆信息");
		button_1.setBounds(681, 13, 121, 23);
		add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 77, 172, 334);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("车辆代号：");
		label.setBounds(375, 120, 99, 15);
		add(label);
		
		JLabel label_1 = new JLabel("车牌号搜索：");
		label_1.setBounds(22, 17, 92, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("车辆代号搜索：");
		label_2.setBounds(307, 17, 85, 15);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(539, 117, 143, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("车牌号：");
		label_4.setBounds(375, 203, 54, 15);
		add(label_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(539, 200, 143, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_6 = new JLabel("服役期限：");
		label_6.setBounds(375, 291, 66, 15);
		add(label_6);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(539, 291, 54, 21);
		add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(599, 291, 38, 21);
		add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(643, 291, 39, 21);
		add(choice_3);
		
		Button button_2 = new Button("删除");
		button_2.setBounds(383, 388, 76, 23);
		add(button_2);
		
		Button button_3 = new Button("修改");
		button_3.setBounds(606, 388, 76, 23);
		add(button_3);
		
	}

}
