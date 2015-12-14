package presentation.managerui.examui.examcentersalesmanui;

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
import presentation.managerui.examui.ExamPanel;
import vo.CenterloadVO;
import vo.HallLoadVO;
import vo.OrganizationVO;
import businesslogic.logisticsbl.CenterloadPack.CenterloadController;
import businesslogic.managerbl.ExamPack.ExamController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.logisticsblservice.CenterloadBlService;
import businesslogicservice.managerblservice.ExamCLForms;
import businesslogicservice.managerblservice.OrganizationBlService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CenterLoadRevisePanel extends JPanel {
	private JTextField yaField;
	private JTextField carField;
	private JTextField jianField;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JButton update;
	private JTable table;
	private JComboBox<String> destinBox;
	private JLabel moterLabel;
	private String city;
	private ExamCLForms ea;
	private JButton button_2;
	private JButton button_3;
	private CenterloadVO vo;
	private JTextField fareField;

	/**
	 * Create the panel.
	 */
	public CenterLoadRevisePanel(ExamPanel parent, CardLayout card) {
		ea = new ExamController();
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		moterLabel = new JLabel("");
		moterLabel.setBounds(14, 53, 242, 24);
		add(moterLabel);
		
		fareField = new JTextField();
		fareField.setText("0");
		fareField.setBounds(122, 351, 61, 24);
		add(fareField);
		fareField.setColumns(10);
		
		yearBox = new JComboBox<Long>();
		yearBox.setBounds(14, 118, 74, 24);
		add(yearBox);
		
		monthBox = new JComboBox<Long>();
		monthBox.setBounds(112, 118, 61, 24);
		add(monthBox);
		
		addYearItems(yearBox, monthBox);
		
		dateBox = new JComboBox<Long>();
		dateBox.setBounds(195, 118, 61, 24);
		add(dateBox);
		
		addDateItems(yearBox, monthBox, dateBox);
		
		destinBox = new JComboBox<String>();
		destinBox.setBounds(14, 187, 242, 24);
		add(destinBox);
		
		addOrganizationItems(destinBox);
		
		update = new JButton("提交修改");
		update.addActionListener(new ActionListener() {
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
				double fare = Double.parseDouble(fareField.getText());
				ea.updateCenterLoadForm(new CenterloadVO(date,
						moterLabel.getText(), (String) destinBox
								.getSelectedItem(), carField.getText(),
						jianField.getText(), yaField.getText(), barcodes,
						fare, vo.getFormstate()));
			}
		});
		update.setBounds(503, 376, 113, 27);
		add(update);
		
		carField = new JTextField();
		carField.setColumns(10);
		carField.setBounds(351, 53, 242, 24);
		add(carField);
		
		jianField = new JTextField();
		jianField.setColumns(10);
		jianField.setBounds(351, 118, 242, 24);
		add(jianField);
		
		yaField = new JTextField();
		yaField.setColumns(10);
		yaField.setBounds(351, 187, 242, 24);
		add(yaField);
		
		JLabel label = new JLabel("运费合计：");
		label.setBounds(14, 354, 84, 18);
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(661, 53, 284, 229);
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
		
		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearBox, monthBox, dateBox);
			}
		};
		yearBox.addItemListener(listener);
		monthBox.addItemListener(listener);

		
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
		
		JButton button = new JButton("恢复原值");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button.setBounds(630, 376, 113, 27);
		add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent);
			}
		});
		button_1.setBounds(757, 376, 113, 27);
		add(button_1);
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
	
	public void init(CenterloadVO vo){
		this.vo = vo;
		moterLabel.setText(vo.getMotorcode());
		yearBox.setSelectedItem(vo.getLoadtime() / 10000);
		monthBox.setSelectedItem((vo.getLoadtime() % 10000) / 100);
		dateBox.setSelectedItem(vo.getLoadtime() % 1000000);
		destinBox.setSelectedItem(vo.getDestination());
		carField.setText(vo.getVehiclecode());
		jianField.setText(vo.getSupervisor());
		yaField.setText(vo.getSupercargo());
		fareField.setText(vo.getfee() + "");
		
		update.setEnabled(vo.getFormstate() == Formstate.waiting || vo.getFormstate() == Formstate.fail);
	}
}
