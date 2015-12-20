package presentation.centersalesmanui.transferui;

import java.awt.CardLayout;
import java.awt.Component;
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

import org.eclipse.wb.swing.FocusTraversalOnArray;

import po.Formstate;
import po.ResultMessage;
import presentation.centersalesmanui.CenterSalesmanPanel;
import presentation.enums.TransportTypes;
import presentation.tip.TipDialog;
import vo.CityVO;
import vo.RecordtransVO;
import businesslogic.logisticsbl.RecordtransPack.CentertransController;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogicservice.logisticsblservice.RecordtransBlService;
import businesslogicservice.managerblservice.ConstantsBlService;

public class TransferUpdatePanel extends JPanel {
	private JTextField classField;
	private JTextField counterField;
	private JTextField manageField;
	private JTable table;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JComboBox<String> typeBox;
	private JComboBox<String> destinBox;
	private JButton update;
	private JButton button_1;
	private JButton button_2;
	private JLabel codeLabel;
	private JLabel departureLabel;
	private JButton farebutton;
	private RecordtransVO vo;
	private JTextField fareField;
	private JButton button;
	private JButton button_3;
	private RecordtransBlService controller;
/**
	 * Create the panel.
	 */
	public TransferUpdatePanel(CenterSalesmanPanel parent, CardLayout card) {
		controller = new CentertransController();

		setLayout(null);

		codeLabel = new JLabel("");
		codeLabel.setBounds(14, 12, 242, 27);
		add(codeLabel);

		departureLabel = new JLabel("");
		departureLabel.setBounds(351, 147, 242, 27);
		add(departureLabel);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(14, 78, 74, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(112, 78, 61, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(195, 78, 61, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		typeBox = new JComboBox<String>();
		typeBox.setBounds(14, 147, 242, 24);
		add(typeBox);
		addTransportTypeItems();

		classField = new JTextField();
		classField.setColumns(10);
		classField.setBounds(14, 215, 242, 24);
		add(classField);

		counterField = new JTextField();
		counterField.setColumns(10);
		counterField.setBounds(351, 13, 242, 24);
		add(counterField);

		manageField = new JTextField();
		manageField.setColumns(10);
		manageField.setBounds(351, 78, 242, 24);
		add(manageField);

		destinBox = new JComboBox<String>();
		destinBox.setBounds(351, 215, 242, 24);
		add(destinBox);
		addCityItems(destinBox);

		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] {
				typeBox, yearBox, monthBox, dateBox, classField, counterField,
				update }));

		update = new JButton("提交修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkFormat())
					return;
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				List<String> barcodes = new ArrayList<String>();
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				int rowCount = tableModel.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					barcodes.add((String) tableModel.getValueAt(i, 0));
				}
				double fare = Double.parseDouble(farebutton.getText());
				ResultMessage r = controller.update(new RecordtransVO(date,
						codeLabel.getText(), (String) typeBox
								.getSelectedItem(), classField.getText(),
						departureLabel.getText(), (String) destinBox
								.getSelectedItem(), counterField.getText(),
						manageField.getText(), barcodes, fare,
						vo.getFormstate()));
				if(r == ResultMessage.success)
					createTip("修改成功！");
				else
					createTip("修改失败！");
			}
		});
		update.setBounds(416, 348, 113, 27);
		add(update);


		JLabel label = new JLabel("运费合计：");
		label.setBounds(14, 352, 82, 18);
		add(label);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(660, 13, 285, 274);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "\u672C\u6B21\u88C5\u7BB1\u6240\u6709\u6258\u8FD0\u5355\u53F7" }));
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);

		button_1 = new JButton("增加一条");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				tableModel.addRow(new String[] { "" });
			}
		});
		button_1.setBounds(670, 300, 113, 27);
		add(button_1);

		button_2 = new JButton("删除该条");
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
		
		fareField = new JTextField();
		fareField.setText("0");
		fareField.setBounds(100, 349, 61, 24);
		add(fareField);
		fareField.setColumns(10);
		
		button = new JButton("恢复原值");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button.setBounds(543, 348, 113, 27);
		add(button);
		
		button_3 = new JButton("返回");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent.getSwitcher());
				parent.getTransfer().refreshList();
			}
		});
		button_3.setBounds(670, 348, 113, 27);
		add(button_3);

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
	
	private boolean checkFormat(){
		if(classField.getText().equals(""))
			return createTip("班次号不能为空！");
		else if(counterField.getText().equals(""))
			return createTip("货柜号不能为空！");
		else if(manageField.getText().equals(""))
			return createTip("监察员不能为空！");
		return true;
	}

	private boolean createTip(String str){
		TipDialog tipDialog=new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);	
		return false;
	}
}
