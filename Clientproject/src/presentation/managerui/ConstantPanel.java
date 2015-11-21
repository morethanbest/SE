package presentation.managerui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ConstantPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ConstantPanel() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(35, 23, 327, 41);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(406, 30, 113, 27);
		add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(14, 77, 954, 2);
		add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(136, 204, 154, 134);
		add(scrollPane);
		
		JList list_2 = new JList();
		scrollPane.setViewportView(list_2);

	}
}
