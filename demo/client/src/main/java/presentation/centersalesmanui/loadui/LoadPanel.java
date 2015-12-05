package presentation.centersalesmanui.loadui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class LoadPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public LoadPanel() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(14, 53, 242, 24);
		add(textField);
		
		JComboBox<Long> comboBox = new JComboBox<Long>();
		comboBox.setBounds(14, 118, 74, 24);
		add(comboBox);
		
		JComboBox<Long> comboBox_1 = new JComboBox<Long>();
		comboBox_1.setBounds(112, 118, 61, 24);
		add(comboBox_1);
		
		JComboBox<Long> comboBox_2 = new JComboBox<Long>();
		comboBox_2.setBounds(195, 118, 61, 24);
		add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(14, 187, 242, 24);
		add(comboBox_3);
		
		JButton button = new JButton("提交");
		button.setBounds(416, 348, 113, 27);
		add(button);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(351, 187, 242, 24);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(351, 53, 242, 24);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(351, 118, 242, 24);
		add(textField_3);
		
		JLabel label = new JLabel("运费合计：");
		label.setBounds(80, 352, 113, 18);
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(661, 53, 284, 270);
		add(scrollPane);

	}

}
