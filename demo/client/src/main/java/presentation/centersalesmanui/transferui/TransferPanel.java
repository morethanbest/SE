package presentation.centersalesmanui.transferui;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import po.Formstate;
import po.ResultMessage;
import presentation.centersalesmanui.CenterSalesmanPanel;
import presentation.enums.TransportTypes;
import presentation.tip.TipDialog;
import vo.CityVO;
import vo.RecordtransVO;
import businesslogic.logisticsbl.RecordtransPack.CentertransController;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogic.orderbl.CheckExist;
import businesslogicservice.logisticsblservice.RecordtransBlService;
import businesslogicservice.managerblservice.ConstantsBlService;
import businesslogicservice.orderblservice.CheckExistBlService;
import presentation.tip.OrderField;

public class TransferPanel extends JPanel {
	private JTextField classField;
	private JTextField counterField;
	private JTextField manageField;
	private JTable table;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JComboBox<String> typeBox;
	private JComboBox<String> destinBox;
	private JButton button;
	private RecordtransBlService recordtransBlService;
	private JButton button_1;
	private JButton button_2;
	private JLabel codeLabel;
	private JLabel departureLabel;
	private JLabel fareLabel;
	private JButton farebutton;
	private JButton button_3;

	private String orgCode;
	private OrderField orderField;

	/**
	 * Create the panel.
	 */
	public TransferPanel(String orgCode, String city,
			CenterSalesmanPanel parent, CardLayout card) {
		this.orgCode = orgCode;
		recordtransBlService = new CentertransController();

		setLayout(null);

		codeLabel = new JLabel("");
		codeLabel.setBounds(84, 42, 200, 27);
		add(codeLabel);

		departureLabel = new JLabel(city);
		departureLabel.setBounds(385, 154, 208, 27);
		add(departureLabel);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(84, 96, 68, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(166, 96, 52, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(232, 96, 52, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		typeBox = new JComboBox<String>();
		typeBox.setBounds(84, 155, 200, 24);
		add(typeBox);
		addTransportTypeItems();

		classField = new JTextField();
		classField.setColumns(10);
		classField.setBounds(84, 215, 200, 24);
		add(classField);

		counterField = new JTextField();
		counterField.setColumns(10);
		counterField.setBounds(385, 43, 208, 24);
		add(counterField);

		manageField = new JTextField();
		manageField.setColumns(10);
		manageField.setBounds(385, 96, 208, 24);
		add(manageField);

		destinBox = new JComboBox<String>();
		destinBox.setBounds(385, 215, 208, 24);
		add(destinBox);
		addCityItems(destinBox);

		button = new JButton("提交");
		button.addActionListener(new ActionListener() {
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
				double fare = Double.parseDouble(fareLabel.getText());
				ResultMessage r = recordtransBlService
						.Recordtrans(new RecordtransVO(date, codeLabel
								.getText(), (String) typeBox.getSelectedItem(),
								classField.getText(), departureLabel.getText(),
								(String) destinBox.getSelectedItem(),
								counterField.getText(), manageField.getText(),
								barcodes, fare, Formstate.waiting));
				if (r == ResultMessage.success)
					addSucess();
				else
					createTip("添加失败！");
			}
		});
		button.setBounds(416, 348, 113, 27);
		add(button);

		farebutton = new JButton("获取运费");
		farebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkFormat())
					return;
				List<String> barcodes = new ArrayList<String>();
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				int rowCount = tableModel.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					barcodes.add((String) tableModel.getValueAt(i, 0));
				}
				fareLabel.setText(recordtransBlService.getfee(barcodes,
						departureLabel.getText(),
						(String) destinBox.getSelectedItem(),
						(String) typeBox.getSelectedItem())
						+ "");

			}
		});
		farebutton.setBounds(496, 270, 97, 27);
		add(farebutton);

		JLabel label = new JLabel("运费合计：");
		label.setBounds(303, 274, 82, 18);
		add(label);

		JScrollPane scrollPane = new JScrollPane();
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

		button_1 = new JButton("增加一条");
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
			}
		});

		orderField = new OrderField();
		orderField.setColumns(10);
		orderField.setBounds(636, 253, 199, 24);
		add(orderField);
		button_1.setBounds(851, 252, 61, 27);
		add(button_1);

		button_2 = new JButton("删除该条");
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

		fareLabel = new JLabel("0");
		fareLabel.setBounds(399, 270, 66, 27);
		add(fareLabel);

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
		Long date = (Long) yearBox.getSelectedItem() * 10000
				+ (Long) monthBox.getSelectedItem() * 100
				+ (Long) dateBox.getSelectedItem();
		codeLabel.setText(recordtransBlService.getid(orgCode, date));

		button_3 = new JButton("查看已提交单据");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(parent.getSwitcher());
				parent.getTransfer().refreshList();
			}
		});
		button_3.setBounds(728, 348, 149, 27);
		add(button_3);

		JLabel label_1 = new JLabel("目的地：");
		label_1.setBounds(317, 218, 68, 18);
		add(label_1);

		JLabel label_2 = new JLabel("出发地：");
		label_2.setBounds(317, 158, 68, 18);
		add(label_2);

		JLabel label_3 = new JLabel("监察员：");
		label_3.setBounds(317, 99, 68, 18);
		add(label_3);

		JLabel label_4 = new JLabel("货柜号：");
		label_4.setBounds(317, 46, 68, 18);
		add(label_4);

		JLabel label_5 = new JLabel("中转编号：");
		label_5.setBounds(0, 46, 82, 18);
		add(label_5);

		JLabel label_6 = new JLabel("中转日期：");
		label_6.setBounds(0, 99, 82, 18);
		add(label_6);

		JLabel label_7 = new JLabel("中转类型：");
		label_7.setBounds(0, 158, 82, 18);
		add(label_7);

		JLabel label_8 = new JLabel("班次号：");
		label_8.setBounds(14, 218, 68, 18);
		add(label_8);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				yearBox, monthBox, dateBox, typeBox, classField, counterField,
				manageField, destinBox }));
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

	private boolean checkFormat() {
		if (classField.getText().equals(""))
			return createTip("班次号不能为空！");
		else if (counterField.getText().equals(""))
			return createTip("货柜号不能为空！");
		else if (manageField.getText().equals(""))
			return createTip("监察员不能为空！");
		else {
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int rowCount = tableModel.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				if ((String) tableModel.getValueAt(i, 0) == "")
					;
			}
		}
		return true;
	}

	private void addSucess() {
		createTip("添加成功！");
		classField.setText("");
		counterField.setText("");
		manageField.setText("");
		Long date = (Long) yearBox.getSelectedItem() * 10000
				+ (Long) monthBox.getSelectedItem() * 100
				+ (Long) dateBox.getSelectedItem();
		codeLabel.setText(recordtransBlService.getid(orgCode, date));
	}

	private boolean createTip(String str) {
		TipDialog tipDialog = new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);
		return false;
	}
}
