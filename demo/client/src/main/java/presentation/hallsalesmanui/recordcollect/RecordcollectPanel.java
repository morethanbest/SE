package presentation.hallsalesmanui.recordcollect;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
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

import po.Formstate;
import po.ResultMessage;
import presentation.hallsalesmanui.HallsalesmanPanel;
import presentation.tip.DoubleField;
import presentation.tip.NumberField;
import presentation.tip.OrderField;
import presentation.tip.TipDialog;
import vo.RecordcollectVO;
import businesslogic.balancebl.RecordcollectPack.RecordcollectController;
import businesslogic.orderbl.CheckExist;
import businesslogicservice.balanceblservice.RecordCollectBlService;
import businesslogicservice.orderblservice.CheckExistBlService;

public class RecordcollectPanel extends JPanel implements ActionListener {
	private String orgcode;
	private DoubleField sumField;
	private JTextField manField;
	private NumberField accountField;
	private JComboBox<String> yearSelect;
	private JComboBox<String> monthSelect;
	private JComboBox<String> daySelect;
	private JScrollPane scrollPane;
	private OrderField orderField;
	private JButton btnaddorder;
	private JButton btnhandin;
	private JTable table;
	private RecordcollectVO vo = null;
	private List<String> list = new ArrayList<String>();
	private JButton button;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JButton button_1;

	/**
	 * Create the panel.
	 */
	public RecordcollectPanel(String orgcode, HallsalesmanPanel parent,
			CardLayout card) {
		this.orgcode = orgcode;
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		
		yearSelect = new JComboBox<String>();
		yearSelect.setBounds(186, 96, 80, 21);
		yearSelect.setEditable(false);
		add(yearSelect);
		addyearItem(yearSelect);

		ItemListener startlistener = new ItemListener() { // 用于判断这个月的天数
			@Override
			public void itemStateChanged(ItemEvent e) {
				addDayItem(daySelect, monthSelect, yearSelect);
			}
		};
		monthSelect = new JComboBox<String>();
		monthSelect.setBounds(276, 96, 65, 21);
		monthSelect.setEditable(false);
		add(monthSelect);
		addmonthItem(monthSelect);

		daySelect = new JComboBox<String>();
		daySelect.setBounds(351, 96, 65, 21);
		daySelect.setEditable(false);
		add(daySelect);
		addDayItem(daySelect, monthSelect, yearSelect);

		yearSelect.addItemListener(startlistener);
		monthSelect.addItemListener(startlistener);

		sumField = new DoubleField(12);
		sumField.setBounds(186, 144, 230, 21);
		add(sumField);
		sumField.setColumns(10);

		manField = new JTextField();
		manField.setBounds(186, 187, 230, 21);
		add(manField);
		manField.setColumns(10);

		accountField = new NumberField(12);
		accountField.setBounds(186, 235, 230, 21);
		add(accountField);
		accountField.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(611, 38, 304, 252);
		add(scrollPane);

		orderField = new OrderField();
		orderField.setBounds(611, 302, 199, 25);
		add(orderField);
		orderField.setColumns(10);

		btnaddorder = new JButton("增加订单");
		btnaddorder.setBounds(822, 301, 93, 27);
		add(btnaddorder);

		btnhandin = new JButton("提交");
		btnhandin.setBounds(374, 404, 93, 23);
		add(btnhandin);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u8BA2\u5355\u53F7" }) {
			boolean[] columnEditables = new boolean[] { false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(1);
		tableModel.setRowCount(0);

		scrollPane.setViewportView(table);
		btnaddorder.addActionListener(this);
		btnhandin.addActionListener(this);

		button = new JButton("查看已提交单据");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(parent.getSwitcher());
				parent.getRc().refreshList();
			}
		});
		button.setBounds(701, 402, 137, 27);
		add(button);

		label = new JLabel("收款信息：");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(42, 38, 80, 32);
		add(label);

		label_1 = new JLabel("收款日期：");
		label_1.setBounds(42, 99, 80, 15);
		add(label_1);

		label_2 = new JLabel("收款金额：");
		label_2.setBounds(42, 144, 80, 15);
		add(label_2);

		label_3 = new JLabel("收款人：");
		label_3.setBounds(42, 190, 70, 15);
		add(label_3);

		label_4 = new JLabel("收款账号：");
		label_4.setBounds(42, 238, 80, 15);
		add(label_4);

		button_1 = new JButton("删除该条");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				int rownum = table.getSelectedRow();
				tableModel.removeRow(rownum);
			}
		});
		button_1.setBounds(611, 337, 304, 27);
		add(button_1);
	}

	private void addyearItem(JComboBox<String> yearselect) {
		for (int i = 2000; i < 2100; i++) {
			yearselect.addItem(Integer.toString(i));
		}
	}

	private void addmonthItem(JComboBox<String> monthselect) {
		for (int i = 1; i <= 9; i++) {
			monthselect.addItem("0" + Integer.toString(i));
		}
		for (int i = 10; i <= 12; i++) {
			monthselect.addItem(Integer.toString(i));
		}
	}

	private void addDayItem(JComboBox<String> dayselect,
			JComboBox<String> monthselect, JComboBox<String> yearselect) {
		dayselect.removeAllItems();

		// 得到这个月的天数
		int days = getDays(
				Integer.parseInt((String) yearselect.getSelectedItem()),
				Integer.parseInt((String) monthselect.getSelectedItem()));

		for (int i = 1; i <= 9; i++) {
			dayselect.addItem("0" + Integer.toString(i));
		}
		for (int i = 10; i <= days; i++) {
			dayselect.addItem(Integer.toString(i));
		}
	}

	public boolean isleap(Integer year) {
		if (year % 400 == 0) {
			return true;
		} else if (year % 100 == 0) {
			return false;
		} else if (year % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int getDays(Integer year, Integer month) { // 得到这个月的天数
		int day[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if (month == 2 && isleap(year)) {
			return 29;
		}
		return day[month - 1];
	}

	private ResultMessage handin() {
		RecordCollectBlService recordCollectBlService = new RecordcollectController();
		return recordCollectBlService.Recordcollect(vo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(btnaddorder)) {
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
		} else if (e.getSource().equals(btnhandin)) {
			if (!checkFormat())
				return;
			RecordCollectBlService recordCollectBlService = new RecordcollectController();
			String id = recordCollectBlService.getid(orgcode);
			long collectiontime = Long.parseLong((String) yearSelect
					.getSelectedItem()
					+ monthSelect.getSelectedItem()
					+ daySelect.getSelectedItem());
			double collectionsum = Double.parseDouble(sumField.getText());
			String collectionman = manField.getText();
			String accountcode = accountField.getText();

			vo = new RecordcollectVO(id, collectiontime, accountcode,
					collectionsum, collectionman, list, Formstate.waiting);
			ResultMessage r = handin();
			if (r == ResultMessage.success)
				addSucess();
			else
				createTip("添加失败！");
		}

	}

	private boolean checkFormat() {
		if (sumField.getText().equals(""))
			return createTip("收款金额不能为空！");
		else if (manField.getText().equals(""))
			return createTip("收款人不能为空！");
		else if (accountField.getText().equals(""))
			return createTip("收款账号不能为空！");
		return true;
	}

	private void addSucess() {
		createTip("添加成功！");
		sumField.setText("");
		manField.setText("");
		accountField.setText("");
		list.removeAll(list);
		vo = null;
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		for (int i = list.size() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}

	private boolean createTip(String str) {
		TipDialog tipDialog = new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);
		return false;
	}
}
