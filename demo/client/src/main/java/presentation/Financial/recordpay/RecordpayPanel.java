package presentation.Financial.recordpay;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import businesslogic.accountbl.AccountPack.AccountController;
import businesslogic.balancebl.RecordpayPack.RecordpayController;
import businesslogicservice.accountblservice.AccountBlService;
import businesslogicservice.balanceblservice.RecordpayBlService;
import po.Formstate;
import po.RecordpayList;
import po.ResultMessage;
import presentation.Financial.FinancialPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.DoubleField;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.RecordpayVO;

public class RecordpayPanel extends WorkPanel implements ActionListener {
	private DoubleField sumField;
	private MyTextField manField;
	private NumberField accountField;
	private MyComboBox<String> yearSelect;
	private MyComboBox<String> monthSelect;
	private MyComboBox<String> daySelect;
	private MyComboBox<String> tipSelect;
	private MyButton_LightBlue button;
	private RecordpayVO vo = null;
	private JTextArea textArea;
	private RecordpayBlService controller;
	private MyButton_LightBlue button_1;

	/**
	 * Create the panel.
	 */
	public RecordpayPanel(String orgcode, FinancialPanel parent, CardLayout card) {
		controller = new RecordpayController();
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);

		yearSelect = new MyComboBox<String>();
		yearSelect.setBounds(169, 82, 80, 21);
		yearSelect.setEditable(false);
		add(yearSelect);

		monthSelect = new MyComboBox<String>();
		monthSelect.setBounds(259, 82, 65, 21);
		monthSelect.setEditable(false);
		add(monthSelect);

		addYearItems(yearSelect, monthSelect);
		
		daySelect = new MyComboBox<String>();
		daySelect.setBounds(334, 82, 65, 21);
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
		sumField.setBounds(169, 134, 230, 21);
		add(sumField);
		sumField.setColumns(10);

		manField = new MyTextField();
		manField.setBounds(169, 181, 230, 21);
		add(manField);
		manField.setColumns(10);

		accountField = new NumberField(12);
		accountField.setBounds(169, 228, 230, 21);
		add(accountField);
		accountField.setColumns(10);

		tipSelect = new MyComboBox<String>();
		tipSelect.setBounds(169, 273, 230, 21);
		addtipItem(tipSelect);
		add(tipSelect);

		button = new MyButton_LightBlue("提交");
		button.setBounds(387, 417, 93, 23);
		add(button);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(532, 85, 307, 206);
		add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		button.addActionListener(this);

		button_1 = new MyButton_LightBlue("查看已提交单据");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(parent.getSwitcher());
				parent.getRc().refreshList();
			}
		});
		button_1.setBounds(672, 415, 143, 27);
		add(button_1);

		JLabel label = new JLabel("付款日期：");
		label.setBounds(69, 85, 94, 18);
		add(label);

		JLabel label_1 = new JLabel("付款金额：");
		label_1.setBounds(69, 137, 94, 18);
		add(label_1);

		JLabel label_2 = new JLabel("付款人：");
		label_2.setBounds(69, 184, 94, 18);
		add(label_2);

		JLabel label_3 = new JLabel("付款账号：");
		label_3.setBounds(69, 231, 94, 18);
		add(label_3);

		JLabel label_4 = new JLabel("条目：");
		label_4.setBounds(69, 276, 94, 18);
		add(label_4);

		JLabel label_5 = new JLabel("付款信息：");
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		label_5.setBounds(154, 21, 80, 32);
		add(label_5);

		JLabel label_6 = new JLabel("备注：");
		label_6.setBounds(480, 85, 54, 18);
		add(label_6);
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
	public void addtipItem(JComboBox<String> tipSelect) {
		tipSelect.addItem("租金");
		tipSelect.addItem("运费");
		tipSelect.addItem("人员工资");
		tipSelect.addItem("奖励");
	}

	private ResultMessage addRecordpay() {
		RecordpayBlService recordpayBlService = new RecordpayController();
		recordpayBlService.updateRecordpay(vo);
		return recordpayBlService.AddRecordpay(vo);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(button)) {
			if (!checkFormat())
				return;
			String id = controller.getid();
			long paytime = Long.parseLong((String) yearSelect.getSelectedItem()
					+ monthSelect.getSelectedItem()
					+ daySelect.getSelectedItem());
			String payman = manField.getText();
			String payaccount = accountField.getText();
			RecordpayList entry = null;
			switch (tipSelect.getSelectedIndex()) {
			case 0:
				entry = RecordpayList.rent;
				break;
			case 1:
				entry = RecordpayList.fare;
				break;
			case 2:
				entry = RecordpayList.wages;
				break;
			case 3:
				entry = RecordpayList.bonus;
				break;
			default:
				break;
			}
			String remark = textArea.getText();
			Formstate formstate = Formstate.waiting;

			double paysum = Double.parseDouble(sumField.getText());
			AccountBlService accountBlService=new AccountController();
            if(accountBlService.getAccountbyName(payaccount)==null){
            	createTip("该账户不存在！");
            }
            else{
            	vo = new RecordpayVO(id, paytime, paysum, payman, payaccount,
    					entry, remark, formstate);
    			ResultMessage r = addRecordpay();
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
		textArea.setText("");
	}

	private boolean createTip(String str) {
		TipDialog tipDialog = new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);
		return false;
	}
}
