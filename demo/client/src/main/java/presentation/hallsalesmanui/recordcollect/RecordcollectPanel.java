package presentation.hallsalesmanui.recordcollect;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.accountbl.AccountPack.AccountController;
import businesslogic.balancebl.RecordcollectPack.RecordcollectController;
import businesslogic.orderbl.CheckExist;
import businesslogicservice.accountblservice.AccountBlService;
import businesslogicservice.balanceblservice.RecordCollectBlService;
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
import vo.RecordcollectVO;

public class RecordcollectPanel extends WorkPanel implements ActionListener {
	private String orgcode;
	private DoubleField sumField;
	private MyTextField manField;
	private NumberField accountField;
	private MyComboBox<Long> yearSelect;
	private MyComboBox<Long> monthSelect;
	private MyComboBox<Long> daySelect;
	private MyScrollPane scrollPane;
	private OrderField orderField;
	private MyButton_LightBlue btnaddorder;
	private MyButton_LightBlue btnhandin;
	private JTable table;
	private RecordcollectVO vo = null;
	private List<String> list = new ArrayList<String>();
	private MyButton_LightBlue button;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private MyButton_LightBlue button_1;

	/**
	 * Create the panel.
	 */
	public RecordcollectPanel(String orgcode, HallsalesmanPanel parent,
			CardLayout card) {
		this.orgcode = orgcode;
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		
		yearSelect = new MyComboBox<Long>();
		yearSelect.setBounds(186, 96, 80, 21);
		yearSelect.setEditable(false);
		add(yearSelect);

		monthSelect = new MyComboBox<Long>();
		monthSelect.setBounds(276, 96, 65, 21);
		monthSelect.setEditable(false);
		add(monthSelect);
		
		addYearItems(yearSelect, monthSelect);

		daySelect = new MyComboBox<Long>();
		daySelect.setBounds(351, 96, 65, 21);
		daySelect.setEditable(false);
		add(daySelect);
		addDateItems(yearSelect, monthSelect, daySelect);
		
		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearSelect, monthSelect, daySelect);
			}
		};
		yearSelect.addItemListener(listener);
		monthSelect.addItemListener(listener);
		
		Calendar c = Calendar.getInstance();
		yearSelect.setSelectedItem((long) c.get(Calendar.YEAR));
		monthSelect.setSelectedItem((long) c.get(Calendar.MONTH) + 1);
		daySelect.setSelectedItem((long) c.get(Calendar.DAY_OF_MONTH));

		sumField = new DoubleField(12);
		sumField.setBounds(186, 144, 230, 21);
		add(sumField);
		sumField.setColumns(10);

		manField = new MyTextField();
		manField.setBounds(186, 187, 230, 21);
		add(manField);
		manField.setColumns(10);

		accountField = new NumberField(12);
		accountField.setBounds(186, 235, 230, 21);
		add(accountField);
		accountField.setColumns(10);

		scrollPane = new MyScrollPane();
		scrollPane.setBounds(611, 38, 304, 252);
		add(scrollPane);

		orderField = new OrderField();
		orderField.setBounds(617, 302, 177, 25);
		add(orderField);
		orderField.setColumns(10);

		btnaddorder = new MyButton_LightBlue("增加订单");
		btnaddorder.setBounds(802, 301, 113, 27);
		add(btnaddorder);

		btnhandin = new MyButton_LightBlue("提交");
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

		button = new MyButton_LightBlue("查看已提交单据");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(parent.getSwitcher());
				parent.getRc().refreshList();
			}
		});
		button.setBounds(701, 402, 152, 27);
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

		button_1 = new MyButton_LightBlue("删除该条");
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
			list.add(orderField.getText());
			orderField.setText("");
		} else if (e.getSource().equals(btnhandin)) {
			if (!checkFormat())
				return;
			RecordCollectBlService recordCollectBlService = new RecordcollectController();
			String id = recordCollectBlService.getid(orgcode);
			long collectiontime = (long)yearSelect.getSelectedItem()*10000+(long)monthSelect.getSelectedItem()*100+(long)daySelect.getSelectedItem();				
			double collectionsum = Double.parseDouble(sumField.getText());
			String collectionman = manField.getText();
			String accountcode = accountField.getText();
            AccountBlService accountBlService=new AccountController();
            if(accountBlService.getAccountbyName(accountcode)==null){
            	createTip("该账户不存在！");
            }
            else{
            	vo = new RecordcollectVO(id, collectiontime, accountcode,
    					collectionsum, collectionman, list, Formstate.waiting);
    			ResultMessage r = handin();
    			if (r == ResultMessage.success)
    				addSucess();
    			else
    				createTip("添加失败！");
            }
			
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
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		System.out.println(list.size());
		for (int i = list.size() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
		list.removeAll(list);
		vo = null;
	}

	private boolean createTip(String str) {
		TipDialog tipDialog = new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);
		return false;
	}
}
