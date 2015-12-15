package presentation.Financial.recordpay;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import businesslogic.balancebl.RecordpayPack.RecordpayController;
import businesslogicservice.balanceblservice.RecordpayBlService;
import po.Formstate;
import po.RecordpayList;
import po.ResultMessage;
import presentation.tip.DoubleField;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.RecordpayVO;

public class RecordpayPanel extends JPanel implements ActionListener {
    private String orgcode;
    private DoubleField sumField;
    private JTextField manField;
    private NumberField accountField;
	private JComboBox<String> yearSelect;
	private JComboBox<String> monthSelect;
	private JComboBox<String> daySelect;
	private JComboBox<String> tipSelect;
	private JButton button;
	private RecordpayVO vo=null;
	private JTextArea textArea;
	/**
	 * Create the panel.
	 */
	public RecordpayPanel(String orgcode) {
		this.orgcode=orgcode;
		setLayout(null);
		
		JLabel label = new JLabel("付款信息：");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(146, 21, 80, 32);
		add(label);
		
		JLabel label_1 = new JLabel("付款日期：");
		label_1.setBounds(243, 67, 70, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("付款金额：");
		label_2.setBounds(243, 119, 70, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("付款人：");
		label_3.setBounds(243, 166, 54, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("付款账号：");
		label_4.setBounds(243, 213, 70, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("条目：");
		label_5.setBounds(243, 258, 54, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("备注：");
		label_6.setBounds(243, 307, 54, 15);
		add(label_6);
		
		yearSelect = new JComboBox<String>();
		yearSelect.setBounds(387, 64, 80, 21);
		yearSelect.setEditable(false);
		add(yearSelect);
		addyearItem(yearSelect);

		ItemListener startlistener= new ItemListener(){			//用于判断这个月的天数
			@Override
			public void itemStateChanged(ItemEvent e) {
				addDayItem(daySelect,monthSelect,yearSelect);
			}
		};
		monthSelect = new JComboBox<String>();
		monthSelect.setBounds(477, 64, 65, 21);
		monthSelect.setEditable(false);
		add(monthSelect);
		addmonthItem(monthSelect);
		
		daySelect = new JComboBox<String>();
		daySelect.setBounds(552, 64, 65, 21);
		daySelect.setEditable(false);
		add(daySelect);
		addDayItem(daySelect,monthSelect,yearSelect);
		
		yearSelect.addItemListener(startlistener);
		monthSelect.addItemListener(startlistener);
		
		sumField = new DoubleField(12);
		sumField.setBounds(387, 116, 172, 21);
		add(sumField);
		sumField.setColumns(10);
		
		manField = new JTextField();
		manField.setBounds(387, 163, 172, 21);
		add(manField);
		manField.setColumns(10);
		
		accountField = new NumberField(12);
		accountField.setBounds(387, 210, 172, 21);
		add(accountField);
		accountField.setColumns(10);
		
		tipSelect = new JComboBox<String>();
		tipSelect.setBounds(387, 255, 172, 21);
		addtipItem(tipSelect);
		add(tipSelect);
		
		button = new JButton("提交");
		button.setBounds(387, 417, 93, 23);
		add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(387, 307, 274, 85);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		button.addActionListener(this);
	}
	private void addyearItem(JComboBox<String> yearselect){
		for(int i=2000;i<2100;i++){
			yearselect.addItem(Integer.toString(i));
		}
	}
	
	private void addmonthItem(JComboBox<String> monthselect){
		for(int i=1;i<=9;i++){
			monthselect.addItem("0"+Integer.toString(i));
		}
		for(int i=10;i<=12;i++){
			monthselect.addItem(Integer.toString(i));
		}
	}
	
	private void addDayItem(JComboBox<String> dayselect,JComboBox<String> monthselect,JComboBox<String> yearselect){
		dayselect.removeAllItems();
		
		//得到这个月的天数
		int days=getDays(Integer.parseInt((String)yearselect.getSelectedItem()),Integer.parseInt((String)monthselect.getSelectedItem()));
			
		for(int i=1;i<=9;i++){
			dayselect.addItem("0"+Integer.toString(i));
		}
		for(int i=10;i<=days;i++){
			dayselect.addItem(Integer.toString(i));
		}
	}
	
	public boolean isleap(Integer year){
		if(year%400==0){
			return true;
		}else if(year%100==0){
			return false;
		}else if(year%4==0){
			return true;
		}else{
			return false;
		}
	}
	
	public int getDays(Integer year,Integer month){				//得到这个月的天数
		int day[]={31,28,31,30,31,30,31,31,30,31,30,31};
		if(month==2&&isleap(year)){
			return 29;
		}
		return day[month-1];
	}
	public void addtipItem(JComboBox<String> tipSelect){
		tipSelect.addItem("租金");
		tipSelect.addItem("运费");
		tipSelect.addItem("人员工资");
		tipSelect.addItem("奖励");
	}
	private ResultMessage addRecordpay(){
		RecordpayBlService recordpayBlService=new RecordpayController();
		recordpayBlService.updateRecordpay(vo);
		return recordpayBlService.AddRecordpay(vo);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(button)){
			RecordpayBlService recordpayBlService=new RecordpayController();
			String id=recordpayBlService.getid();
			long paytime=Long.parseLong((String)yearSelect.getSelectedItem()+monthSelect.getSelectedItem()+daySelect.getSelectedItem());
			String payman=manField.getText();
			String payaccount=accountField.getText();
			RecordpayList entry = null;
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
				break;
			}
			String remark=textArea.getText();
			Formstate formstate=Formstate.waiting;
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
					vo=new RecordpayVO(id, paytime, paysum, payman, payaccount, entry, remark, formstate);
					ResultMessage resultMessage=addRecordpay();
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
}
