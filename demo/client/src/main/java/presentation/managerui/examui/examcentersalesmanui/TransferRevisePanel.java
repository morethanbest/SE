package presentation.managerui.examui.examcentersalesmanui;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogic.managerbl.ExamPack.ExamController;
import businesslogicservice.managerblservice.ConstantsBlService;
import businesslogicservice.managerblservice.ExamRecordtrans;
import po.Formstate;
import po.ResultMessage;
import presentation.enums.TransportTypes;
import presentation.managerui.examui.ExamPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import presentation.tip.TipDialog;
import vo.CityVO;
import vo.RecordtransVO;

public class TransferRevisePanel extends WorkPanel {
	private MyTextField classField;
	private MyTextField counterField;
	private MyTextField manageField;
	private JTable table;
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyComboBox<String> typeBox;
	private MyComboBox<String> destinBox;
	private MyButton_LightBlue update;
	private MyButton_LightBlue button_1;
	private MyButton_LightBlue button_2;
	private JLabel codeLabel;
	private JLabel departureLabel;
	private MyButton_LightBlue farebutton;
	private ExamRecordtrans ea;
	private RecordtransVO vo;
	private MyTextField fareField;
	private MyButton_LightBlue button;
	private MyButton_LightBlue button_3;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	/**
	 * Create the panel.
	 */
	public TransferRevisePanel(ExamPanel parent, CardLayout card) {
		ea = new ExamController();
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		codeLabel = new JLabel("");
		codeLabel.setBounds(14, 12, 242, 27);
		add(codeLabel);

		departureLabel = new JLabel("");
		departureLabel.setBounds(351, 147, 242, 27);
		add(departureLabel);

		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(99, 78, 74, 24);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(183, 78, 61, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(254, 78, 61, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		typeBox = new MyComboBox<String>();
		typeBox.setBounds(99, 150, 216, 24);
		add(typeBox);
		addTransportTypeItems();

		classField = new MyTextField();
		classField.setColumns(10);
		classField.setBounds(99, 215, 216, 24);
		add(classField);

		counterField = new MyTextField();
		counterField.setColumns(10);
		counterField.setBounds(409, 12, 200, 24);
		add(counterField);

		manageField = new MyTextField();
		manageField.setColumns(10);
		manageField.setBounds(409, 79, 200, 24);
		add(manageField);

		destinBox = new MyComboBox<String>();
		destinBox.setBounds(409, 214, 200, 24);
		add(destinBox);
		addCityItems(destinBox);

		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				typeBox, yearBox, monthBox, dateBox, classField, counterField,
				update }));

		update = new MyButton_LightBlue("提交修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				if(classField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入班次号！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);	
				}else if(counterField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入货柜号！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);	
				}else if(manageField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入监装员！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);	
				}else if(fareField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入运费合计！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);	
				}else if(tableModel.getRowCount()==0){
					TipDialog tipDialog=new TipDialog("请输入托运单号！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);	
				}else{
					Long date = (Long) yearBox.getSelectedItem() * 10000
							+ (Long) monthBox.getSelectedItem() * 100
							+ (Long) dateBox.getSelectedItem();
					List<String> barcodes = new ArrayList<String>();
					
					int rowCount = tableModel.getRowCount();
					for (int i = 0; i < rowCount; i++) {
						barcodes.add((String) tableModel.getValueAt(i, 0));
					}
					double fare = Double.parseDouble(farebutton.getText());
					ResultMessage resultMessage=ea.updateRecordtransForm(new RecordtransVO(date,
							codeLabel.getText(), (String) typeBox
									.getSelectedItem(), classField.getText(),
							departureLabel.getText(), (String) destinBox
									.getSelectedItem(), counterField.getText(),
							manageField.getText(), barcodes, fare,
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
		update.setBounds(416, 348, 113, 27);
		add(update);


		JLabel label = new JLabel("运费合计：");
		label.setBounds(14, 352, 82, 18);
		add(label);

		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(660, 13, 285, 274);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "\u672C\u6B21\u88C5\u7BB1\u6240\u6709\u6258\u8FD0\u5355\u53F7" }));
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);

		button_1 = new MyButton_LightBlue("增加一条");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				tableModel.addRow(new String[] { "" });
			}
		});
		button_1.setBounds(670, 300, 113, 27);
		add(button_1);

		button_2 = new MyButton_LightBlue("删除该条");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				int rownum = table.getSelectedRow();
				tableModel.removeRow(rownum);
			}
		});
		button_2.setBounds(823, 300, 113, 27);
		add(button_2);
		
		fareField = new MyTextField();
		fareField.setText("0");
		fareField.setBounds(100, 349, 61, 24);
		add(fareField);
		fareField.setColumns(10);
		
		button = new MyButton_LightBlue("恢复原值");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button.setBounds(543, 348, 113, 27);
		add(button);
		
		button_3 = new MyButton_LightBlue("返回");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent);
				parent.getTrans().refreshList();
			}
		});
		button_3.setBounds(670, 348, 113, 27);
		add(button_3);
		
		label_1 = new JLabel("中转日期：");
		label_1.setBounds(14, 83, 75, 15);
		add(label_1);
		
		label_2 = new JLabel("中转类型：");
		label_2.setBounds(14, 159, 75, 15);
		add(label_2);
		
		label_3 = new JLabel("班次号：");
		label_3.setBounds(14, 219, 54, 15);
		add(label_3);
		
		label_4 = new JLabel("货柜号：");
		label_4.setBounds(331, 16, 54, 15);
		add(label_4);
		
		label_5 = new JLabel("监察员：");
		label_5.setBounds(331, 83, 54, 15);
		add(label_5);
		
		label_6 = new JLabel("目的地：");
		label_6.setBounds(331, 219, 54, 15);
		add(label_6);

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

	private void addTransportTypeItems() {
		for (TransportTypes transport : TransportTypes.values()) {
			typeBox.addItem(transport.getName());
		}
	}

	public void addCityItems(JComboBox<String> citySelect) {
		citySelect.removeAllItems();
		ConstantsBlService constantsBlService = new ConstantsController();
		List<CityVO> cityList = constantsBlService.getAllCity();
		for (CityVO city : cityList) {
			citySelect.addItem(city.getName());
		}
	}
	
	public void init(RecordtransVO vo){
		this.vo = vo;
		codeLabel.setText(vo.getTranscode());
		yearBox.setSelectedItem(vo.getLoadtime() / 10000);
		monthBox.setSelectedItem((vo.getLoadtime() % 10000) / 100);
		dateBox.setSelectedItem(vo.getLoadtime() % 1000000);
		typeBox.setSelectedItem(vo.getTransportType());
		classField.setText(vo.getTransportCode());
		counterField.setText(vo.getCountercode());
		manageField.setText(vo.getSupervisor());
		departureLabel.setText(vo.getDepartrue());
		destinBox.setSelectedItem(vo.getDestination());
		fareField.setText("0");
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			tableModel.removeRow(i);
		}
		
		List<String> list = vo.getAllcode();
		for (int i = 0; i < list.size(); i++) {
			tableModel.addRow(new String[]{list.get(i)});
		}
		
		update.setEnabled(vo.getFormstate() == Formstate.waiting || vo.getFormstate() == Formstate.fail);
	}
}
