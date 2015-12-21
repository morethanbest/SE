package presentation.hallsalesmanui.recordcollect;

import java.awt.CardLayout;
import java.awt.Font;
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

public class RecordcollectUpdatePanel extends JPanel implements ActionListener {
	private String orgcode;
	private DoubleField sumField;
	private JTextField manField;
	private NumberField accountField;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dayBox;
	private JScrollPane scrollPane;
	private OrderField orderField;
	private JButton btnaddorder;
	private JButton update;
	private JTable table;
	private RecordcollectVO vo;
	private JButton button;
	private JButton button_1;
	private RecordCollectBlService controller;

	/**
	 * Create the panel.
	 */
	public RecordcollectUpdatePanel(HallsalesmanPanel parent, CardLayout card) {
		controller = new RecordcollectController();
		setLayout(null);

		JLabel label = new JLabel("收款信息：");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(42, 38, 80, 32);
		add(label);

		JLabel label_1 = new JLabel("收款日期：");
		label_1.setBounds(42, 99, 80, 15);
		add(label_1);

		JLabel label_2 = new JLabel("收款金额：");
		label_2.setBounds(42, 144, 80, 15);
		add(label_2);

		JLabel label_3 = new JLabel("收款人：");
		label_3.setBounds(42, 190, 70, 15);
		add(label_3);

		JLabel label_4 = new JLabel("收款账号：");
		label_4.setBounds(42, 238, 80, 15);
		add(label_4);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(186, 96, 80, 21);
		yearBox.setEditable(false);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(276, 96, 65, 21);
		monthBox.setEditable(false);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dayBox = new JComboBox<Long>();
		dayBox.setBounds(351, 96, 65, 21);
		dayBox.setEditable(false);
		add(dayBox);

		addDateItems(yearBox, monthBox, dayBox);

		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearBox, monthBox, dayBox);
			}
		};
		yearBox.addItemListener(listener);
		monthBox.addItemListener(listener);

		sumField = new DoubleField(10);
		sumField.setBounds(186, 144, 230, 21);
		add(sumField);
		sumField.setColumns(10);

		manField = new JTextField();
		manField.setBounds(186, 187, 230, 21);
		add(manField);
		manField.setColumns(10);

		accountField = new NumberField(10);
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

		update = new JButton("提交修改");
		update.setBounds(351, 403, 112, 25);
		add(update);

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
		update.addActionListener(this);

		button = new JButton("恢复原值");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button.setBounds(477, 402, 113, 27);
		add(button);

		button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent.getSwitcher());
				parent.getRc().refreshList();
			}
		});
		button_1.setBounds(611, 402, 113, 27);
		add(button_1);

		JButton button_2 = new JButton("删除该条");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				int rownum = table.getSelectedRow();
				tableModel.removeRow(rownum);
			}
		});
		button_2.setBounds(611, 337, 304, 27);
		add(button_2);
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
		} else if (e.getSource().equals(update)) {
			if (!checkFormat())
				return;
			String id = controller.getid(orgcode);
			Long date = (Long) yearBox.getSelectedItem() * 10000
					+ (Long) monthBox.getSelectedItem() * 100
					+ (Long) dayBox.getSelectedItem();
			double collectionsum = Double.parseDouble(sumField.getText());
			String collectionman = manField.getText();
			String accountcode = accountField.getText();
			List<String> barcodes = new ArrayList<String>();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int rowCount = tableModel.getRowCount();
			for (int i = 0; i < rowCount; i++) {
				barcodes.add((String) tableModel.getValueAt(i, 0));
			}
			RecordcollectVO temp = new RecordcollectVO(id, date, accountcode,
					collectionsum, collectionman, barcodes, vo.getFormstate());
			ResultMessage r = controller.updateCollect(temp);
			if (r == ResultMessage.success)
				createTip("修改成功！");
			else
				createTip("修改失败！");
		}
	}

	public void init(RecordcollectVO vo) {
		this.vo = vo;
		yearBox.setSelectedItem(vo.getCollectiontime() / 10000);
		monthBox.setSelectedItem((vo.getCollectiontime() % 10000) / 100);
		dayBox.setSelectedItem(vo.getCollectiontime() % 100);
		sumField.setText(vo.getCollectionsum() + "");
		manField.setText(vo.getCollectionman());
		accountField.setText(vo.getAccountcode());

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		List<String> list = vo.getAllordercode();
		for (int i = 0; i < list.size(); i++) {
			tableModel.addRow(new String[] { list.get(i) });
		}

		update.setEnabled(vo.getFormstate() == Formstate.waiting
				|| vo.getFormstate() == Formstate.fail);
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

	private boolean createTip(String str) {
		TipDialog tipDialog = new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);
		return false;
	}
}
