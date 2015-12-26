package presentation.centersalesmanui.loadui;

import java.awt.CardLayout;
import java.awt.SystemColor;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.logisticsbl.CenterloadPack.CenterloadController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.logisticsblservice.CenterloadBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import po.Formstate;
import po.Organizationtype;
import po.ResultMessage;
import presentation.centersalesmanui.CenterSalesmanPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.CenterloadVO;
import vo.OrganizationVO;

public class CenterLoadUpdatePanel extends WorkPanel {
	private MyTextField yaField;
	private NumberField carField;
	private MyTextField jianField;
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyButton_LightBlue update;
	private JTable table;
	private MyComboBox<String> destinBox;
	private JLabel moterLabel;
	private String city;
	private CenterloadBlService controller;
	private MyButton_LightBlue button_2;
	private MyButton_LightBlue button_3;
	private CenterloadVO vo;
	private MyTextField fareField;

	/**
	 * Create the panel.
	 */
	public CenterLoadUpdatePanel(CenterSalesmanPanel parent, CardLayout card) {
		controller = new CenterloadController();
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);
		
		moterLabel = new JLabel("");
		moterLabel.setBounds(14, 53, 242, 24);
		add(moterLabel);
		
		fareField = new MyTextField();
		fareField.setText("0");
		fareField.setBounds(122, 351, 61, 24);
		add(fareField);
		fareField.setColumns(10);
		
		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(14, 118, 74, 24);
		add(yearBox);
		
		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(112, 118, 61, 24);
		add(monthBox);
		
		addYearItems(yearBox, monthBox);
		
		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(195, 118, 61, 24);
		add(dateBox);
		
		addDateItems(yearBox, monthBox, dateBox);
		
		destinBox = new MyComboBox<String>();
		destinBox.setBounds(14, 187, 242, 24);
		add(destinBox);
		
		addOrganizationItems(destinBox);
		
		update = new MyButton_LightBlue("提交修改");
		update.addActionListener(new ActionListener() {
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
				double fare = Double.parseDouble(fareField.getText());
				ResultMessage r = controller.addCenterLoadForm(new CenterloadVO(date,
						moterLabel.getText(), (String) destinBox
								.getSelectedItem(), carField.getText(),
						jianField.getText(), yaField.getText(), barcodes,
						fare, vo.getFormstate()));
				if(r == ResultMessage.success)
					createTip("修改成功！");
				else
					createTip("修改失败！");
			}
		});
		update.setBounds(503, 376, 113, 27);
		add(update);
		
		carField = new NumberField(20);
		carField.setColumns(10);
		carField.setBounds(351, 53, 242, 24);
		add(carField);
		
		jianField = new MyTextField();
		jianField.setColumns(10);
		jianField.setBounds(351, 118, 242, 24);
		add(jianField);
		
		yaField = new MyTextField();
		yaField.setColumns(10);
		yaField.setBounds(351, 187, 242, 24);
		add(yaField);
		
		JLabel label = new JLabel("运费合计：");
		label.setBounds(14, 354, 84, 18);
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
				card.previous(parent.getSwitcher());
				parent.getLoad().refreshList();
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
		dateBox.setSelectedItem(vo.getLoadtime() % 100);
		destinBox.setSelectedItem(vo.getDestination());
		carField.setText(vo.getVehiclecode());
		jianField.setText(vo.getSupervisor());
		yaField.setText(vo.getSupercargo());
		fareField.setText(vo.getfee() + "");
		
		update.setEnabled(vo.getFormstate() == Formstate.waiting || vo.getFormstate() == Formstate.fail);
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
	
	private boolean createTip(String str){
		TipDialog tipDialog=new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);	
		return false;
	}
}
