package presentation.hallsalesmanui.delivery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.Formstate;
import vo.DeliveryVO;
import businesslogic.logisticsbl.DeliveryPack.DeliveryController;
import businesslogicservice.logisticsblservice.DeliveryBlService;

public class DeliveryPanel extends JPanel {
	private JTextField codeField;
	private JTextField deliveryField;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JButton button;
	private DeliveryBlService deliveryBlService;

	/**
	 * Create the panel.
	 */
	public DeliveryPanel(String orgCode) {
		setLayout(null);

		deliveryBlService = new DeliveryController();

		codeField = new JTextField();
		codeField.setColumns(10);
		codeField.setBounds(286, 82, 242, 24);
		add(codeField);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(286, 141, 74, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(384, 141, 61, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(467, 141, 61, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		deliveryField = new JTextField();
		deliveryField.setColumns(10);
		deliveryField.setBounds(286, 204, 242, 24);
		add(deliveryField);

		button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				deliveryBlService.Delivery(new DeliveryVO(deliveryBlService
						.findID(orgCode), date, codeField.getText(),
						deliveryField.getText(), Formstate.waiting));
			}
		});
		button.setBounds(359, 276, 113, 27);
		add(button);

		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearBox, monthBox, dateBox);
			}
		};
		yearBox.addItemListener(listener);
		monthBox.addItemListener(listener);

		Calendar c = Calendar.getInstance();
		yearBox.setSelectedItem((long)c.get(Calendar.YEAR));
		monthBox.setSelectedItem((long)c.get(Calendar.MONTH) + 1);
		dateBox.setSelectedItem((long)c.get(Calendar.DAY_OF_MONTH));

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
