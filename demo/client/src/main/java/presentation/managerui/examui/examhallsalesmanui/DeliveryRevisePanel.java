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
import businesslogicservice.managerblservice.ExamDeliverys;
import po.Formstate;
import po.ResultMessage;
import presentation.managerui.examui.ExamPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.DeliveryVO;

public class DeliveryRevisePanel extends WorkPanel {
	private NumberField codeField;
	private MyTextField deliveryField;
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyButton_LightBlue update;
	private ExamDeliverys ea;
	private DeliveryVO vo;

	/**
	 * Create the panel.
	 */
	public DeliveryRevisePanel(ExamPanel parent, CardLayout card) {
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		ea = new ExamController();

		codeField = new NumberField(20);
		codeField.setColumns(10);
		codeField.setBounds(286, 82, 242, 24);
		add(codeField);

		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(286, 141, 74, 24);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(384, 141, 61, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(467, 141, 61, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		deliveryField = new MyTextField();
		deliveryField.setColumns(10);
		deliveryField.setBounds(286, 204, 242, 24);
		add(deliveryField);

		update = new MyButton_LightBlue("提交");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(codeField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入订单号！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);		
				}else if(deliveryField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入派件员！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);	
				}else {
					Long date = (Long) yearBox.getSelectedItem() * 10000
							+ (Long) monthBox.getSelectedItem() * 100
							+ (Long) dateBox.getSelectedItem();
					ResultMessage resultMessage=ea.updateDeliveryForm(new DeliveryVO(vo.getid(), date, codeField.getText(),
							deliveryField.getText(), vo.getDocumentstate()));
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
		update.setBounds(359, 276, 113, 27);
		add(update);
		
		MyButton_LightBlue button_1 = new MyButton_LightBlue("恢复原值");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button_1.setBounds(486, 276, 113, 27);
		add(button_1);
		
		MyButton_LightBlue button_2 = new MyButton_LightBlue("返回");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent);
				parent.getDelivery().refreshList();
			}
		});
		button_2.setBounds(613, 276, 113, 27);
		add(button_2);
		
		JLabel label = new JLabel("订单编号：");
		label.setBounds(177, 86, 74, 15);
		add(label);
		
		JLabel label_1 = new JLabel("派件日期：");
		label_1.setBounds(177, 146, 74, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("派件员：");
		label_2.setBounds(177, 208, 54, 15);
		add(label_2);

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

		public void init(DeliveryVO vo){
			this.vo = vo;
			codeField.setText(vo.getBarcode());
			yearBox.setSelectedItem(vo.getArrivaltime() / 10000);
			monthBox.setSelectedItem((vo.getArrivaltime() % 10000) / 100);
			dateBox.setSelectedItem(vo.getArrivaltime() % 1000000);
			deliveryField.setText(vo.getDelivorinfo());
			update.setEnabled(vo.getDocumentstate() == Formstate.waiting || vo.getDocumentstate() == Formstate.fail);
		}
}
