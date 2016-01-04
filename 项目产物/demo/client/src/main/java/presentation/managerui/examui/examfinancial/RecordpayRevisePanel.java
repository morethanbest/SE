package presentation.managerui.examui.examfinancial;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.managerblservice.ExamRecordpays;
import po.Formstate;
import po.RecordpayList;
import po.ResultMessage;
import presentation.managerui.examui.ExamPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.DoubleField;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.RecordpayVO;

public class RecordpayRevisePanel extends WorkPanel implements ActionListener {
    private DoubleField sumField;
    private MyTextField manField;
    private NumberField accountField;
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyComboBox<String> tipSelect;
	private MyButton_LightBlue update;
	private ExamRecordpays ea;
	private RecordpayVO vo;
	private JTextArea textArea;
	private MyButton_LightBlue button_1;
	private MyButton_LightBlue button_2;
	/**
	 * Create the panel.
	 */
	public RecordpayRevisePanel(ExamPanel parent, CardLayout card) {
		ea = new ExamController();
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		JLabel label = new JLabel("付款信息：");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(146, 21, 80, 32);
		add(label);
		
		JLabel label_1 = new JLabel("付款日期：");
		label_1.setBounds(25, 85, 70, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("付款金额：");
		label_2.setBounds(25, 137, 70, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("付款人：");
		label_3.setBounds(25, 184, 54, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("付款账号：");
		label_4.setBounds(25, 231, 70, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("条目：");
		label_5.setBounds(25, 276, 54, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("备注：");
		label_6.setBounds(495, 57, 54, 15);
		add(label_6);
		
		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(169, 82, 80, 21);
		yearBox.setEditable(false);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(259, 82, 65, 21);
		monthBox.setEditable(false);
		add(monthBox);
		
		addYearItems(yearBox, monthBox);
		
		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(334, 82, 65, 21);
		dateBox.setEditable(false);
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
		
		update = new MyButton_LightBlue("提交修改");
		update.setBounds(472, 354, 113, 25);
		add(update);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(532, 85, 280, 142);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		update.addActionListener(this);
		
		button_1 = new MyButton_LightBlue("恢复原值");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button_1.setBounds(599, 353, 113, 27);
		add(button_1);
		
		button_2 = new MyButton_LightBlue("返回");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent);
				parent.getPay().refreshList();
			}
		});
		button_2.setBounds(726, 353, 113, 27);
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
	
	public void addtipItem(JComboBox<String> tipSelect){
		tipSelect.addItem("租金");
		tipSelect.addItem("运费");
		tipSelect.addItem("人员工资");
		tipSelect.addItem("奖励");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(update)){
			Long date = (Long) yearBox.getSelectedItem() * 10000
					+ (Long) monthBox.getSelectedItem() * 100
					+ (Long) dateBox.getSelectedItem();
			String payman=manField.getText();
			String payaccount=accountField.getText();
			RecordpayList entry;
			switch (tipSelect.getSelectedIndex()) {
			case 0:
				entry=RecordpayList.rent;
				break;
			case 1:
				entry=RecordpayList.fare;
				break;
			case 2:
				entry=RecordpayList.wages;
				break;
			case 3:
				entry=RecordpayList.bonus;
				break;
			default:
				entry = null;
				break;
			}
			String remark=textArea.getText();
			Formstate formstate = vo.getFormstate();
			if(sumField.getText().equals("")){
				TipDialog dialog=new TipDialog("请输入金额！");
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
			else if(manField.getText().equals("")){
				TipDialog dialog=new TipDialog("请输入付款人姓名！");
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
			else if(accountField.getText().equals("")){
				TipDialog dialog=new TipDialog("请输入付款账号！");
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
			else{
				try {
					double paysum=Double.parseDouble(sumField.getText());
					RecordpayVO temp = new RecordpayVO(vo.getId(), date, paysum, payman, payaccount, entry, remark, formstate);
					ResultMessage resultMessage=ea.updateRecordpayForm(temp);
					if(resultMessage==ResultMessage.failure){
						TipDialog dialog=new TipDialog("提交失败");
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}
					else{
						TipDialog dialog=new TipDialog("提交成功");
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					TipDialog dialog=new TipDialog("请输入正确的付款金额！");
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
			}
			
		}
	}
	
	public void init(RecordpayVO vo){
		this.vo = vo;
		yearBox.setSelectedItem(vo.getPaytime() / 10000);
		monthBox.setSelectedItem((vo.getPaytime() % 10000) / 100);
		dateBox.setSelectedItem(vo.getPaytime() % 1000000);
		sumField.setText(vo.getPaysum() + "");
		manField.setText(vo.getPayman() + "");
		accountField.setText(vo.getPayaccount());
		int i = 0;
		for (RecordpayList e : RecordpayList.values()) {
			
			if(e == vo.getEntry())
				tipSelect.setSelectedIndex(i);
			i++;
		}
		textArea.setText(vo.getRemark());
		
		
	}
}
