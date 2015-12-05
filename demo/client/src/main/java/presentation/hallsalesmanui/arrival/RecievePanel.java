package presentation.hallsalesmanui.arrival;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;

public class RecievePanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public RecievePanel() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(349, 67, 242, 24);
		add(textField);
		textField.setColumns(10);
		
		JComboBox<Long> comboBox = new JComboBox<Long>();
		comboBox.setBounds(349, 126, 74, 24);
		add(comboBox);
		
		JComboBox<Long> comboBox_1 = new JComboBox<Long>();
		comboBox_1.setBounds(447, 126, 61, 24);
		add(comboBox_1);
		
		JComboBox<Long> comboBox_2 = new JComboBox<Long>();
		comboBox_2.setBounds(530, 126, 61, 24);
		add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(349, 191, 242, 24);
		add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(349, 265, 242, 24);
		add(comboBox_4);
		
		JButton button = new JButton("提交");
		button.setBounds(423, 336, 113, 27);
		add(button);

	}

}
