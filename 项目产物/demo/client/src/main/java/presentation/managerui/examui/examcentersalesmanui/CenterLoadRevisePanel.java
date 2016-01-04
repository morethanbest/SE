package presentation.managerui.examui.examcentersalesmanui;

import java.awt.CardLayout;
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

import businesslogic.managerbl.ExamPack.ExamController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.managerblservice.ExamCLForms;
import businesslogicservice.managerblservice.OrganizationBlService;
import po.Formstate;
import po.Organizationtype;
import po.ResultMessage;
import presentation.managerui.examui.ExamPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import presentation.tip.TipDialog;
import vo.CenterloadVO;
import vo.OrganizationVO;

public class CenterLoadRevisePanel extends WorkPanel {
	private MyTextField yaField;
	private MyTextField carField;
	private MyTextField jianField;
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyButton_LightBlue update;
	private JTable table;
	private MyComboBox<String> destinBox;
	private JLabel moterLabel;
	private String city;
	private ExamCLForms ea;
	private MyButton_LightBlue button_2;
	private MyButton_LightBlue button_3;
	private CenterloadVO vo;
	private MyTextField fareField;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;

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
		
		fareField = new MyTextField();
		fareField.setText("0");
		fareField.setBounds(195, 302, 61, 24);
		add(fareField);
		fareField.setColumns(10);
		
		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(84, 118, 74, 24);
		add(yearBox);
		
		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(168, 118, 61, 24);
		add(monthBox);
		
		addYearItems(yearBox, monthBox);
		
		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(239, 118, 61, 24);
		add(dateBox);
		
		addDateItems(yearBox, monthBox, dateBox);
		
		destinBox = new MyComboBox<String>();
		destinBox.setBounds(84, 186, 216, 24);
		add(destinBox);
		
		addOrganizationItems(destinBox);
		
		update = new MyButton_LightBlue("提交修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				if(carField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入车辆代号！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);	
				}else if(jianField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入监装员！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);	
				}else if(yaField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入押运员！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);	
				}else if(fareField.getText().equals("")){
					TipDialog tipDialog=new TipDialog("请输入运费合计！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);	
				}else if(tableModel.getRowCount()==0){
					TipDialog tipDialog=new TipDialog("请输入装车条形码！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);	
				}else{
					Long date = (Long) yearBox.getSelectedItem() * 10000
							+ (Long) monthBox.getSelectedItem() * 100
							+ (Long) dateBox.getSelectedItem();
					List<String> barcodes = new ArrayList<String>();
					int rowCount=tableModel.getRowCount();
					for (int i = 0; i < rowCount; i++) {
						barcodes.add((String) tableModel.getValueAt(i, 0));
					}
					double fare = Double.parseDouble(fareField.getText());
					ResultMessage resultMessage=ea.updateCenterLoadForm(new CenterloadVO(date,
							moterLabel.getText(), (String) destinBox
									.getSelectedItem(), carField.getText(),
							jianField.getText(), yaField.getText(), barcodes,
							fare, vo.getFormstate()));
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
		update.setBounds(503, 376, 113, 27);
		add(update);
		
		carField = new MyTextField();
		carField.setColumns(10);
		carField.setBounds(400, 53, 193, 24);
		add(carField);
		
		jianField = new MyTextField();
		jianField.setColumns(10);
		jianField.setBounds(400, 118, 193, 24);
		add(jianField);
		
		yaField = new MyTextField();
		yaField.setColumns(10);
		yaField.setBounds(400, 187, 193, 24);
		add(yaField);
		
		JLabel label = new JLabel("运费合计：");
		label.setBounds(14, 304, 84, 18);
		add(label);
		
		MyScrollPane scrollPane = new MyScrollPane();
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

		
		button_2 = new MyButton_LightBlue("增加一条");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.addRow(new String[]{""});
			}
		});
		button_2.setBounds(671, 295, 113, 27);
		add(button_2);
		
		button_3 = new MyButton_LightBlue("删除该条");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rownum = table.getSelectedRow();
				tableModel.removeRow(rownum);
			}
		});
		button_3.setBounds(824, 295, 113, 27);
		add(button_3);
		
		MyButton_LightBlue button = new MyButton_LightBlue("恢复原值");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button.setBounds(630, 376, 113, 27);
		add(button);
		
		MyButton_LightBlue button_1 = new MyButton_LightBlue("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent);
				parent.getCl().refreshList();
			}
		});
		button_1.setBounds(757, 376, 113, 27);
		add(button_1);
		
		label_1 = new JLabel("装车日期：");
		label_1.setBounds(14, 123, 74, 15);
		add(label_1);
		
		label_2 = new JLabel("目的地：");
		label_2.setBounds(14, 191, 54, 15);
		add(label_2);
		
		label_3 = new JLabel("车辆代号：");
		label_3.setBounds(315, 57, 75, 15);
		add(label_3);
		
		label_4 = new JLabel("监装员：");
		label_4.setBounds(315, 123, 54, 15);
		add(label_4);
		
		label_5 = new JLabel("押运员：");
		label_5.setBounds(315, 191, 54, 15);
		add(label_5);
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
