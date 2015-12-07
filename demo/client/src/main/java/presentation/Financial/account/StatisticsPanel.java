package presentation.Financial.account;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.balancebl.StatisticsPack.StatisticsController;
import businesslogicservice.balanceblservice.StatisticsBlService;
import vo.RecordcollectVO;
import vo.RecordpayVO;
import vo.StatisticsVO;

public class StatisticsPanel extends JPanel implements ActionListener {
	private String orgcode;
	
	private JTable table;
	
	private JSeparator separator;
	
	private JLabel startLabel;
	private JLabel endLabel;
	private JButton btnsearch;
	
	private JComboBox<String> yearSelectstart;
	private JComboBox<String> monthSelectstart;
	private JComboBox<String> daySelectstart;
	
	private JComboBox<String> yearSelectend;
	private JComboBox<String> monthSelectend;
	private JComboBox<String> daySelectend;
	
	private StatisticsVO vo=null;
	
	public  StatisticsPanel(String orgcode){
		this.orgcode = orgcode;
		setLayout(null);
		
		separator = new JSeparator();
		separator.setBounds(0, 49, 954, 8);
		add(separator);
		
		
		//开始时间
		startLabel = new JLabel();
		startLabel.setBounds(20, 20, 100, 21);
		startLabel.setText("开始时间点");
		add(startLabel);
		
		yearSelectstart = new JComboBox<String>();
		yearSelectstart.setBounds(110, 20, 100, 21);
		yearSelectstart.setEditable(false);
		yearSelectstart.setEnabled(true);
		add(yearSelectstart);
		addyearItem(yearSelectstart);

		ItemListener startlistener= new ItemListener(){			//用于判断这个月的天数
			@Override
			public void itemStateChanged(ItemEvent e) {
				addDayItem(daySelectstart,monthSelectstart,yearSelectstart);
			}
		};
		monthSelectstart = new JComboBox<String>();
		monthSelectstart.setBounds(225, 20, 65, 21);
		monthSelectstart.setEditable(false);
		monthSelectstart.setEnabled(true);
		add(monthSelectstart);
		addmonthItem(monthSelectstart);
		
		daySelectstart = new JComboBox<String>();
		daySelectstart.setBounds(305, 20, 65, 21);
		daySelectstart.setEditable(false);
		daySelectstart.setEnabled(true);
		add(daySelectstart);
		addDayItem(daySelectstart,monthSelectstart,yearSelectstart);
		
		yearSelectstart.addItemListener(startlistener);
		monthSelectstart.addItemListener(startlistener);
		
		
		//结束时间
		endLabel=new JLabel();
		endLabel.setBounds(420, 20, 100, 21);
		endLabel.setText("结束时间点");
		add(endLabel);
		
		
		yearSelectend = new JComboBox<String>();
		yearSelectend.setBounds(515, 20, 100, 21);
		yearSelectend.setEditable(false);
		yearSelectend.setEnabled(true);
		add(yearSelectend);
		addyearItem(yearSelectend);

		ItemListener endlistener= new ItemListener(){			//用于判断这个月的天数
			@Override
			public void itemStateChanged(ItemEvent e) {
				addDayItem(daySelectend,monthSelectend,yearSelectend);
			}
		};
		monthSelectend = new JComboBox<String>();
		monthSelectend.setBounds(630, 20, 65, 21);
		monthSelectend.setEditable(false);
		monthSelectend.setEnabled(true);
		add(monthSelectend);
		addmonthItem(monthSelectend);
		
		daySelectend = new JComboBox<String>();
		daySelectend.setBounds(710, 20, 65, 21);
		daySelectend.setEditable(false);
		daySelectend.setEnabled(true);
		add(daySelectend);
		addDayItem(daySelectend,monthSelectend,yearSelectend);
		
		yearSelectend.addItemListener(endlistener);
		monthSelectend.addItemListener(endlistener);
		
		//加入搜索按钮
		btnsearch=new JButton();
		btnsearch.setBounds(810, 19, 76, 23);
		btnsearch.setText("生成");
		add(btnsearch);
		
		//加入表格
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 954, 200);
		
		
		String s[]={"类别","日期"};
//		table=new JTable(null, s);
//		scrollPane.setViewportView(table);
//		
//		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
//		tableModel.setColumnCount(4);
//		tableModel.setRowCount(10);
		
		
		
		
	}
	
	private void displayinTable(){
		if(vo!=null){
			List<RecordpayVO> recordpaylist=vo.getList1();
			List<RecordcollectVO> recordcollectlist=vo.getList2();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			tableModel.setRowCount(0);
			for(RecordpayVO reocordpay : recordpaylist){
				String[] rowString =new String[2];
				rowString[0]="付款单";
				rowString[1]=reocordpay.getPaytime()+"";		//转为字符串
				tableModel.addRow(rowString);
			}
			for(RecordcollectVO recordcollect : recordcollectlist){
				String[] rowString =new String[2];
				rowString[0]="收款单";
				rowString[1]=recordcollect.getCollectiontime()+"";		//转为字符串
				tableModel.addRow(rowString);
			}
		}
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
	
	public void getStatistics(long starttime,long endtime){
		StatisticsBlService statisticsBlService=new StatisticsController();
		vo=statisticsBlService.Statistics(starttime, endtime);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnsearch)){
			long starttime=Long.parseLong((String)yearSelectstart.getSelectedItem())*10000+
					Long.parseLong((String)monthSelectstart.getSelectedItem())*100+
					Long.parseLong((String)daySelectstart.getSelectedItem());
			long endtime=Long.parseLong((String)yearSelectend.getSelectedItem())*10000+
					Long.parseLong((String)monthSelectend.getSelectedItem())*100+
					Long.parseLong((String)daySelectend.getSelectedItem());
			getStatistics(starttime, endtime);
			displayinTable();
		}
	}

}
