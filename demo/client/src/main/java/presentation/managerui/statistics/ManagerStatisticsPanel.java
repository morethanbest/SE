package presentation.managerui.statistics;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import businesslogic.balancebl.StatisticsPack.StatisticsController;
import businesslogicservice.balanceblservice.StatisticsBlService;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import vo.RecordcollectVO;
import vo.RecordpayVO;
import vo.StatisticsVO;

public class ManagerStatisticsPanel extends WorkPanel implements ActionListener {
	
	private JTable table;
	
	private JSeparator separator;
	
	private JLabel startLabel;
	private JLabel endLabel;
	private MyButton_LightBlue btnsearch;
	
	private MyComboBox<Long> yearSelectstart;
	private MyComboBox<Long> monthSelectstart;
	private MyComboBox<Long> daySelectstart;
	
	private MyComboBox<Long> yearSelectend;
	private MyComboBox<Long> monthSelectend;
	private MyComboBox<Long> daySelectend;
	
	private StatisticsVO vo=null;
	
	MyScrollPane paypanel;
	
	MyScrollPane collectpanel;
	
	public  ManagerStatisticsPanel(){
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		separator = new JSeparator();
		separator.setBounds(0, 49, 954, 8);
		add(separator);
		
		
		//开始时间
		startLabel = new JLabel();
		startLabel.setBounds(20, 10, 100, 21);
		startLabel.setText("开始时间点");
		add(startLabel);
		
		yearSelectstart = new MyComboBox<Long>();
		yearSelectstart.setBounds(110, 20, 100, 21);
		yearSelectstart.setEditable(false);
		yearSelectstart.setEnabled(true);
		add(yearSelectstart);

		monthSelectstart = new MyComboBox<Long>();
		monthSelectstart.setBounds(225, 20, 65, 21);
		monthSelectstart.setEditable(false);
		monthSelectstart.setEnabled(true);
		add(monthSelectstart);
		addYearItems(yearSelectstart, monthSelectstart);
		
		daySelectstart = new MyComboBox<Long>();
		daySelectstart.setBounds(305, 20, 65, 21);
		daySelectstart.setEditable(false);
		daySelectstart.setEnabled(true);
		add(daySelectstart);
		addDateItems(yearSelectstart,monthSelectstart,daySelectstart);
		ItemListener startlistener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearSelectstart, monthSelectstart, daySelectstart);
			}
		};
		yearSelectstart.addItemListener(startlistener);
		monthSelectstart.addItemListener(startlistener);
		
		Calendar c = Calendar.getInstance();
		yearSelectstart.setSelectedItem((long) c.get(Calendar.YEAR));
		monthSelectstart.setSelectedItem((long) c.get(Calendar.MONTH) + 1);
		daySelectstart.setSelectedItem((long) c.get(Calendar.DAY_OF_MONTH));
		//结束时间
		yearSelectend = new MyComboBox<Long>();
		yearSelectend.setBounds(515, 20, 100, 21);
		yearSelectend.setEditable(false);
		yearSelectend.setEnabled(true);
		add(yearSelectend);

		monthSelectend = new MyComboBox<Long>();
		monthSelectend.setBounds(630, 20, 65, 21);
		monthSelectend.setEditable(false);
		monthSelectend.setEnabled(true);
		add(monthSelectend);
		
		addYearItems(yearSelectend, monthSelectend);
		
		daySelectend = new MyComboBox<Long>();
		daySelectend.setBounds(710, 20, 65, 21);
		daySelectend.setEditable(false);
		daySelectend.setEnabled(true);
		add(daySelectend);
		addDateItems(yearSelectend,monthSelectend,daySelectend);
		
		ItemListener endlistener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearSelectend, monthSelectend, daySelectend);
			}
		};
		yearSelectend.addItemListener(endlistener);
		monthSelectend.addItemListener(endlistener);
		
		yearSelectend.setSelectedItem((long) c.get(Calendar.YEAR));
		monthSelectend.setSelectedItem((long) c.get(Calendar.MONTH) + 1);
		daySelectend.setSelectedItem((long) c.get(Calendar.DAY_OF_MONTH));
		//加入搜索按钮
		btnsearch=new MyButton_LightBlue("");
		btnsearch.setBounds(802, 9, 86, 31);
		btnsearch.setText("生成");
		btnsearch.addActionListener(this);
		add(btnsearch);
		
		//加入表格
		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(20, 60, 300, 350);
		add(scrollPane);
		
		Object[][] rowData={null,null,null};
		String columnNames[]={"类别","日期","金额"};
		table=new JTable();
		table.setModel(new DefaultTableModel(rowData, columnNames){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		scrollPane.setViewportView(table);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(3);
		tableModel.setRowCount(0);
		
		
		
		//付款详情
		paypanel = new MyScrollPane();
		paypanel.setBounds(320, 60, 734, 400);
		paypanel.setBorder(null);
		paypanel.setLayout(null);
		add(paypanel);
		paypanel.setVisible(false);
		paypanel.setOpaque(false);
		paypanel.getViewport().setOpaque(false);
		
		JLabel paysum=new JLabel();
		paysum.setText("付款金额：");
		paysum.setBounds(120, 20, 100, 21);
		paypanel.add(paysum);
		
		MyTextField sumField = new MyTextField();
		sumField.setBounds(250, 20, 172, 21);
		sumField.setEditable(false);
		paypanel.add(sumField);
		sumField.setColumns(10);
		
		JLabel payman=new JLabel();
		payman.setText("付款人：");
		payman.setBounds(120, 80, 100, 21);
		paypanel.add(payman);
		
		MyTextField manField = new MyTextField();
		manField.setBounds(250, 80, 172, 21);
		manField.setEditable(false);
		paypanel.add(manField);
		manField.setColumns(10);
		
		JLabel payaccount=new JLabel();
		payaccount.setText("付款账号：");
		payaccount.setBounds(120, 140, 100, 21);
		paypanel.add(payaccount);
		
		MyTextField accountField = new MyTextField();
		accountField.setBounds(250, 140, 172, 21);
		accountField.setEditable(false);
		paypanel.add(accountField);
		accountField.setColumns(10);
		
		JLabel tip=new JLabel();
		tip.setText("条目：");
		tip.setBounds(120, 200, 100, 21);
		paypanel.add(tip);
		
		MyComboBox<String> tipSelect = new MyComboBox<String>();
		tipSelect.setBounds(250, 200, 172, 21);
		tipSelect.setEditable(false);
		tipSelect.setEnabled(false);
		addtipItem(tipSelect);
		paypanel.add(tipSelect);
		
		JLabel text=new JLabel();
		text.setText("备注：");
		text.setBounds(120, 260, 100, 21);
		paypanel.add(text);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(250,260, 172, 80);
		textArea.setEditable(false);
		paypanel.add(textArea);
		
		//收款详情
		collectpanel = new MyScrollPane();
		collectpanel.setBounds(320, 60, 734, 400);
		collectpanel.setBorder(null);
		collectpanel.setLayout(null);
		add(collectpanel);
		collectpanel.setVisible(false);
		collectpanel.setOpaque(false);
		collectpanel.getViewport().setOpaque(false);
		
		JLabel label_2 = new JLabel("收款金额：");
		label_2.setBounds(120, 20, 70, 15);
		collectpanel.add(label_2);
		
		JLabel label_3 = new JLabel("收款人：");
		label_3.setBounds(120, 80, 54, 15);
		collectpanel.add(label_3);
		
		JLabel label_4 = new JLabel("收款账号：");
		label_4.setBounds(120, 140, 70, 15);
		collectpanel.add(label_4);
		
		JLabel label_5 = new JLabel("订单号：");
		label_5.setBounds(120, 200, 54, 15);
		collectpanel.add(label_5);
		
		MyTextField collectsum = new MyTextField();
		collectsum.setBounds(250, 20, 172, 21);
		collectsum.setEditable(false);
		collectpanel.add(collectsum);
		collectsum.setColumns(10);
		
		MyTextField collectman = new MyTextField();
		collectman.setBounds(250, 80, 172, 21);
		collectman.setEditable(false);
		collectpanel.add(collectman);
		collectman.setColumns(10);
		
		MyTextField collectaccount = new MyTextField();
		collectaccount.setBounds(250, 140, 172, 21);
		collectaccount.setEditable(false);
		collectpanel.add(collectaccount);
		collectaccount.setColumns(10);
		
		MyScrollPane orderpanel = new MyScrollPane();
		orderpanel.setBounds(250,200,172,100);
		collectpanel.add(orderpanel);
		
		JTable ordertable = new JTable();
		ordertable.setModel(new DefaultTableModel(
				new Object[][] {
					{null},
				},
				new String[] {
					"订单号"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
		orderpanel.setViewportView(ordertable);
		DefaultTableModel ordertableModel = (DefaultTableModel) ordertable.getModel();
		ordertableModel.setColumnCount(1);
		ordertableModel.setRowCount(10);
		
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				if(row<0){
					paypanel.setVisible(false);
					collectpanel.setVisible(false);
				}
				else{
					if (row < vo.getList1().size()) {
						paypanel.setVisible(true);
						collectpanel.setVisible(false);
						RecordpayVO recordpay = vo.getList1().get(row);
						sumField.setText(recordpay.getPaysum() + "");
						manField.setText(recordpay.getPayman());
						accountField.setText(recordpay.getPayaccount());
						tipSelect.setSelectedItem(recordpay.getEntry().getName());
						textArea.setText(recordpay.getRemark());
					}else if(row<vo.getList1().size()+vo.getList2().size()){
						paypanel.setVisible(false);
						collectpanel.setVisible(true);
						row-=vo.getList1().size();
						RecordcollectVO recordcollect=vo.getList2().get(row);
						collectsum.setText(recordcollect.getCollectionsum()+"");
						collectman.setText(recordcollect.getCollectionman());
						collectaccount.setText(recordcollect.getAccountcode());
						List<String> list=recordcollect.getAllordercode();
						DefaultTableModel ordertableModel = (DefaultTableModel) ordertable.getModel();
						ordertableModel.setRowCount(0);
						for(String order:list){
							String [] str=new String[1];
							str[0]=order;
							ordertableModel.addRow(str);
						}
					}else{
						paypanel.setVisible(false);
						collectpanel.setVisible(false);
					}

				}
				
			}
		});
	}
	
	
	private void addtipItem(JComboBox<String> tipSelect){
		tipSelect.addItem("租金");
		tipSelect.addItem("运费");
		tipSelect.addItem("人员工资");
		tipSelect.addItem("奖励");
	}
	
	private void displayinTable(){
		if(vo!=null){
			List<RecordpayVO> recordpaylist=vo.getList1();
			List<RecordcollectVO> recordcollectlist=vo.getList2();
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			tableModel.setRowCount(0);
			for(RecordpayVO recordpay : recordpaylist){

				String[] rowString =new String[3];
				rowString[0]="付款单";
				rowString[1]=recordpay.getPaytime()+"";		//转为字符串
				rowString[2]=recordpay.getPaysum()+"";
				tableModel.addRow(rowString);
			}
			for(RecordcollectVO recordcollect : recordcollectlist){
				String[] rowString =new String[3];
				rowString[0]="收款单";
				rowString[1]=recordcollect.getCollectiontime()+"";		//转为字符串
				rowString[2]=recordcollect.getCollectionsum()+"";
				tableModel.addRow(rowString);
			}

		}
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
	
	private void getStatistics(long starttime,long endtime){
		StatisticsBlService statisticsBlService=new StatisticsController();
		vo=statisticsBlService.Statistics(starttime, endtime);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnsearch)){
			long starttime=(long)yearSelectstart.getSelectedItem()*10000+
                    (long)monthSelectstart.getSelectedItem()*100+
                    (long)daySelectstart.getSelectedItem();
			long endtime=(long)yearSelectend.getSelectedItem()*10000+
                    (long)monthSelectend.getSelectedItem()*100+
                    (long)daySelectend.getSelectedItem();
			getStatistics(starttime, endtime);
			displayinTable();
		}
	}

}

