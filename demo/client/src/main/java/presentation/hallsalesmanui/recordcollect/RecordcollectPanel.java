package presentation.hallsalesmanui.recordcollect;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import businesslogic.balancebl.RecordcollectPack.RecordcollectController;
import businesslogicservice.balanceblservice.RecordCollectBlService;
import po.Formstate;
import vo.RecordcollectVO;

public class RecordcollectPanel extends JPanel implements ActionListener{
	private String orgcode;
    private JTextField sumField;
    private JTextField manField;
    private JTextField accountField;
	private JComboBox<String> yearSelect;
	private JComboBox<String> monthSelect;
	private JComboBox<String> daySelect;
	private JScrollPane scrollPane;
	private JTextField orderField;
	private JButton btnaddorder;
	private JButton btnhandin;
	private JTable table;
	private RecordcollectVO vo=null;
	private List<String> list=new ArrayList<String>();
	/**
	 * Create the panel.
	 */
	public RecordcollectPanel(String orgcode) {
		this.orgcode=orgcode;
		setLayout(null);
		
		JLabel label = new JLabel("首款信息：");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(145, 10, 80, 32);
		add(label);
		
		JLabel label_1 = new JLabel("收款日期：");
		label_1.setBounds(243, 51, 70, 15);
		add(label_1);
		
		JLabel label_2 = new JLabel("收款金额：");
		label_2.setBounds(243, 96, 70, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("收款人：");
		label_3.setBounds(243, 142, 54, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("收款账号：");
		label_4.setBounds(243, 190, 70, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("订单号：");
		label_5.setBounds(243, 242, 54, 15);
		add(label_5);
		
		yearSelect = new JComboBox<String>();
		yearSelect.setBounds(387, 48, 80, 21);
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
		monthSelect.setBounds(477, 48, 65, 21);
		monthSelect.setEditable(false);
		add(monthSelect);
		addmonthItem(monthSelect);
		
		daySelect = new JComboBox<String>();
		daySelect.setBounds(552, 48, 65, 21);
		daySelect.setEditable(false);
		add(daySelect);
		addDayItem(daySelect,monthSelect,yearSelect);
		
		yearSelect.addItemListener(startlistener);
		monthSelect.addItemListener(startlistener);
		
		sumField = new JTextField();
		sumField.setBounds(387, 96, 172, 21);
		add(sumField);
		sumField.setColumns(10);
		
		manField = new JTextField();
		manField.setBounds(387, 139, 172, 21);
		add(manField);
		manField.setColumns(10);
		
		accountField = new JTextField();
		accountField.setBounds(387, 187, 172, 21);
		add(accountField);
		accountField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(387, 242, 230, 100);
		add(scrollPane);
		
		orderField = new JTextField();
		orderField.setBounds(387, 352, 172, 21);
		add(orderField);
		orderField.setColumns(10);
		
		btnaddorder = new JButton("增加订单");
		btnaddorder.setBounds(569, 352, 93, 23);
		add(btnaddorder);
		
		btnhandin = new JButton("提交");
		btnhandin.setBounds(374, 404, 93, 23);
		add(btnhandin);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
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
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(1);
		tableModel.setRowCount(0);
		
		scrollPane.setViewportView(table);
		btnaddorder.addActionListener(this);
		btnhandin.addActionListener(this);
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
	private void AddOrder(){
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		String[] orderstring=new String[1];
		orderstring[0]=orderField.getText();
		tableModel.addRow(orderstring);
		list.add(orderField.getText());
	}
	private void handin(){
		RecordCollectBlService recordCollectBlService=new RecordcollectController();
		recordCollectBlService.Recordcollect(vo);
		recordCollectBlService.updateCollect(vo);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnaddorder)){
			if(orderField.getText()!=""){
				AddOrder();
				orderField.setText("");
			}
		}else if(e.getSource().equals(btnhandin)){
			RecordCollectBlService recordCollectBlService=new RecordcollectController();
			String id=recordCollectBlService.getid(orgcode);
			long collectiontime=Long.parseLong((String)yearSelect.getSelectedItem()+monthSelect.getSelectedItem()+daySelect.getSelectedItem());
			double collectionsum=Double.parseDouble(sumField.getText());
			String collectionman=manField.getText();
			String accountcode=accountField.getText();
			vo=new RecordcollectVO(id, collectiontime, accountcode, collectionsum, collectionman, list, Formstate.waiting);
			handin();
			Success dialog=new Success(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			yearSelect.setSelectedIndex(0);
			monthSelect.setSelectedIndex(0);
			daySelect.setSelectedIndex(0);
			sumField.setText("");
			manField.setText("");
			accountField.setText("");
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			for(int i=list.size()-1;i>=0;i--){
				tableModel.removeRow(i);
			}
			table.removeAll();
			list.removeAll(list);
			vo=null;
		}
	}
}
