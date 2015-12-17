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
import init.ClientInitException;
import init.RMIHelper;
import presentation.mainui.MainFrame;

import java.awt.SystemColor;
import java.awt.Color;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class RecievePanel extends JPanel {
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JButton button_1;
	private JButton button;
	private JTextField codeField;
	private JTextField nameField;
	private ReceptionBlService receptionBlService;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JButton button_2;

	/**
	 * Create the panel.
	 * 
	 * @param courierPanel
	 */
	public RecievePanel(CourierPanel courierPanel) {
		setBackground(new Color(244, 247, 252));
		receptionBlService = new ReceptionController();

		setLayout(null);

		nameField = new JTextField();
		nameField.setBounds(218, 112, 229, 30);
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
		button.setBounds(650, 10, 145, 42);
		add(button);

		codeField = new JTextField();
		codeField.setBounds(218, 199, 229, 30);
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
		button_1.setBounds(293, 416, 113, 27);
		add(button_1);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(218, 293, 79, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(311, 293, 61, 24);
		add(monthBox);
		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(386, 293, 61, 24);
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
		
		Calendar c = Calendar.getInstance();
		yearBox.setSelectedItem((long)c.get(Calendar.YEAR));
		monthBox.setSelectedItem((long)c.get(Calendar.MONTH) + 1);
		dateBox.setSelectedItem((long)c.get(Calendar.DAY_OF_MONTH));
		
		label = new JLabel("收件人：");
		label.setBounds(132, 118, 72, 18);
		add(label);
		
		label_1 = new JLabel("订单编号：");
		label_1.setBounds(117, 205, 79, 18);
		add(label_1);
		
		label_2 = new JLabel("收件日期：");
		label_2.setBounds(117, 296, 87, 18);
		add(label_2);
		
		button_2 = new JButton("注销");
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
			           RMIHelper.init();
			           MainFrame frame= new MainFrame();
			           frame.start();
			        } catch (ClientInitException e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(
			                    null,
			                    "Client boots fail!\nCause: " + e1.getMessage(),
			                    "Fatal Error",
			                    JOptionPane.ERROR_MESSAGE
			            );
			        }
			}
		});
		button_2.setBounds(823, 10, 145, 42);
		add(button_2);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{nameField, codeField, yearBox, monthBox, dateBox}));
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
