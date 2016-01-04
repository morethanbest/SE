package presentation.managerui.examui.examdepotui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.managerblservice.ExamStockouts;
import po.Formstate;
import presentation.enums.TransportTypes;
import presentation.managerui.examui.ExamPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import vo.StockoutVO;

public class StockoutRevisePanel extends WorkPanel {
	private MyTextField orderField;
	private MyTextField codeField;
	private MyComboBox<String> transportBox;
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> dateBox;
	private MyComboBox<Long> monthBox;
	private MyButton_LightBlue update;
	private ExamStockouts ea;
	private StockoutVO vo;
	private JLabel label;
	private MyButton_LightBlue button;
	private MyButton_LightBlue button_1;

	/**
	 * Create the panel.
	 */
	public StockoutRevisePanel(ExamPanel parent, CardLayout card) {
		ea = new ExamController();
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		orderField = new MyTextField();
		orderField.setColumns(10);
		orderField.setBounds(141, 35, 220, 24);
		add(orderField);

		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(555, 35, 78, 24);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(641, 35, 65, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(710, 35, 65, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		transportBox = new MyComboBox<String>();
		transportBox.setBounds(555, 106, 220, 24);
		add(transportBox);
		addTransportTypeItems();

		codeField = new MyTextField();
		codeField.setColumns(10);
		codeField.setBounds(555, 181, 220, 24);
		add(codeField);

		update = new MyButton_LightBlue("提交修改");
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
		
		label = new JLabel("");
		label.setBounds(141, 106, 220, 24);
		add(label);
		
		button = new MyButton_LightBlue("恢复原值");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button.setBounds(524, 302, 113, 27);
		add(button);
		
		button_1 = new MyButton_LightBlue("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent);
				parent.getOut().refreshList();
			}
		});
		button_1.setBounds(651, 302, 113, 27);
		add(button_1);

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
		label.setText("目的地：" + vo.getDestination());
		yearBox.setSelectedItem(vo.getOuttime() / 10000);
		monthBox.setSelectedItem((vo.getOuttime() % 10000) / 100);
		dateBox.setSelectedItem(vo.getOuttime() % 1000000);
		transportBox.setSelectedItem(vo.getTransportType());
		codeField.setText(vo.getTranscode());
		update.setEnabled(vo.getFormstate() == Formstate.waiting || vo.getFormstate() == Formstate.fail);
		
	}
}
