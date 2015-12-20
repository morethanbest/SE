package presentation.hallsalesmanui.delivery;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import po.Formstate;
import po.ResultMessage;
import presentation.hallsalesmanui.HallsalesmanPanel;
import presentation.tip.OrderField;
import presentation.tip.TipDialog;
import vo.DeliveryVO;
import businesslogic.logisticsbl.DeliveryPack.DeliveryController;
import businesslogic.orderbl.CheckExist;
import businesslogicservice.logisticsblservice.DeliveryBlService;
import businesslogicservice.orderblservice.CheckExistBlService;

public class DeliveryPanel extends JPanel {
	private OrderField codeField;
	private JTextField deliveryField;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JButton button;
	private DeliveryBlService deliveryBlService;
	private JButton button_1;

	/**
	 * Create the panel.
	 */
	public DeliveryPanel(String orgCode, HallsalesmanPanel parent, CardLayout card) {
		setLayout(null);

		deliveryBlService = new DeliveryController();

		codeField = new OrderField();
		codeField.setColumns(10);
		codeField.setBounds(286, 82, 242, 24);
		add(codeField);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(286, 141, 74, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(384, 141, 61, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(467, 141, 61, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		deliveryField = new JTextField();
		deliveryField.setColumns(10);
		deliveryField.setBounds(286, 204, 242, 24);
		add(deliveryField);

		button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkFormat())
					return;
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				ResultMessage r = deliveryBlService.Delivery(new DeliveryVO(deliveryBlService
						.findID(orgCode), date, codeField.getText(),
						deliveryField.getText(), Formstate.waiting));
				if(r == ResultMessage.success)
					addSucess();
				else
					createTip("添加失败！");
			}
		});
		button.setBounds(359, 276, 113, 27);
		add(button);

		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearBox, monthBox, dateBox);
			}
		};
		yearBox.addItemListener(listener);
		monthBox.addItemListener(listener);

		Calendar c = Calendar.getInstance();
		yearBox.setSelectedItem((long)c.get(Calendar.YEAR));
		monthBox.setSelectedItem((long)c.get(Calendar.MONTH) + 1);
		dateBox.setSelectedItem((long)c.get(Calendar.DAY_OF_MONTH));
		
		JLabel label = new JLabel("派件日期：");
		label.setBounds(200, 144, 86, 18);
		add(label);
		
		JLabel label_1 = new JLabel("订单编号：");
		label_1.setBounds(200, 85, 86, 18);
		add(label_1);
		
		JLabel label_2 = new JLabel("派件员：");
		label_2.setBounds(212, 207, 74, 18);
		add(label_2);
		
		button_1 = new JButton("查看已提交单据");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(parent.getSwitcher());
				parent.getDc().refreshList();
			}
		});
		button_1.setBounds(737, 343, 144, 27);
		add(button_1);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{codeField, yearBox, monthBox, dateBox, deliveryField}));

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
	private boolean checkFormat(){
		CheckExistBlService check = new CheckExist();
		if(codeField.getText().length() != 10){
			return createTip("订单编号必须为10位！");
		} else if(!check.checkExist(codeField.getText())){
			return createTip("订单:" + codeField.getText() + " 不存在！");
		} else if(deliveryField.getText().equals("")){
			return createTip("派件员不能为空！");
		}	
		return true;
	}
	
	private void addSucess(){
		createTip("添加成功！");
		codeField.setText("");
		deliveryField.setText("");
	}
	
	private boolean createTip(String str){
		TipDialog tipDialog=new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);	
		return false;
	}
	
}
