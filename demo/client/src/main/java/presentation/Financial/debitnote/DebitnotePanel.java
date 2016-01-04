package presentation.Financial.debitnote;

import java.awt.Font;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import businesslogic.balancebl.DebitnotePack.DebitnoteController;
import businesslogicservice.balanceblservice.DebitnoteBlService;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import vo.CityVO;
import vo.DebitnoteVO;
import vo.OrganizationVO;
import vo.RecordcollectVO;

public class DebitnotePanel extends WorkPanel implements ActionListener{
	private JTable table;
	private JTable ordertable;
	private MyComboBox<String> orgSelect;
	private MyComboBox<String> citySelect;
	private List<OrganizationVO> orglist;
    private DebitnoteVO vo;
    private MyButton_LightBlue btnSearchByOrg;
	private MyComboBox<Long> yearSelect;
	private MyComboBox<Long> monthSelect;
	private MyComboBox<Long> daySelect;
	private MyButton_LightBlue btnSearchByDay;
	private MyTextField sumField;
    private MyTextField manField;
	private MyTextField accountField;
	private MyTextField yearField;
	private MyTextField monthField;
	private MyTextField dayField;
	private MyScrollPane scrollPane;
	private MyScrollPane orderscrollPane;
	/**
	 * Create the panel.
	 */
	public DebitnotePanel() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 954, 10);
		add(separator);

		scrollPane = new MyScrollPane();
		scrollPane.setBounds(10, 81, 304, 326);
		add(scrollPane);

		yearSelect = new MyComboBox<Long>();
		yearSelect.setBounds(552, 0, 74, 31);
		yearSelect.setEditable(false);
		add(yearSelect);

		monthSelect = new MyComboBox<Long>();
		monthSelect.setBounds(636, 0, 65, 31);
		monthSelect.setEditable(false);
		add(monthSelect);

		addYearItems(yearSelect, monthSelect);
		
		daySelect = new MyComboBox<Long>();
		daySelect.setBounds(711, 0, 65, 32);
		daySelect.setEditable(false);
		add(daySelect);
		addDateItems(yearSelect, monthSelect, daySelect);
		
		ItemListener listener1 = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearSelect, monthSelect, daySelect);
			}
		};
		yearSelect.addItemListener(listener1);
		monthSelect.addItemListener(listener1);
		
		Calendar c = Calendar.getInstance();
		yearSelect.setSelectedItem((long) c.get(Calendar.YEAR));
		monthSelect.setSelectedItem((long) c.get(Calendar.MONTH) + 1);
		daySelect.setSelectedItem((long) c.get(Calendar.DAY_OF_MONTH));

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"收款单号", "收款金额", "收款时间" 
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(3);
		tableModel.setRowCount(0);

		citySelect = new MyComboBox<String>();
		citySelect.setBounds(0, 0, 174, 31);
		add(citySelect);
		addCityItems(citySelect);

		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addOrgItems(citySelect,orgSelect);
			}
		};
		
		orgSelect = new MyComboBox<String>();
		orgSelect.setBounds(199, 0, 174, 31);
		add(orgSelect);
		addOrgItems(citySelect,orgSelect);
		
		btnSearchByOrg = new MyButton_LightBlue("搜索");
		btnSearchByOrg.setBounds(414, 0, 100, 31);
		add(btnSearchByOrg);
		
		btnSearchByDay = new MyButton_LightBlue("搜索");
		btnSearchByDay.setBounds(819, 0, 100, 31);
		add(btnSearchByDay);
		
		JLabel label = new JLabel("收款信息：");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(378, 78, 80, 32);
		add(label);
		
		JLabel label_1 = new JLabel("收款日期：");
		label_1.setBounds(440, 120, 70, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("收款金额：");
		label_2.setBounds(440, 158, 70, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("收款人：");
		label_3.setBounds(440, 203, 54, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("收款账号：");
		label_4.setBounds(440, 244, 70, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("订单号：");
		label_5.setBounds(440, 291, 54, 15);
		add(label_5);
		
		yearField = new MyTextField();
		yearField.setBounds(564, 117, 80, 21);
		add(yearField);
		yearField.setColumns(10);
		
		monthField = new MyTextField();
		monthField.setBounds(654, 117, 65, 21);
		add(monthField);
		monthField.setColumns(10);
		
		dayField = new MyTextField();
		dayField.setBounds(729, 117, 65, 21);
		add(dayField);
		dayField.setColumns(10);
		
		sumField = new MyTextField();
		sumField.setBounds(564, 155, 172, 21);
		add(sumField);
		sumField.setColumns(10);
		
		manField = new MyTextField();
		manField.setBounds(564, 200, 172, 21);
		add(manField);
		manField.setColumns(10);
		
		accountField = new MyTextField();
		accountField.setBounds(564, 241, 172, 21);
		add(accountField);
		accountField.setColumns(10);
		
		orderscrollPane = new MyScrollPane();
		orderscrollPane.setBounds(564, 291, 230, 100);
		add(orderscrollPane);
		
		ordertable = new JTable();
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
		DefaultTableModel ordertableModel = (DefaultTableModel) ordertable.getModel();
		ordertableModel.setColumnCount(1);
		ordertableModel.setRowCount(0);
		
		orderscrollPane.setViewportView(ordertable);
		
		citySelect.addItemListener(listener);
        btnSearchByDay.addActionListener(this);
        btnSearchByOrg.addActionListener(this);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				if(row<0){
					yearField.setText("");
					monthField.setText("");
					dayField.setText("");
					sumField.setText("");
					accountField.setText("");
					manField.setText("");
					ordertable.removeAll();
					for(int i=0;i<ordertable.getRowCount();i++){
						ordertableModel.removeRow(i);
					}
				}
				else{
					RecordcollectVO reVo=vo.getList().get(table.getSelectedRow());
					long year=reVo.getCollectiontime()/10000;
					long mouth=reVo.getCollectiontime()/100-year*100;
					long day=reVo.getCollectiontime()%100;
					yearField.setText(Long.toString(year));
					monthField.setText(Long.toString(mouth));
					dayField.setText(Long.toString(day));
					sumField.setText(Double.toString(reVo.getCollectionsum()));
					accountField.setText(reVo.getAccountcode());
					manField.setText(reVo.getCollectionman());
					List<String> orderlist=reVo.getAllordercode();
					displayInOrderTable(orderlist);
				}
				
			}
		});
        sumField.setEditable(false);
        manField.setEditable(false);
    	accountField.setEditable(false);
    	yearField.setEditable(false);
    	monthField.setEditable(false);
    	dayField.setEditable(false);
	}
	private void displayInOrderTable(List<String> orderlist){
		DefaultTableModel ordertableModel = (DefaultTableModel) ordertable.getModel();
		ordertableModel.setRowCount(0);
		for(String string :orderlist){
			String[] rowString =new String[1];
			rowString[0]=string;
			ordertableModel.addRow(rowString);
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
	private void addCityItems(JComboBox<String> citySelect) {
		citySelect.removeAllItems();
		DebitnoteBlService debitnoteBlService=new DebitnoteController();
		List<CityVO> cityList = debitnoteBlService.getALLCity();
		for (CityVO city : cityList) {
			citySelect.addItem(city.getName());
		}
	}
	private void addOrgItems(JComboBox<String> citySelect,JComboBox<String> orgSelect) {
		orgSelect.removeAllItems();
		DebitnoteBlService debitnoteBlService=new DebitnoteController();
		orglist=debitnoteBlService.getAllOrganization((String)citySelect.getSelectedItem());
		if(orglist.size()!=0){
			for (OrganizationVO org : orglist) {
				orgSelect.addItem(org.getName());
			}
		}

	}
	private void refreshList() {
		if (citySelect.getSelectedItem() == null
				|| orgSelect.getSelectedItem() == null)
			return;
		DebitnoteBlService debitnoteBlService=new DebitnoteController();
		vo=debitnoteBlService.getRecordcollectbyhall(orglist.get(orgSelect.getSelectedIndex()).getOrganizationcode());
		displayInTable();
	}
	private void refreshListByday(){
		DebitnoteBlService debitnoteBlService=new DebitnoteController();
		long date=Long.parseLong((String)yearSelect.getSelectedItem()+monthSelect.getSelectedItem()+daySelect.getSelectedItem());
		vo=debitnoteBlService.getRecordcollectbydate(date);
		displayInTable();
	}
	private void displayInTable(){
		List<RecordcollectVO> collectlist=vo.getList();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for(RecordcollectVO Vo:collectlist){
			String[] rowString =new String[4];
			rowString[0]=Vo.getAccountcode();
			rowString[1]=Double.toString(Vo.getCollectionsum());
			rowString[2]=Long.toString(Vo.getCollectiontime());
			tableModel.addRow(rowString);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnSearchByOrg)){
			refreshList();
		}else if(e.getSource().equals(btnSearchByDay)){
			refreshListByday();
		}
	}
}
