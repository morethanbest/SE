package presentation.centersalesmanui.transferui;

import java.awt.CardLayout;
import java.awt.Component;
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

import org.eclipse.wb.swing.FocusTraversalOnArray;

import businesslogic.logisticsbl.RecordtransPack.CentertransController;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogic.orderbl.CheckExist;
import businesslogicservice.logisticsblservice.RecordtransBlService;
import businesslogicservice.managerblservice.ConstantsBlService;
import businesslogicservice.orderblservice.CheckExistBlService;
import po.Formstate;
import po.ResultMessage;
import presentation.centersalesmanui.CenterSalesmanPanel;
import presentation.enums.TransportTypes;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import presentation.tip.OrderField;
import presentation.tip.TipDialog;
import vo.CityVO;
import vo.RecordtransVO;

public class TransferUpdatePanel extends WorkPanel {
	private MyTextField classField;
	private MyTextField counterField;
	private MyTextField manageField;
	private JTable table;
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyComboBox<String> typeBox;
	private MyComboBox<String> destinBox;
	private MyButton_LightBlue update;
	private MyButton_LightBlue button_1;
	private MyButton_LightBlue button_2;
	private JLabel codeLabel;
	private JLabel departureLabel;
	private MyButton_LightBlue farebutton;
	private RecordtransVO vo;
	private MyTextField fareField;
	private MyButton_LightBlue button;
	private MyButton_LightBlue button_3;
	private RecordtransBlService controller;
	private OrderField orderField;

	/**
	 * Create the panel.
	 */
	public TransferUpdatePanel(CenterSalesmanPanel parent, CardLayout card) {
		controller = new CentertransController();

		setLayout(null);

		codeLabel = new JLabel("");
		codeLabel.setBounds(84, 42, 200, 27);
		add(codeLabel);

		departureLabel = new JLabel("");
		departureLabel.setBounds(385, 154, 208, 27);
		add(departureLabel);

		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(84, 96, 68, 24);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(166, 96, 52, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(232, 96, 52, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		typeBox = new MyComboBox<String>();
		typeBox.setBounds(84, 155, 200, 24);
		add(typeBox);
		addTransportTypeItems();

		classField = new MyTextField();
		classField.setColumns(10);
		classField.setBounds(84, 215, 200, 24);
		add(classField);

		counterField = new MyTextField();
		counterField.setColumns(10);
		counterField.setBounds(385, 43, 208, 24);
		add(counterField);

		manageField = new MyTextField();
		manageField.setColumns(10);
		manageField.setBounds(385, 96, 208, 24);
		add(manageField);

		destinBox = new MyComboBox<String>();
		destinBox.setBounds(385, 215, 208, 24);
		add(destinBox);
		addCityItems(destinBox);

		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				typeBox, yearBox, monthBox, dateBox, classField, counterField,
				update }));

