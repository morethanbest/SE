package presentation.courierui;

import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import po.ResultMessage;
import presentation.mainui.MainFrame;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.PersonPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.OrderField;
import presentation.tip.TipDialog;
import vo.ReceptionVO;
import businesslogic.orderbl.CheckExist;
import businesslogic.orderbl.ReceptionPack.ReceptionController;
import businesslogicservice.orderblservice.CheckExistBlService;
import businesslogicservice.orderblservice.ReceptionBlService;

public class RecievePanel extends PersonPanel {
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyButton_LightBlue button_1;
	private MyButton_LightBlue button;
	private OrderField codeField;
	private MyTextField nameField;
	private ReceptionBlService receptionBlService;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private MyButton_LightBlue button_2;
    private MainFrame parent;
	/**
	 * Create the panel.
	 * 
	 * @param courierPanel
	 */
	public RecievePanel(CourierPanel courierPanel,MainFrame parent) {
		setBackground(SystemColor.inactiveCaptionBorder);
		receptionBlService = new ReceptionController();
		setLayout(null);

		nameField = new MyTextField();
		nameField.setBounds(354, 111, 229, 30);
		add(nameField);
		nameField.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(14, 68, 954, 7);
		add(separator);

		button = new MyButton_LightBlue("订单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courierPanel.switchPanel("order");
			}
		});
		button.setBounds(710, 10, 96, 40);
		button.setForeground(SystemColor.windowBorder);
		button.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		button.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(button);
		add(button);

		codeField = new OrderField();
		codeField.setBounds(354, 198, 229, 30);
		add(codeField);
		codeField.setColumns(10);

		button_1 = new MyButton_LightBlue("确认收件");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkFormate())
					return ;
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				if(receptionBlService.addReception(new ReceptionVO(codeField.getText(), nameField.getText(), date)) == ResultMessage.success)
					addSuccessfully();
				else
				{
					TipDialog tipDialog = new TipDialog("添加失败！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);	
				}
			}
			
		});
		button_1.setBounds(389, 375, 113, 27);
		add(button_1);

		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(348, 292, 79, 24);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(441, 292, 61, 24);
		add(monthBox);
		addYearItems(yearBox, monthBox);

		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(516, 292, 61, 24);
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
		
		Calendar c = Calendar.getInstance();
		yearBox.setSelectedItem((long)c.get(Calendar.YEAR));
		monthBox.setSelectedItem((long)c.get(Calendar.MONTH) + 1);
		dateBox.setSelectedItem((long)c.get(Calendar.DAY_OF_MONTH));
		
		label = new JLabel("收件人：");
		label.setBounds(262, 117, 72, 18);
		add(label);
		
		label_1 = new JLabel("订单编号：");
		label_1.setBounds(247, 204, 79, 18);
		add(label_1);
		
		label_2 = new JLabel("收件日期：");
		label_2.setBounds(247, 295, 87, 18);
		add(label_2);
		
		button_2 = new MyButton_LightBlue("注销");
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                parent.skipToLogin();
			}
		});
		button_2.setBounds(858, 10, 96, 40);
		button_2.setForeground(SystemColor.windowBorder);
		button_2.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		button_2.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(button_2);
		add(button_2);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{nameField, codeField, yearBox, monthBox, dateBox}));
	}
	private void setNoneBorder(JButton button){
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	}
	private void addYearItems(JComboBox<Long> year, JComboBox<Long> month) {
		for (long i = 2000; i <= 2050; i++) {
			year.addItem(i);
		}

		for (long i = 1; i <= 12; i++) {
			month.addItem(i);
		}
	}
	
	private boolean checkFormate(){
		if(nameField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("收件人不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(codeField.getText().length() != 10){
			TipDialog tipDialog=new TipDialog("订单号必须为10位！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else{
			CheckExistBlService checkExistBlService=new CheckExist();
			boolean exist=checkExistBlService.checkExist(codeField.getText());
			if(!exist){
				TipDialog tipDialog=new TipDialog("订单号:" + codeField.getText() + "不存在！");
				tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				tipDialog.setVisible(true);	
			}
			return exist;
		}
	}
	
	private void addSuccessfully(){
		TipDialog tipDialog=new TipDialog("添加成功！");
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);	
		nameField.setText("");
		codeField.setText("");
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
}
