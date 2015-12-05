package presentation.centersalesmanui.arrivalui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;

public class ArrivalPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ArrivalPanel() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(139, 47, 242, 24);
		add(textField);
		
		JComboBox<Long> comboBox = new JComboBox<Long>();
		comboBox.setBounds(546, 47, 74, 24);
		add(comboBox);
		
		JComboBox<Long> comboBox_1 = new JComboBox<Long>();
		comboBox_1.setBounds(644, 47, 61, 24);
		add(comboBox_1);
		
		JComboBox<Long> comboBox_2 = new JComboBox<Long>();
		comboBox_2.setBounds(727, 47, 61, 24);
		add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(546, 213, 242, 24);
		add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(139, 132, 242, 24);
		add(comboBox_4);
		
		JButton button = new JButton("提交");
		button.setBounds(416, 309, 113, 27);
		add(button);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(139, 213, 242, 24);
		add(textField_1);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(546, 132, 242, 24);
		add(comboBox_5);

	}
}
