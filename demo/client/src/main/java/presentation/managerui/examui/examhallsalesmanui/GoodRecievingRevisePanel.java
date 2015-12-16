package presentation.managerui.examui.examhallsalesmanui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.Arrivalstate;
import po.Formstate;
import presentation.managerui.examui.ExamPanel;
import vo.GoodsReceivingVO;
import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.managerblservice.ExamGoodsRecevings;

public class GoodRecievingRevisePanel extends JPanel {
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JComboBox<String> stateBox;
	private JButton update;
	private ExamGoodsRecevings ea;
	private GoodsReceivingVO vo;
	private JTextField codeField;
	private JComboBox<String> typeBox;
	private JLabel depatLabel;
	private JButton button_1;
	private JButton button_2;

	/**
	 * Create the panel.
	 */
	public GoodRecievingRevisePanel(ExamPanel parent, CardLayout card) {
		ea = new ExamController();
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		codeField = new JTextField();
		codeField.setBounds(140, 230, 242, 24);
		add(codeField);
		codeField.setColumns(10);
		
		depatLabel = new JLabel("");
		depatLabel.setBounds(518, 70, 242, 18);
		add(depatLabel);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(140, 67, 74, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(238, 67, 61, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(321, 67, 61, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		stateBox = new JComboBox<String>();
		stateBox.setBounds(518, 149, 242, 24);
		add(stateBox);
		addStateTypeItems();

		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearBox, monthBox, dateBox);
			}
		};
		yearBox.addItemListener(listener);
		monthBox.addItemListener(listener);

		Calendar c = Calendar.getInstance();
		yearBox.setSelectedItem((long) c.get(Calendar.YEAR));
		monthBox.setSelectedItem((long) c.get(Calendar.MONTH) + 1);
		dateBox.setSelectedItem((long) c.get(Calendar.DAY_OF_MONTH));

		typeBox = new JComboBox<String>();
		typeBox.setBounds(140, 149, 242, 24);
		add(typeBox);
		addTypeItems();

		update = new JButton("提交修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				ea.updateGoodsReceivingForm(new GoodsReceivingVO(
						vo.getid(), date,typeBox.getSelectedIndex() == 1 ,codeField
								.getText(),vo.getDeparture(),
						getStateType((String) stateBox.getSelectedItem()),
						vo.getFormstate()));
			}
		});
		update.setBounds(423, 336, 113, 27);
		add(update);
		
		button_1 = new JButton("恢复原值");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button_1.setBounds(550, 336, 113, 27);
		add(button_1);
		
		button_2 = new JButton("返回");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent);
				parent.getGr().refreshList();
			}
		});
		button_2.setBounds(677, 336, 113, 27);
		add(button_2);
	}

	private void addTypeItems() {
		typeBox.addItem("中转中心-装车单编号");
		typeBox.addItem("营业厅-汽运编号");
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

	private void addStateTypeItems() {
		for (Arrivalstate state : Arrivalstate.values()) {
			stateBox.addItem(state.getName());
		}
	}

	private Arrivalstate getStateType(String str) {
		for (Arrivalstate state : Arrivalstate.values()) {
			if (state.getName().equals(str)) {
				return state;
			}
		}
		return null;
	}
	public void init(GoodsReceivingVO vo){
		this.vo = vo;
		yearBox.setSelectedItem(vo.getArrivaltime() / 10000);
		monthBox.setSelectedItem((vo.getArrivaltime() % 10000) / 100);
		dateBox.setSelectedItem(vo.getArrivaltime() % 1000000);
		if(vo.getwhefromhalll())
			typeBox.setSelectedIndex(1);
		else
			typeBox.setSelectedIndex(0);
		codeField.setText(vo.getTranscode());
		depatLabel.setText("出发地：" + vo.getDeparture());
		stateBox.setSelectedItem(vo.getArrivalstate());
		
		update.setEnabled(vo.getFormstate() == Formstate.waiting || vo.getFormstate() == Formstate.fail);
	}

}