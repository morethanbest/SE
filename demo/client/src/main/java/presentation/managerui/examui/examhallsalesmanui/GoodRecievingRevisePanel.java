package presentation.managerui.examui.examhallsalesmanui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.managerblservice.ExamGoodsRecevings;
import po.Arrivalstate;
import po.Formstate;
import po.ResultMessage;
import presentation.managerui.examui.ExamPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.GoodsReceivingVO;

public class GoodRecievingRevisePanel extends WorkPanel {
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyComboBox<String> stateBox;
	private MyButton_LightBlue update;
	private ExamGoodsRecevings ea;
	private GoodsReceivingVO vo;
	private NumberField codeField;
	private MyComboBox<String> typeBox;
	private JLabel depatLabel;
	private MyButton_LightBlue button_1;
	private MyButton_LightBlue button_2;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;

	/**
	 * Create the panel.
	 */
	public GoodRecievingRevisePanel(ExamPanel parent, CardLayout card) {
		ea = new ExamController();
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		codeField = new NumberField(20);
		codeField.setBounds(140, 230, 242, 24);
		add(codeField);
		codeField.setColumns(10);
		
		depatLabel = new JLabel("");
		depatLabel.setBounds(423, 70, 337, 18);
		add(depatLabel);

		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(140, 67, 74, 24);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(238, 67, 61, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(321, 67, 61, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		stateBox = new MyComboBox<String>();
		stateBox.setBounds(518, 149, 242, 24);
		add(stateBox);
		addStateTypeItems();

		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearBox, monthBox, dateBox);
			}
		};
		yearBox.addItemListener(listener);
		monthBox.addItemListener(listener);

		typeBox = new MyComboBox<String>();
		typeBox.setBounds(140, 149, 242, 24);
		add(typeBox);
		addTypeItems();

		update = new MyButton_LightBlue("提交修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				if(codeField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入单据编号！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);		
				}
				else{
					ResultMessage resultMessage=ea.updateGoodsReceivingForm(new GoodsReceivingVO(
							vo.getid(), date,typeBox.getSelectedIndex() == 1 ,codeField
							.getText(),vo.getDeparture(),
					getStateType((String) stateBox.getSelectedItem()),
					vo.getFormstate()));
					if(resultMessage==ResultMessage.success){
						TipDialog tipDialog=new TipDialog("修改成功！");
						tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						tipDialog.setVisible(true);	
					}else {
						TipDialog tipDialog=new TipDialog("修改失败！");
						tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						tipDialog.setVisible(true);	
					}
				}
				
			}
		});
		update.setBounds(423, 336, 113, 27);
		add(update);
		
		button_1 = new MyButton_LightBlue("恢复原值");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button_1.setBounds(550, 336, 113, 27);
		add(button_1);
		
		button_2 = new MyButton_LightBlue("返回");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent);
				parent.getGr().refreshList();
			}
		});
		button_2.setBounds(677, 336, 113, 27);
		add(button_2);
		
		label = new JLabel("入库日期：");
		label.setBounds(46, 70, 66, 15);
		add(label);
		
		label_1 = new JLabel("单据类型：");
		label_1.setBounds(46, 154, 66, 15);
		add(label_1);
		
		label_2 = new JLabel("单据编号：");
		label_2.setBounds(46, 234, 66, 15);
		add(label_2);
		
		label_3 = new JLabel("到达状态：");
		label_3.setBounds(423, 154, 74, 15);
		add(label_3);
	}

	private void addTypeItems() {
		typeBox.addItem("中转中心-装车单编号");
		typeBox.addItem("营业厅-汽运编号");
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

	private void addStateTypeItems() {
		for (Arrivalstate state : Arrivalstate.values()) {
			stateBox.addItem(state.getName());
		}
	}

	private Arrivalstate getStateType(String str) {
		for (Arrivalstate state : Arrivalstate.values()) {
			if (state.getName().equals(str)) {
				return state;
			}
		}
		return null;
	}
	public void init(GoodsReceivingVO vo){
		this.vo = vo;
		yearBox.setSelectedItem(vo.getArrivaltime() / 10000);
		monthBox.setSelectedItem((vo.getArrivaltime() % 10000) / 100);
		dateBox.setSelectedItem(vo.getArrivaltime() % 1000000);
		if(vo.getwhefromhalll())
			typeBox.setSelectedIndex(1);
		else
			typeBox.setSelectedIndex(0);
		codeField.setText(vo.getTranscode());
		depatLabel.setText("出发地：" + vo.getDeparture());
		stateBox.setSelectedItem(vo.getArrivalstate());
		
		update.setEnabled(vo.getFormstate() == Formstate.waiting || vo.getFormstate() == Formstate.fail);
	}

}
