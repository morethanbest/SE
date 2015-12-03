package presentation.courierui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import vo.ReceptionVO;
import businesslogic.orderbl.ReceptionPack.ReceptionController;
import businesslogicservice.orderblservice.ReceptionBlService;

public class RecievePanel extends JPanel {
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JButton button_1;
	private JButton button;
	private JTextField codeField;
	private JTextField nameField;
	private ReceptionBlService receptionBlService;

	/**
	 * Create the panel.
	 * 
	 * @param courierPanel
	 */
	public RecievePanel(CourierPanel courierPanel) {
		receptionBlService = new ReceptionController();

		setLayout(null);

		nameField = new JTextField();
		nameField.setBounds(105, 112, 229, 30);
		add(nameField);
		nameField.setColumns(10);

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

		codeField = new JTextField();
		codeField.setBounds(105, 199, 229, 30);
		add(codeField);
		codeField.setColumns(10);

		button_1 = new JButton("确认收件");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				receptionBlService.addReception(new ReceptionVO(codeField.getText(), nameField.getText(), date));
			}
			
		});
		button_1.setBounds(163, 419, 113, 27);
		add(button_1);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(105, 293, 79, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(198, 293, 61, 24);
		add(monthBox);
		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(273, 293, 61, 24);
		add(dateBox);
		addDateItems(yearBox, monthBox, dateBox);

		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearBox, monthBox, dateBox);
			}
		};
		yearBox.addItemListener(listener);
		monthBox.addItemListener(listener);
	}

	private void addYearItems(JComboBox<Long> year, JComboBox<Long> month) {
		for (long i = 2000; i <= 2050; i++) {
			year.addItem(i);
		}

		for (long i = 1; i <= 12; i++) {
			month.addItem(i);
		}
	}

	private void addDateItems(JComboBox<Long> yearBox,
			JComboBox<Long> monthBox, JComboBox<Long> dateBox) {
		dateBox.removeAllItems();
		if ((Long) monthBox.getSelectedItem() == 1
				|| (Long) monthBox.getSelectedItem() == 3
				|| (Long) monthBox.getSelectedItem() == 5
				|| (Long) monthBox.getSelectedItem() == 7
				|| (Long) monthBox.getSelectedItem() == 8
				|| (Long) monthBox.getSelectedItem() == 10
				|| (Long) monthBox.getSelectedItem() == 12) {
			for (long i = 1; i <= 31; i++) {
				dateBox.addItem(i);
			}
		} else if ((Long) monthBox.getSelectedItem() == 4
				|| (Long) monthBox.getSelectedItem() == 6
				|| (Long) monthBox.getSelectedItem() == 9
				|| (Long) monthBox.getSelectedItem() == 11) {
			for (long i = 1; i <= 30; i++) {
				dateBox.addItem(i);
			}
		} else {
			for (long i = 1; i <= 28; i++) {
				dateBox.addItem(i);
			}
			if ((Long) yearBox.getSelectedItem() % 4 == 0)
				dateBox.addItem((long) 29);
		}
	}
}
