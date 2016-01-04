package presentation.hallsalesmanui.delivery;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import businesslogic.logisticsbl.DeliveryPack.DeliveryController;
import businesslogic.orderbl.CheckExist;
import businesslogicservice.logisticsblservice.DeliveryBlService;
import businesslogicservice.orderblservice.CheckExistBlService;
import po.Formstate;
import po.ResultMessage;
import presentation.hallsalesmanui.HallsalesmanPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.TipDialog;
import vo.DeliveryVO;

public class DeliveryUpdatePanel extends WorkPanel {
	private MyTextField codeField;
	private MyTextField deliveryField;
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyButton_LightBlue update;
	private DeliveryBlService controller;
	private DeliveryVO vo;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Create the panel.
	 */
	public DeliveryUpdatePanel(HallsalesmanPanel parent, CardLayout card) {
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		controller = new DeliveryController();

		codeField = new MyTextField();
		codeField.setColumns(10);
		codeField.setBounds(286, 82, 242, 24);
		add(codeField);

		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(286, 141, 74, 24);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(384, 141, 61, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(467, 141, 61, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		deliveryField = new MyTextField();
		deliveryField.setColumns(10);
		deliveryField.setBounds(286, 204, 242, 24);
		add(deliveryField);

		update = new MyButton_LightBlue("提交");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkFormat())
					return;
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				ResultMessage r = controller.update(new DeliveryVO(vo.getid(),
						date, codeField.getText(), deliveryField.getText(), vo
								.getDocumentstate()));
				if (r == ResultMessage.success)
					createTip("修改成功！");
				else
					createTip("修改失败！");
			}
		});
		update.setBounds(359, 276, 113, 27);
		add(update);

		MyButton_LightBlue button_1 = new MyButton_LightBlue("恢复原值");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button_1.setBounds(486, 276, 113, 27);
		add(button_1);

		MyButton_LightBlue button_2 = new MyButton_LightBlue("返回");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent.getSwitcher());
				parent.getDc().refreshList();
			}
		});
		button_2.setBounds(613, 276, 113, 27);
		add(button_2);
		
		label = new JLabel("派件日期：");
		label.setBounds(199, 144, 86, 18);
		add(label);
		
		label_1 = new JLabel("订单编号：");
		label_1.setBounds(199, 85, 86, 18);
		add(label_1);
		
		label_2 = new JLabel("派件员：");
		label_2.setBounds(211, 207, 74, 18);
		add(label_2);

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

	public void init(DeliveryVO vo) {
		this.vo = vo;
		codeField.setText(vo.getBarcode());
		yearBox.setSelectedItem(vo.getArrivaltime() / 10000);
		monthBox.setSelectedItem((vo.getArrivaltime() % 10000) / 100);
		dateBox.setSelectedItem(vo.getArrivaltime() % 1000000);
		deliveryField.setText(vo.getDelivorinfo());
		update.setEnabled(vo.getDocumentstate() == Formstate.waiting
				|| vo.getDocumentstate() == Formstate.fail);
	}

	private boolean checkFormat() {
		CheckExistBlService check = new CheckExist();
		if (codeField.getText().length() != 10) {
			return createTip("订单编号必须为10位！");
		} else if (!check.checkExist(codeField.getText())) {
			return createTip("订单:" + codeField.getText() + " 不存在！");
		} else if (deliveryField.getText().equals("")) {
			return createTip("派件员不能为空！");
		}
		return true;
	}

	private boolean createTip(String str) {
		TipDialog tipDialog = new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);
		return false;
	}
}
