package presentation.centersalesmanui.transferui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TransferPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TransferPanel() {
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(14, 13, 242, 24);
		add(textField);
		
		JComboBox<Long> comboBox = new JComboBox<Long>();
		comboBox.setBounds(14, 78, 74, 24);
		add(comboBox);
		
		JComboBox<Long> comboBox_1 = new JComboBox<Long>();
		comboBox_1.setBounds(112, 78, 61, 24);
		add(comboBox_1);
		
		JComboBox<Long> comboBox_2 = new JComboBox<Long>();
		comboBox_2.setBounds(195, 78, 61, 24);
		add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(14, 147, 242, 24);
		add(comboBox_3);
		
		JButton button = new JButton("提交");
		button.setBounds(416, 348, 113, 27);
		add(button);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(14, 215, 242, 24);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(351, 13, 242, 24);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(351, 78, 242, 24);
		add(textField_3);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(351, 147, 242, 24);
		add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(351, 215, 242, 24);
		add(comboBox_6);
		
		JLabel label = new JLabel("运费合计：");
		label.setBounds(80, 352, 113, 18);
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(660, 13, 285, 310);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u672C\u6B21\u88C5\u7BB1\u6240\u6709\u6258\u8FD0\u5355\u53F7"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox_3, textField, comboBox, comboBox_1, comboBox_2, textField_1, textField_2, button}));

	}
}
