package presentation.courierui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class RecievePanel extends JPanel {
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_2;
	private JButton button_1;
	private JButton button;
	private JTextField textField_1;
	private JTextField textField;

	/**
	 * Create the panel.
	 * @param courierPanel 
	 */
	public RecievePanel(CourierPanel courierPanel) {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(105, 112, 229, 30);
		add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(14, 68, 954, 7);
		add(separator);
		
		button = new JButton("订单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courierPanel.switchPanel();
			}
		});
		button.setBounds(823, 13, 145, 42);
		add(button);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 199, 229, 30);
		add(textField_1);
		textField_1.setColumns(10);
		
		button_1 = new JButton("确认收件");
		button_1.setBounds(163, 419, 113, 27);
		add(button_1);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(105, 293, 79, 24);
		add(comboBox);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(198, 293, 61, 24);
		add(comboBox_1);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setBounds(273, 293, 61, 24);
		add(comboBox_2);

	}
}
