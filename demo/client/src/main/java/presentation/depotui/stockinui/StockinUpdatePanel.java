package presentation.depotui.stockinui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import businesslogic.commoditybl.InboundPack.InboundController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogic.orderbl.CheckExist;
import businesslogicservice.commodityblservice.InboundBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import businesslogicservice.orderblservice.CheckExistBlService;
import po.CommodityLocation;
import po.Formstate;
import po.ResultMessage;
import presentation.depotui.DepotPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.OrderField;
import presentation.tip.TipDialog;
import vo.OrganizationVO;
import vo.StockinVO;

public class StockinUpdatePanel extends WorkPanel {
	private OrderField codeField;
	private MyButton_LightBlue update;
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyButton_LightBlue button_1;
	private MyButton_LightBlue button_2;
	private InboundBlService controller;
	private StockinVO vo;
	private JLabel label;
	private JLabel label_1;

	/**
	 * Create the panel.
	 */
	public StockinUpdatePanel(DepotPanel parent, CardLayout card) {
		controller = new InboundController();
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		codeField = new OrderField();
		codeField.setBounds(143, 35, 220, 24);
		add(codeField);
		codeField.setColumns(10);

		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(143, 136, 78, 24);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(229, 136, 65, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(298, 136, 65, 24);
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

		update = new MyButton_LightBlue("提交修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				if (checkFormat()) {
					if (controller.update(new StockinVO(vo.getId(), codeField
							.getText(), date, vo.getLocation(), vo
							.getDestination(), vo.getFormstate())) == ResultMessage.success)
						createTip("修改成功！");
					else
						createTip("修改失败！");
				}
			}
		});
		update.setBounds(416, 312, 113, 27);
		add(update);

		button_1 = new MyButton_LightBlue("恢复原值");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button_1.setBounds(543, 312, 113, 27);
		add(button_1);

		button_2 = new MyButton_LightBlue("返回");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent.getSwitcher());
				parent.getInc().refreshList();
			}
		});
		button_2.setBounds(670, 312, 113, 27);
		add(button_2);

		label = new JLabel("");
		label.setBounds(543, 35, 220, 24);
		add(label);

		label_1 = new JLabel("");
		label_1.setBounds(543, 136, 320, 24);
		add(label_1);

		JLabel label_2 = new JLabel("订单编号：");
		label_2.setBounds(58, 38, 86, 18);
		add(label_2);

		JLabel label_3 = new JLabel("入库日期：");
		label_3.setBounds(58, 139, 86, 18);
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

	public void addOrganizationItems(JComboBox<String> orgSelect) {
		OrganizationBlService organizationBlService = new OrganizationController();
		List<OrganizationVO> orgList;
		orgList = organizationBlService.getOrganizationAll();
		for (OrganizationVO org : orgList) {
			orgSelect.addItem(org.getName());
		}
	}

	public void init(StockinVO vo) {
		this.vo = vo;
		codeField.setText(vo.getOrdercode());
		yearBox.setSelectedItem(vo.getIntime() / 10000);
		monthBox.setSelectedItem((vo.getIntime() % 10000) / 100);
		dateBox.setSelectedItem(vo.getIntime() % 100);
		label.setText("目的地：" + vo.getDestination());
		CommodityLocation l = vo.getLocation();
		label_1.setText("区号：" + l.getBlocknum() + " 排号：" + l.getLinenum()
				+ " 架号：" + l.getShelfnum() + " 位号：" + l.getLocationnum());
		update.setEnabled(vo.getFormstate() == Formstate.waiting
				|| vo.getFormstate() == Formstate.fail);
	}

	private boolean checkFormat() {
		CheckExistBlService check = new CheckExist();
		if (codeField.getText().length() != 10) {
			return createTip("订单编号必须为10位！");
		} else if (!check.checkExist(codeField.getText())) {
			return createTip("订单:" + codeField.getText() + " 不存在！");
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
