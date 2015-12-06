package presentation.centersalesmanui.transferui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import businesslogic.logisticsbl.RecordtransPack.CentertransController;
import businesslogicservice.logisticsblservice.RecordtransBlService;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransferPanel extends JPanel {
	private JTextField classField;
	private JTextField counterField;
	private JTextField manageField;
	private JTable table;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JComboBox<String> typeBox;
	private JComboBox<String> destinBox;
	private JButton button;
	private RecordtransBlService recordtransBlService;
	private JButton button_1;
	private JButton button_2;
	private JLabel codeLabel;
	private JLabel departureLabel;
	private JLabel fareLabel;
	private JButton farebutton;

	/**
	 * Create the panel.
	 */
	public TransferPanel(String orgCode, String city) {
		recordtransBlService = new CentertransController();
		
		setLayout(null);
		
		codeLabel = new JLabel("");
		codeLabel.setBounds(14, 12, 242, 27);
		add(codeLabel);
		
		departureLabel = new JLabel("");
		departureLabel.setBounds(351, 147, 242, 27);
		add(departureLabel);
		
		yearBox = new JComboBox<Long>();
		yearBox.setBounds(14, 78, 74, 24);
		add(yearBox);
		
		monthBox = new JComboBox<Long>();
		monthBox.setBounds(112, 78, 61, 24);
		add(monthBox);
		
		dateBox = new JComboBox<Long>();
		dateBox.setBounds(195, 78, 61, 24);
		add(dateBox);
		
		typeBox = new JComboBox<String>();
		typeBox.setBounds(14, 147, 242, 24);
		add(typeBox);
		
		classField = new JTextField();
		classField.setColumns(10);
		classField.setBounds(14, 215, 242, 24);
		add(classField);
		
		counterField = new JTextField();
		counterField.setColumns(10);
		counterField.setBounds(351, 13, 242, 24);
		add(counterField);
		
		manageField = new JTextField();
		manageField.setColumns(10);
		manageField.setBounds(351, 78, 242, 24);
		add(manageField);
		
		destinBox = new JComboBox<String>();
		destinBox.setBounds(351, 215, 242, 24);
		add(destinBox);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{typeBox, yearBox, monthBox, dateBox, classField, counterField, button}));
		
		button = new JButton("提交");
		button.setBounds(416, 348, 113, 27);
		add(button);
		
		farebutton = new JButton("获取运费");
		farebutton.setBounds(153, 348, 97, 27);
		add(farebutton);
		
		JLabel label = new JLabel("运费合计：");
		label.setBounds(14, 352, 82, 18);
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(660, 13, 285, 274);
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
		
		button_1 = new JButton("增加一条");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.addRow(new String[]{""});
			}
		});
		button_1.setBounds(670, 300, 113, 27);
		add(button_1);
		
		button_2 = new JButton("删除该条");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rownum = table.getSelectedRow();
				tableModel.removeRow(rownum);
			}
		});
		button_2.setBounds(823, 300, 113, 27);
		add(button_2);
		
		fareLabel = new JLabel("");
		fareLabel.setBounds(93, 352, 46, 18);
		add(fareLabel);

	}
}
