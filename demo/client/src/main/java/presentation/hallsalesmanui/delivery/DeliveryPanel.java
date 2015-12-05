package presentation.hallsalesmanui.delivery;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DeliveryPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public DeliveryPanel() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(286, 82, 242, 24);
		add(textField);
		
		JComboBox<Long> comboBox = new JComboBox<Long>();
		comboBox.setBounds(286, 141, 74, 24);
		add(comboBox);
		
		JComboBox<Long> comboBox_1 = new JComboBox<Long>();
		comboBox_1.setBounds(384, 141, 61, 24);
		add(comboBox_1);
		
		JComboBox<Long> comboBox_2 = new JComboBox<Long>();
		comboBox_2.setBounds(467, 141, 61, 24);
		add(comboBox_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(286, 204, 242, 24);
		add(textField_1);
		
		JButton button = new JButton("提交");
		button.setBounds(359, 276, 113, 27);
		add(button);

	}

}
