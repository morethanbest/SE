package presentation.managerui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class StaffManagePanel extends JPanel implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public StaffManagePanel() {
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 71, 954, 8);
		add(separator);
		
		textField = new JTextField();
		textField.setBounds(70, 13, 276, 45);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(406, 22, 113, 27);
		add(btnSearch);
		
		JButton button = new JButton("增加人员");
		button.setBounds(807, 22, 113, 27);
		add(button);
		
		textField_1 = new JTextField();
		textField_1.setBounds(350, 164, 244, 35);
		add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(350, 259, 244, 35);
		add(comboBox);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(305, 365, 113, 27);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(521, 365, 113, 27);
		add(btnNewButton_1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(null)){
			
		}
		
	}
}
