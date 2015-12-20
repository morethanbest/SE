package presentation.managerui.examui.examhallsalesmanui;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import po.Formstate;
import po.Organizationtype;
import po.ResultMessage;
import presentation.managerui.examui.ExamPanel;
import presentation.tip.DoubleField;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.HallLoadVO;
import vo.OrganizationVO;
import businesslogic.logisticsbl.HallLoadPack.HallLoadController;
import businesslogic.managerbl.ExamPack.ExamController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.logisticsblservice.HallLoadBlService;
import businesslogicservice.managerblservice.ExamHLForms;
import businesslogicservice.managerblservice.OrganizationBlService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class HallLoadRevisePanel extends JPanel {
	private NumberField carField;
	private JTextField jianField;
	private JTextField yaField;
	private JTable table;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JButton update;
	private ExamHLForms ea;
	private HallLoadVO vo;
	private JLabel moterLabel;
	private JLabel orgLabel;
	private JLabel destinLabel;
	private DoubleField fareField;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	/**
	 * Create the panel.
	 */
	public HallLoadRevisePanel(ExamPanel parent, CardLayout card) {
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		ea = new ExamController();

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(302, 0, 2, 357);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(634, 0, 2, 357);
		add(separator_1);
		
		orgLabel = new JLabel("");
		orgLabel.setBounds(86, 44, 202, 18);
		add(orgLabel);

		carField = new NumberField(20);
		carField.setColumns(10);
		carField.setBounds(421, 44, 199, 24);
		add(carField);
		
		moterLabel = new JLabel("");
		moterLabel.setBounds(86, 132, 202, 18);
		add(moterLabel);

		jianField = new JTextField();
		jianField.setColumns(10);
		jianField.setBounds(421, 126, 199, 24);
		add(jianField);

		yaField = new JTextField();
		yaField.setBounds(421, 214, 199, 24);
		add(yaField);
		yaField.setColumns(10);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(89, 214, 69, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(172, 214, 51, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(237, 214, 51, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(671, 13, 266, 283);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "\u672C\u6B21\u88C5\u8F66\u6240\u6709\u6761\u5F62\u7801" }));
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);

		update = new JButton("提交修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(carField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入车辆编号！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);		
				}else if(jianField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入监装员！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);		
				}else if(yaField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入出发地！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);		
				}else if(fareField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入运费合计！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);		
				}else{
					Long date = (Long) yearBox.getSelectedItem() * 10000
							+ (Long) monthBox.getSelectedItem() * 100
							+ (Long) dateBox.getSelectedItem();
					List<String> barcodes = new ArrayList<String>();
					DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
					int rowCount=tableModel.getRowCount();
					for (int i = 0; i < rowCount; i++) {
						barcodes.add((String) tableModel.getValueAt(i, 0));
					}
					double fare = Double.parseDouble(fareField.getText());
					ResultMessage resultMessage=ea.updateLoadForm(new HallLoadVO(date, vo.getStringcode(),
							moterLabel.getText(), vo.getDestination(), carField.getText(),
							jianField.getText(), yaField.getText(), barcodes,
							fare, vo.getDocumentstate()));
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
		update.setBounds(433, 375, 113, 27);
		add(update);

		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearBox, monthBox, dateBox);
			}
		};
		yearBox.addItemListener(listener);
		monthBox.addItemListener(listener);
		
		
		JButton button_1 = new JButton("增加一条");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.addRow(new String[]{""});
			}
		});
		button_1.setBounds(671, 309, 113, 27);
		add(button_1);

		JButton button_2 = new JButton("删除该条");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rownum = table.getSelectedRow();
				tableModel.removeRow(rownum);
			}
		});
		button_2.setBounds(824, 309, 113, 27);
		add(button_2);
		
		destinLabel = new JLabel("");
		destinLabel.setBounds(22, 290, 266, 18);
		add(destinLabel);
		
		fareField = new DoubleField(20);
		fareField.setText("0");
		fareField.setBounds(421, 290, 86, 24);
		add(fareField);
		fareField.setColumns(10);
		
		JButton button = new JButton("恢复原值");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button.setBounds(560, 375, 113, 27);
		add(button);
		
		JButton button_3 = new JButton("返回");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent);
				parent.getHl().refreshList();
			}
		});
		button_3.setBounds(684, 375, 113, 27);
		add(button_3);
		
		label = new JLabel("装车日期：");
		label.setBounds(22, 218, 69, 15);
		add(label);
		
		label_1 = new JLabel("车辆代号：");
		label_1.setBounds(327, 47, 69, 15);
		add(label_1);
		
		label_2 = new JLabel("监装员：");
		label_2.setBounds(327, 132, 69, 15);
		add(label_2);
		
		label_3 = new JLabel("出发地：");
		label_3.setBounds(327, 218, 69, 15);
		add(label_3);
		
		label_4 = new JLabel("运费合计：");
		label_4.setBounds(327, 293, 69, 15);
		add(label_4);
		
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
	
	public void init(HallLoadVO vo){
		this.vo = vo;
		orgLabel.setText(vo.getStringcode());
		moterLabel.setText(vo.getMotorcode());
		yearBox.setSelectedItem(vo.getLoadtime() / 10000);
		monthBox.setSelectedItem((vo.getLoadtime() % 10000) / 100);
		dateBox.setSelectedItem(vo.getLoadtime() % 1000000);
		destinLabel.setText("目的地：" + vo.getDestination());
		carField.setText(vo.getVehicldecode());
		jianField.setText(vo.getSupervisor());
		yaField.setText(vo.getSupercargo());
		fareField.setText(vo.getfee() + "");
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			tableModel.removeRow(i);
		}
		List<String> list = vo.getAllbarcode();
		for (int i = 0; i < list.size(); i++) {
			tableModel.addRow(new String[]{list.get(i)});
		}
		
		update.setEnabled(vo.getDocumentstate() == Formstate.waiting || vo.getDocumentstate() == Formstate.fail);
	}
}
