package presentation.hallsalesmanui.hallload;

import javax.swing.JPanel;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import po.Formstate;
import po.Organizationtype;
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
	/**
	 * Create the panel.
	 */
	public HallLoadPanel(String orgCode, String city) {
		this.city = city;
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		hallLoadBlService = new HallLoadController();

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(302, 0, 2, 357);
		add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(634, 0, 2, 357);
		add(separator_1);
		
		orgLabel = new JLabel(orgCode);
		orgLabel.setBounds(89, 47, 199, 18);
		add(orgLabel);
		
		JLabel fareLabel = new JLabel("0");
		fareLabel.setBounds(421, 281, 82, 27);
		add(fareLabel);

		carField = new JTextField();
		carField.setColumns(10);
		carField.setBounds(421, 44, 199, 24);
		add(carField);
		
		moterLabel = new JLabel("");
		moterLabel.setBounds(86, 217, 202, 18);
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
		yearBox.setBounds(89, 126, 69, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(172, 126, 51, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(237, 126, 51, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		destinBox = new JComboBox<String>();
		destinBox.setBounds(89, 303, 199, 24);
		add(destinBox);
		addOrganizationItems(destinBox);

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
				.getOrganizationbyBoth(city, Organizationtype.transfercenter);
		for (OrganizationVO org : orgList) {
			orgSelect.addItem(org.getName());
		}
	}
}
