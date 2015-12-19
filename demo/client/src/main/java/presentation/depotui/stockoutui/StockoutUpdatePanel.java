package presentation.depotui.stockoutui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.Formstate;
import presentation.depotui.DepotPanel;
import presentation.enums.TransportTypes;
import presentation.tip.NumberField;
import presentation.tip.OrderField;
import vo.StockoutVO;
import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.managerblservice.ExamStockouts;

public class StockoutUpdatePanel extends JPanel {
	private OrderField orderField;
	private NumberField codeField;
	private JComboBox<String> transportBox;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> dateBox;
	private JComboBox<Long> monthBox;
	private JButton update;
	private ExamStockouts ea;
	private StockoutVO vo;
	private JLabel destinLabel;
	private JButton button;
	private JButton button_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;

	/**
	 * Create the panel.
	 */
	public StockoutUpdatePanel(DepotPanel parent, CardLayout card) {
		ea = new ExamController();
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		orderField = new OrderField();
		orderField.setColumns(10);
		orderField.setBounds(141, 35, 220, 24);
		add(orderField);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(555, 35, 78, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(641, 35, 65, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(710, 35, 65, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		transportBox = new JComboBox<String>();
		transportBox.setBounds(555, 106, 220, 24);
		add(transportBox);
		addTransportTypeItems();

		codeField = new NumberField(19);
		codeField.setColumns(10);
		codeField.setBounds(555, 181, 220, 24);
		add(codeField);

		update = new JButton("提交修改");
		update.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				ea.updateStockoutForm(new StockoutVO(vo.getId(), orderField.getText(), date,
						vo.getDestination(),
						(String) transportBox.getSelectedItem(), codeField
								.getText(), vo.getFormstate()));
			}
		});
		update.setBounds(397, 302, 113, 27);
		add(update);

		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearBox, monthBox, dateBox);
			}
		};
		yearBox.addItemListener(listener);
		monthBox.addItemListener(listener);
		
		destinLabel = new JLabel("");
		destinLabel.setBounds(78, 106, 283, 24);
		add(destinLabel);
		
		button = new JButton("恢复原值");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button.setBounds(524, 302, 113, 27);
		add(button);
		
		button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent.getSwitcher());
				parent.getOutc().refreshList();
			}
		});
		button_1.setBounds(651, 302, 113, 27);
		add(button_1);
		
		label = new JLabel("订单编号：");
		label.setBounds(57, 38, 86, 18);
		add(label);
		
		label_1 = new JLabel("中转类型：");
		label_1.setBounds(474, 109, 82, 18);
		add(label_1);
		
		label_2 = new JLabel("单据编号：");
		label_2.setBounds(474, 184, 82, 18);
		add(label_2);
		
		label_3 = new JLabel("出库日期：");
		label_3.setBounds(474, 38, 82, 18);
		add(label_3);

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
	private void addTransportTypeItems() {
		for (TransportTypes transport : TransportTypes.values()) {
			transportBox.addItem(transport.getName());
		}
	}
	
	public void init(StockoutVO vo){
		orderField.setText(vo.getOrdercode());
		destinLabel.setText("目的地：" + vo.getDestination());
		yearBox.setSelectedItem(vo.getOuttime() / 10000);
		monthBox.setSelectedItem((vo.getOuttime() % 10000) / 100);
		dateBox.setSelectedItem(vo.getOuttime() % 100);
		transportBox.setSelectedItem(vo.getTransportType());
		codeField.setText(vo.getTranscode());
		update.setEnabled(vo.getFormstate() == Formstate.waiting || vo.getFormstate() == Formstate.fail);
		
	}
}
