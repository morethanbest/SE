package presentation.managerui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import presentation.enums.StaffType;

public class StaffManagePanel extends JPanel implements ActionListener{
	private JTextField nameField;
	private JTable table;
	JButton btnSearch;
	JButton btnAdd;
	JComboBox<String> staffSelect;
	JButton btnNewButton;
	JButton btnNewButton_1;
	
	
	
	/**
	 * Create the panel.
	 */
	public StaffManagePanel() {
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 49, 954, 8);
		add(separator);
		
		nameField = new JTextField();
		nameField.setBounds(145, 0, 131, 36);
		add(nameField);
		nameField.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setBounds(290, 0, 113, 36);
		add(btnSearch);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(599, 0, 113, 36);
		add(btnAdd);
		
		staffSelect = new JComboBox<String>();
		staffSelect.setBounds(0, 1, 131, 35);
		add(staffSelect);
		addPackTypeItems();
		
		btnNewButton = new JButton("Revise");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(847, 0, 107, 36);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(726, 0, 107, 36);
		add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 70, 926, 337);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}

	private void addPackTypeItems() {
		staffSelect.addItem("全部");
		for (StaffType staff : StaffType.values()) {
			staffSelect.addItem(staff.getName());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(null)){
			
		}
		
	}
}
