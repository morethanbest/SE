package presentation.centersalesmanui.loadui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import po.Formstate;
import po.Organizationtype;
import po.ResultMessage;
import presentation.centersalesmanui.CenterSalesmanPanel;
import presentation.tip.TipDialog;
import vo.CenterloadVO;
import vo.HallLoadVO;
import vo.OrganizationVO;
import businesslogic.logisticsbl.CheckForExistBl;
import businesslogic.logisticsbl.CenterloadPack.CenterloadController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.logisticsblservice.CenterloadBlService;
import businesslogicservice.logisticsblservice.CheckForExistBlService;
import businesslogicservice.managerblservice.OrganizationBlService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

public class CenterLoadPanel extends JPanel {
	private JTextField yaField;
	private JTextField carField;
	private JTextField jianField;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JButton button;
	private JButton button_1;
	private JLabel fareLabel;
	private JTable table;
	private JComboBox<String> destinBox;
	private JLabel moterLabel;
	private CenterloadBlService centerloadBlService;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	
	private String city;
	private String orgCode;

	/**
	 * Create the panel.
	 */
	public CenterLoadPanel(String orgCode, String city, CenterSalesmanPanel parent, CardLayout card) {
		this.city = city;
		this.orgCode = orgCode;
		centerloadBlService = new CenterloadController();
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		moterLabel = new JLabel("");
		moterLabel.setBounds(98, 53, 190, 24);
		add(moterLabel);
		
		fareLabel = new JLabel("0");
		fareLabel.setBounds(403, 259, 83, 18);
		add(fareLabel);
		
		yearBox = new JComboBox<Long>();
		yearBox.setBounds(98, 118, 58, 24);
		add(yearBox);
		
		monthBox = new JComboBox<Long>();
		monthBox.setBounds(170, 118, 52, 24);
		add(monthBox);
		
		addYearItems(yearBox, monthBox);
		
		dateBox = new JComboBox<Long>();
		dateBox.setBounds(236, 118, 52, 24);
		add(dateBox);
		
		addDateItems(yearBox, monthBox, dateBox);
		
		destinBox = new JComboBox<String>();
		destinBox.setBounds(98, 187, 190, 24);
		add(destinBox);
		
		addOrganizationItems(destinBox);
		
		button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkFormat())
					return;
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				List<String> barcodes = new ArrayList<String>();
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rowCount=tableModel.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					barcodes.add((String) tableModel.getValueAt(i, 0));
				}
				double fare = Double.parseDouble(fareLabel.getText());
				ResultMessage r = centerloadBlService.addCenterLoadForm(new CenterloadVO(date,
						moterLabel.getText(), (String) destinBox
								.getSelectedItem(), carField.getText(),
						jianField.getText(), yaField.getText(), barcodes,
						fare, Formstate.waiting));
				if(r == ResultMessage.success)
					addSucess();
				else
					createTip("添加失败！");
			}
		});
		button.setBounds(416, 348, 113, 27);
		add(button);
		
		carField = new JTextField();
		carField.setColumns(10);
		carField.setBounds(403, 53, 190, 24);
		add(carField);
		
		jianField = new JTextField();
		jianField.setColumns(10);
		jianField.setBounds(403, 118, 190, 24);
		add(jianField);
		
		yaField = new JTextField();
		yaField.setColumns(10);
		yaField.setBounds(403, 187, 190, 24);
		add(yaField);
		
		JLabel label = new JLabel("运费合计：");
		label.setBounds(305, 259, 84, 18);
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(661, 13, 284, 269);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u672C\u6B21\u88C5\u8F66\u6240\u6709\u6761\u5F62\u7801"
			}
		));
		scrollPane.setViewportView(table);
		
		button_1 = new JButton("获取运费");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkFormat())
					return;
				List<String> barcodes = new ArrayList<String>();
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rowCount=tableModel.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					barcodes.add((String) tableModel.getValueAt(i, 0));
				}
				fareLabel.setText(centerloadBlService.getfee(barcodes, city, city) + "");
			}
		});
		button_1.setBounds(500, 255, 93, 27);
		add(button_1);
		
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
		Long date = (Long) yearBox.getSelectedItem() * 10000
				+ (Long) monthBox.getSelectedItem() * 100
				+ (Long) dateBox.getSelectedItem();
		moterLabel.setText(centerloadBlService.getid(orgCode, date));
		
		button_2 = new JButton("增加一条");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.addRow(new String[]{""});
			}
		});
		button_2.setBounds(671, 295, 113, 27);
		add(button_2);
		
		button_3 = new JButton("删除该条");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rownum = table.getSelectedRow();
				tableModel.removeRow(rownum);
			}
		});
		button_3.setBounds(824, 295, 113, 27);
		add(button_3);
		
		button_4 = new JButton("查看已提交单据");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(parent.getSwitcher());
				parent.getLoad().refreshList();
			}
		});
		button_4.setBounds(752, 348, 145, 27);
		add(button_4);
		
		label_1 = new JLabel("车辆代号：");
		label_1.setBounds(305, 53, 84, 18);
		add(label_1);
		
		label_2 = new JLabel("监装员：");
		label_2.setBounds(321, 121, 68, 18);
		add(label_2);
		
		label_3 = new JLabel("押运员：");
		label_3.setBounds(321, 190, 68, 18);
		add(label_3);
		
		label_4 = new JLabel("汽运编号：");
		label_4.setBounds(0, 56, 84, 18);
		add(label_4);
		
		label_5 = new JLabel("装车日期：");
		label_5.setBounds(0, 121, 84, 18);
		add(label_5);
		
		label_6 = new JLabel("目的地：");
		label_6.setBounds(14, 190, 74, 18);
		add(label_6);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{yearBox, monthBox, dateBox, destinBox, carField, jianField, yaField}));
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
	
	public void addOrganizationItems(JComboBox<String> orgSelect) {
		orgSelect.removeAllItems();
		OrganizationBlService organizationBlService = new OrganizationController();
		List<OrganizationVO> orgList = organizationBlService
				.getOrganizationbyBoth(city, Organizationtype.hall);
		for (OrganizationVO org : orgList) {
			orgSelect.addItem(org.getName());
		}
	}
	
	private boolean checkFormat(){
		if(carField.getText().equals(""))
			return createTip("车辆代号不能为空！");
		else if(jianField.getText().equals(""))
			return createTip("监装员不能为空！");
		else if(yaField.getText().equals(""))
			return createTip("押运员不能为空！");
		return true;
	}
	
	private void addSucess(){
		createTip("添加成功！");
		carField.setText("");
		jianField.setText("");
		yaField.setText("");
		Long date = (Long) yearBox.getSelectedItem() * 10000
				+ (Long) monthBox.getSelectedItem() * 100
				+ (Long) dateBox.getSelectedItem();
		moterLabel.setText(centerloadBlService.getid(orgCode, date));
	}
	
	private boolean createTip(String str){
		TipDialog tipDialog=new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);	
		return false;
	}
}
