package presentation.hallsalesmanui.hallload;

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
import presentation.tip.TipDialog;
import vo.HallLoadVO;
import vo.OrganizationVO;
import businesslogic.logisticsbl.HallLoadPack.HallLoadController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.logisticsblservice.HallLoadBlService;
import businesslogicservice.managerblservice.OrganizationBlService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class HallLoadPanel extends JPanel {
	private JTextField carField;
	private JTextField jianField;
	private JTextField yaField;
	private JTable table;
	private JComboBox<String> destinBox;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JButton button;
	private HallLoadBlService hallLoadBlService;
	private JLabel moterLabel;
	private JLabel orgLabel;
	private String city;
	private JComboBox<String> typeBox;
	private String orgName;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JButton button_3;
	/**
	 * Create the panel.
	 */
	public HallLoadPanel(String orgCode, String city, String orgName, JPanel parent, CardLayout card) {
		this.city = city;
		this.orgName = orgName;
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		hallLoadBlService = new HallLoadController();
		
		orgLabel = new JLabel(orgCode);
		orgLabel.setBounds(108, 44, 199, 18);
		add(orgLabel);
		
		JLabel fareLabel = new JLabel("0");
		fareLabel.setBounds(434, 281, 69, 27);
		add(fareLabel);

		carField = new JTextField();
		carField.setColumns(10);
		carField.setBounds(421, 44, 199, 24);
		add(carField);
		
		moterLabel = new JLabel("");
		moterLabel.setBounds(108, 92, 202, 18);
		add(moterLabel);

		jianField = new JTextField();
		jianField.setColumns(10);
		jianField.setBounds(421, 120, 199, 24);
		add(jianField);

		yaField = new JTextField();
		yaField.setBounds(421, 199, 199, 24);
		add(yaField);
		yaField.setColumns(10);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(108, 144, 69, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(191, 144, 51, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(256, 144, 51, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		destinBox = new JComboBox<String>();
		destinBox.setBounds(108, 279, 199, 24);
		add(destinBox);
		
		typeBox = new JComboBox<String>();
		typeBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(typeBox.getSelectedIndex() == 0)
					addOrganizationItems(Organizationtype.transfercenter);
				else
					addOrganizationItems(Organizationtype.hall);
			}
		});
		typeBox.setBounds(108, 211, 199, 24);
		add(typeBox);
		addTypeItems();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(674, 44, 266, 283);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {},
				new String[] { "\u672C\u6B21\u88C5\u8F66\u6240\u6709\u6761\u5F62\u7801" }));
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);

		button = new JButton("提交装车单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				hallLoadBlService.addHallLoadForm(new HallLoadVO(date, orgCode,
						moterLabel.getText(), (String) destinBox
								.getSelectedItem(), carField.getText(),
						jianField.getText(), yaField.getText(), barcodes,
						fare, Formstate.waiting));
				TipDialog Dialog=new TipDialog("装车单提交成功！");
				Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				Dialog.setVisible(true);
			}
		});
		button.setBounds(427, 366, 113, 27);
		add(button);

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
		moterLabel.setText(hallLoadBlService.getid(orgCode, date));
		
		
		JButton button_1 = new JButton("增加一条");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.addRow(new String[]{""});
			}
		});
		button_1.setBounds(674, 340, 113, 27);
		add(button_1);

		JButton button_2 = new JButton("删除该条");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rownum = table.getSelectedRow();
				tableModel.removeRow(rownum);
			}
		});
		button_2.setBounds(827, 340, 113, 27);
		add(button_2);
		
		JButton getFareButton = new JButton("获取运费");
		getFareButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<String> barcodes = new ArrayList<String>();
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rowCount=tableModel.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					barcodes.add((String) tableModel.getValueAt(i, 0));
				}
				fareLabel.setText(hallLoadBlService.computeHallLoadFare(barcodes, city, city) + "");
			}
		});
		getFareButton.setBounds(517, 281, 103, 27);
		add(getFareButton);
		
		label = new JLabel("装车日期：");
		label.setBounds(25, 150, 85, 18);
		add(label);
		
		label_1 = new JLabel("汽运编号：");
		label_1.setBounds(25, 92, 85, 18);
		add(label_1);
		
		label_2 = new JLabel("机构编号：");
		label_2.setBounds(25, 44, 85, 18);
		add(label_2);
		
		label_3 = new JLabel("单据类型：");
		label_3.setBounds(25, 214, 85, 18);
		add(label_3);
		
		label_4 = new JLabel("车辆代号：");
		label_4.setBounds(338, 44, 82, 18);
		add(label_4);
		
		label_5 = new JLabel("运费合计：");
		label_5.setBounds(338, 285, 82, 18);
		add(label_5);
		
		label_6 = new JLabel("监装员：");
		label_6.setBounds(351, 123, 69, 18);
		add(label_6);
		
		label_7 = new JLabel("出发地：");
		label_7.setBounds(351, 202, 69, 18);
		add(label_7);
		
		label_8 = new JLabel("出发地：");
		label_8.setBounds(38, 285, 72, 18);
		add(label_8);
		
		button_3 = new JButton("查看已提交单据");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(parent);
			}
		});
		button_3.setBounds(786, 380, 154, 27);
		add(button_3);
	}
	
	private void addTypeItems() {
		typeBox.addItem("运往中转中心");
		typeBox.addItem("运往其他营业厅");
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

	public void addOrganizationItems(Organizationtype type) {
		destinBox.removeAllItems();
		OrganizationBlService organizationBlService = new OrganizationController();
		List<OrganizationVO> orgList = organizationBlService
				.getOrganizationbyBoth(city, type);
		for (OrganizationVO org : orgList) {
			if(!org.getName().equals(orgName))
				destinBox.addItem(org.getName());
		}
	}
}