		update = new MyButton_LightBlue("提交修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkFormat())
					return;
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				List<String> barcodes = new ArrayList<String>();
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				int rowCount = tableModel.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					barcodes.add((String) tableModel.getValueAt(i, 0));
				}
				double fare = Double.parseDouble(farebutton.getText());
				ResultMessage r = controller.update(new RecordtransVO(date,
						codeLabel.getText(),
						(String) typeBox.getSelectedItem(), classField
								.getText(), departureLabel.getText(),
						(String) destinBox.getSelectedItem(), counterField
								.getText(), manageField.getText(), barcodes,
						fare, vo.getFormstate()));
				if (r == ResultMessage.success)
					createTip("修改成功！");
				else
					createTip("修改失败！");
			}
		});
		update.setBounds(416, 348, 113, 27);
		add(update);

		JLabel label = new JLabel("运费合计：");
		label.setBounds(303, 274, 82, 18);
		add(label);

		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(636, 25, 276, 222);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "\u672C\u6B21\u88C5\u7BB1\u6240\u6709\u6258\u8FD0\u5355\u53F7" }) {
			boolean[] columnEditables = new boolean[] { false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);

		button_1 = new MyButton_LightBlue("增加一条");
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
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				tableModel.addRow(new String[] { orderField.getText() });
				orderField.setText("");
			}
		});
		button_1.setBounds(813, 252, 99, 27);
		add(button_1);

		button_2 = new MyButton_LightBlue("删除该条");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				int rownum = table.getSelectedRow();
				tableModel.removeRow(rownum);
			}
		});
		button_2.setBounds(636, 286, 276, 27);
		add(button_2);

		fareField = new MyTextField();
		fareField.setText("0");
		fareField.setBounds(399, 270, 66, 27);
		add(fareField);
		fareField.setColumns(10);

		button = new MyButton_LightBlue("恢复原值");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button.setBounds(543, 348, 113, 27);
		add(button);

		button_3 = new MyButton_LightBlue("返回");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent.getSwitcher());
				parent.getTransfer().refreshList();
			}
		});
		button_3.setBounds(670, 348, 113, 27);
		add(button_3);

		orderField = new OrderField();
		orderField.setColumns(10);
		orderField.setBounds(642, 253, 163, 24);
		add(orderField);
		
		JLabel label_1 = new JLabel("中转编号：");
		label_1.setBounds(0, 46, 82, 18);
		add(label_1);
		
		JLabel label_2 = new JLabel("中转日期：");
		label_2.setBounds(0, 99, 82, 18);
		add(label_2);
		
		JLabel label_3 = new JLabel("中转类型：");
		label_3.setBounds(0, 158, 82, 18);
		add(label_3);
		
		JLabel label_4 = new JLabel("班次号：");
		label_4.setBounds(14, 218, 68, 18);
		add(label_4);
		
		JLabel label_5 = new JLabel("运费合计：");
		label_5.setBounds(303, 274, 82, 18);
		add(label_5);
		
		JLabel label_6 = new JLabel("目的地：");
		label_6.setBounds(317, 218, 68, 18);
		add(label_6);
		
		JLabel label_7 = new JLabel("出发地：");
		label_7.setBounds(317, 158, 68, 18);
		add(label_7);
		
		JLabel label_8 = new JLabel("监察员：");
		label_8.setBounds(317, 99, 68, 18);
		add(label_8);
		
		JLabel label_9 = new JLabel("货柜号：");
		label_9.setBounds(317, 46, 68, 18);
		add(label_9);

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

	private void addTransportTypeItems() {
		for (TransportTypes transport : TransportTypes.values()) {
			typeBox.addItem(transport.getName());
		}
	}

	public void addCityItems(JComboBox<String> citySelect) {
		citySelect.removeAllItems();
		ConstantsBlService constantsBlService = new ConstantsController();
		List<CityVO> cityList = constantsBlService.getAllCity();
		for (CityVO city : cityList) {
			citySelect.addItem(city.getName());
		}
	}

	public void init(RecordtransVO vo) {
		this.vo = vo;
		codeLabel.setText(vo.getTranscode());
		yearBox.setSelectedItem(vo.getLoadtime() / 10000);
		monthBox.setSelectedItem((vo.getLoadtime() % 10000) / 100);
		dateBox.setSelectedItem(vo.getLoadtime() % 1000000);
		typeBox.setSelectedItem(vo.getTransportType());
		classField.setText(vo.getTransportCode());
		counterField.setText(vo.getCountercode());
		manageField.setText(vo.getSupervisor());
		departureLabel.setText(vo.getDepartrue());
		destinBox.setSelectedItem(vo.getDestination());
		fareField.setText(Double.toString(vo.getfee()));
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			tableModel.removeRow(i);
		}

		List<String> list = vo.getAllcode();
		for (int i = 0; i < list.size(); i++) {
			tableModel.addRow(new String[] { list.get(i) });
		}

		update.setEnabled(vo.getFormstate() == Formstate.waiting
				|| vo.getFormstate() == Formstate.fail);
	}

	private boolean checkFormat() {
		if (classField.getText().equals(""))
			return createTip("班次号不能为空！");
		else if (counterField.getText().equals(""))
			return createTip("货柜号不能为空！");
		else if (manageField.getText().equals(""))
			return createTip("监察员不能为空！");
		return true;
	}

	private boolean createTip(String str) {
		TipDialog tipDialog = new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);
		return false;
	}
}
