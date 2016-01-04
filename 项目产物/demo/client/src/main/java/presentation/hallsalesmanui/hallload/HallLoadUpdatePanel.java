package presentation.hallsalesmanui.hallload;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.logisticsbl.HallLoadPack.HallLoadController;
import businesslogic.orderbl.CheckExist;
import businesslogicservice.logisticsblservice.HallLoadBlService;
import businesslogicservice.orderblservice.CheckExistBlService;
import po.Formstate;
import po.ResultMessage;
import presentation.hallsalesmanui.HallsalesmanPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import presentation.tip.DoubleField;
import presentation.tip.NumberField;
import presentation.tip.OrderField;
import presentation.tip.TipDialog;
import vo.HallLoadVO;

public class HallLoadUpdatePanel extends WorkPanel {
	private NumberField carField;
	private MyTextField jianField;
	private MyTextField yaField;
	private JTable table;
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyButton_LightBlue update;
	private HallLoadBlService controller;
	private HallLoadVO vo;
	private JLabel moterLabel;
	private JLabel orgLabel;
	private JLabel destinLabel;
	private DoubleField fareField;
	private OrderField orderField;
	/**
	 * Create the panel.
	 */
	public HallLoadUpdatePanel(HallsalesmanPanel parent, CardLayout card) {
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		controller = new HallLoadController();
		
		orgLabel = new JLabel("");
		orgLabel.setBounds(89, 44, 202, 24);
		add(orgLabel);

		carField = new NumberField(20);
		carField.setColumns(10);
		carField.setBounds(407, 44, 199, 24);
		add(carField);
		
		moterLabel = new JLabel("");
		moterLabel.setBounds(89, 126, 199, 24);
		add(moterLabel);
		
		destinLabel = new JLabel("");
		destinLabel.setBounds(89, 290, 199, 24);
		add(destinLabel);

		jianField = new MyTextField();
		jianField.setColumns(10);
		jianField.setBounds(407, 126, 199, 24);
		add(jianField);

		yaField = new MyTextField();
		yaField.setBounds(407, 214, 199, 24);
		add(yaField);
		yaField.setColumns(10);

		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(89, 214, 69, 24);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(172, 214, 51, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(237, 214, 51, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);
		

		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(636, 25, 276, 222);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "\u672C\u6B21\u88C5\u8F66\u6240\u6709\u6761\u5F62\u7801" }));
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);

		update = new MyButton_LightBlue("提交修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkFormat())
					return;
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				List<String> barcodes = new ArrayList<String>();
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rowCount=tableModel.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					barcodes.add((String) tableModel.getValueAt(i, 0));
				}
				double fare = Double.parseDouble(fareField.getText());
				ResultMessage r = controller.update(new HallLoadVO(date, vo.getStringcode(),
						moterLabel.getText(), vo.getDestination(), carField.getText(),
						jianField.getText(), yaField.getText(), barcodes,
						fare, vo.getDocumentstate()));
				if (r == ResultMessage.success)
					createTip("修改成功！");
				else
					createTip("修改失败！");
			}
		});
		update.setBounds(433, 375, 113, 27);
		add(update);

		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearBox, monthBox, dateBox);
			}
		};
		yearBox.addItemListener(listener);
		monthBox.addItemListener(listener);
		
		
		MyButton_LightBlue button_1 = new MyButton_LightBlue("增加一条");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckExistBlService check = new CheckExist();
				if (orderField.getText().length() != 10) {
					createTip("订单编号必须为10位！");
					return;
				} else if (!check.checkExist(orderField.getText())) {
					createTip("订单:" + orderField.getText() + " 不存在！");
					return;
				}
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.addRow(new String[]{orderField.getText()});
				orderField.setText("");
			}
		});
		button_1.setBounds(851, 252, 61, 27);
		add(button_1);

		MyButton_LightBlue button_2 = new MyButton_LightBlue("删除该条");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rownum = table.getSelectedRow();
				tableModel.removeRow(rownum);
			}
		});
		button_2.setBounds(636, 286, 276, 27);
		add(button_2);
		
		fareField = new DoubleField(20);
		fareField.setText("0");
		fareField.setBounds(407, 290, 86, 24);
		add(fareField);
		fareField.setColumns(10);
		
		MyButton_LightBlue button = new MyButton_LightBlue("恢复原值");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button.setBounds(560, 375, 113, 27);
		add(button);
		
		MyButton_LightBlue button_3 = new MyButton_LightBlue("返回");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent.getSwitcher());
				parent.getHc().refreshList();
			}
		});
		button_3.setBounds(684, 375, 113, 27);
		add(button_3);
		
		JLabel label = new JLabel("机构编号：");
		label.setBounds(14, 44, 85, 18);
		add(label);
		
		JLabel label_1 = new JLabel("汽运编号：");
		label_1.setBounds(14, 126, 85, 18);
		add(label_1);
		
		JLabel label_2 = new JLabel("装车日期：");
		label_2.setBounds(14, 217, 85, 18);
		add(label_2);
		
		JLabel label_3 = new JLabel("目的地：");
		label_3.setBounds(14, 290, 72, 18);
		add(label_3);
		
		JLabel label_4 = new JLabel("车辆代号：");
		label_4.setBounds(324, 47, 82, 18);
		add(label_4);
		
		JLabel label_5 = new JLabel("监装员：");
		label_5.setBounds(337, 126, 69, 18);
		add(label_5);
		
		JLabel label_6 = new JLabel("押运员：");
		label_6.setBounds(337, 217, 69, 18);
		add(label_6);
		
		JLabel label_7 = new JLabel("运费合计：");
		label_7.setBounds(324, 290, 82, 18);
		add(label_7);
		
		orderField = new OrderField();
		orderField.setColumns(10);
		orderField.setBounds(636, 253, 199, 24);
		add(orderField);
		
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
	
	public void init(HallLoadVO vo){
		this.vo = vo;
		orgLabel.setText(vo.getStringcode());
		moterLabel.setText(vo.getMotorcode());
		yearBox.setSelectedItem(vo.getLoadtime() / 10000);
		monthBox.setSelectedItem((vo.getLoadtime() % 10000) / 100);
		dateBox.setSelectedItem(vo.getLoadtime() % 1000000);
		destinLabel.setText(vo.getDestination());
		carField.setText(vo.getVehicldecode());
		jianField.setText(vo.getSupervisor());
		yaField.setText(vo.getSupercargo());
		fareField.setText(vo.getfee() + "");
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			tableModel.removeRow(i);
		}
		List<String> list = vo.getAllbarcode();
		for (int i = 0; i < list.size(); i++) {
			tableModel.addRow(new String[]{list.get(i)});
		}
		
		update.setEnabled(vo.getDocumentstate() == Formstate.waiting || vo.getDocumentstate() == Formstate.fail);
	}
	
	private boolean checkFormat() {
		if (carField.getText().equals(""))
			return createTip("车辆代号不能为空！");
		else if (jianField.getText().equals(""))
			return createTip("监装员不能为空！");
		else if (yaField.getText().equals(""))
			return createTip("押运员不能为空！");
		return true;
	}

	private boolean createTip(String str) {
		TipDialog tipDialog = new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);
		return false;
	}
}
