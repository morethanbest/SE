package presentation.hallsalesmanui.hallload;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import businesslogic.logisticsbl.HallLoadPack.HallLoadController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogic.orderbl.CheckExist;
import businesslogicservice.logisticsblservice.HallLoadBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import businesslogicservice.orderblservice.CheckExistBlService;
import po.Formstate;
import po.Organizationtype;
import po.ResultMessage;
import presentation.hallsalesmanui.HallsalesmanPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import presentation.tip.NumberField;
import presentation.tip.OrderField;
import presentation.tip.TipDialog;
import vo.HallLoadVO;
import vo.OrganizationVO;

public class HallLoadPanel extends WorkPanel {
	private NumberField carField;
	private MyTextField jianField;
	private MyTextField yaField;
	private JTable table;
	private MyComboBox<String> destinBox;
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyButton_LightBlue button;
	private HallLoadBlService hallLoadBlService;
	private JLabel moterLabel;
	private JLabel orgLabel;
	private String city;
	private MyComboBox<String> typeBox;
	private String orgName;
	private MyButton_LightBlue button_3;
	private OrderField orderField;
	private String orgCode;
	/**
	 * Create the panel.
	 */
	public HallLoadPanel(String orgCode, String city, String orgName, HallsalesmanPanel parent, CardLayout card) {
		super();
		this.city = city;
		this.orgName = orgName;
		this.orgCode = orgCode;
		setLayout(null);

		hallLoadBlService = new HallLoadController();
		
		orgLabel = new JLabel(orgCode);
		orgLabel.setBounds(97, 28, 199, 18);
		add(orgLabel);
		
		JLabel fareLabel = new JLabel("0");
		fareLabel.setBounds(423, 265, 69, 27);
		add(fareLabel);

		carField = new NumberField(20);
		carField.setColumns(10);
		carField.setBounds(410, 28, 199, 24);
		add(carField);
		
		moterLabel = new JLabel("");
		moterLabel.setBounds(97, 76, 202, 18);
		add(moterLabel);

		jianField = new MyTextField();
		jianField.setColumns(10);
		jianField.setBounds(410, 104, 199, 24);
		add(jianField);

		yaField = new MyTextField();
		yaField.setBounds(410, 183, 199, 24);
		add(yaField);
		yaField.setColumns(10);

		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(97, 128, 69, 24);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(180, 128, 51, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(245, 128, 51, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		destinBox = new MyComboBox<String>();
		destinBox.setBounds(97, 263, 199, 24);
		add(destinBox);
		
		typeBox = new MyComboBox<String>();
		typeBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(typeBox.getSelectedIndex() == 0)
					addOrganizationItems(Organizationtype.transfercenter);
				else
					addOrganizationItems(Organizationtype.hall);
			}
		});
		typeBox.setBounds(97, 195, 199, 24);
		add(typeBox);
		addTypeItems();

		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(636, 25, 276, 222);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u672C\u6B21\u88C5\u8F66\u6240\u6709\u6761\u5F62\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);

		button = new MyButton_LightBlue("提交装车单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!checkFormat())
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
				ResultMessage r = hallLoadBlService.addHallLoadForm(new HallLoadVO(date, orgCode,
						moterLabel.getText(), (String) destinBox
								.getSelectedItem(), carField.getText(),
						jianField.getText(), yaField.getText(), barcodes,
						fare, Formstate.waiting));
				if (r == ResultMessage.success)
					addSucess();
				else
					createTip("添加失败！");
			}
		});
		button.setBounds(416, 350, 113, 27);
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
		
		
		MyButton_LightBlue button_1 = new MyButton_LightBlue("增加一条");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckExistBlService check = new CheckExist();
				if (orderField.getText().length() != 10) {
					createTip("订单编号必须为10位！");
					return;
				} else if (!check.checkExist(orderField.getText())) {
					createTip("订单:" + orderField.getText() + " 不存在！");
					return;
				}
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				tableModel.addRow(new String[]{orderField.getText()});
				orderField.setText("");
			}
		});
		button_1.setBounds(804, 252, 108, 27);
		add(button_1);

		orderField = new OrderField();
		orderField.setColumns(10);
		orderField.setBounds(642, 253, 154, 24);
		add(orderField);
		
		MyButton_LightBlue button_2 = new MyButton_LightBlue("删除该条");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				int rownum = table.getSelectedRow();
				tableModel.removeRow(rownum);
			}
		});
		button_2.setBounds(636, 286, 276, 27);
		add(button_2);
		
		MyButton_LightBlue getFareButton = new MyButton_LightBlue("获取运费");
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
		getFareButton.setBounds(506, 265, 103, 27);
		add(getFareButton);
		
		JLabel label = new JLabel("装车日期：");
		label.setBounds(14, 134, 85, 18);
		add(label);
		
		JLabel label_1 = new JLabel("汽运编号：");
		label_1.setBounds(14, 76, 85, 18);
		add(label_1);
		
		JLabel label_2 = new JLabel("机构编号：");
		label_2.setBounds(14, 28, 85, 18);
		add(label_2);
		
		JLabel label_3 = new JLabel("单据类型：");
		label_3.setBounds(14, 198, 85, 18);
		add(label_3);
		
		JLabel label_4 = new JLabel("车辆代号：");
		label_4.setBounds(327, 31, 82, 18);
		add(label_4);
		
		JLabel label_5 = new JLabel("运费合计：");
		label_5.setBounds(327, 269, 82, 18);
		add(label_5);
		
		JLabel label_6 = new JLabel("监装员：");
		label_6.setBounds(340, 107, 69, 18);
		add(label_6);
		
		JLabel label_7 = new JLabel("押运员：");
		label_7.setBounds(340, 186, 69, 18);
		add(label_7);
		
		JLabel label_8 = new JLabel("目的地：");
		label_8.setBounds(27, 269, 72, 18);
		add(label_8);
		
		button_3 = new MyButton_LightBlue("查看已提交单据");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(parent.getSwitcher());
				parent.getHc().refreshList();
			}
		});
		button_3.setBounds(786, 364, 154, 27);
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
	
	private boolean checkFormat() {
		if (carField.getText().equals(""))
			return createTip("车辆代号不能为空！");
		else if (jianField.getText().equals(""))
			return createTip("监装员不能为空！");
		else if (yaField.getText().equals(""))
			return createTip("押运员不能为空！");
		return true;
	}

	private void addSucess() {
		createTip("添加成功！");
		carField.setText("");
		jianField.setText("");
		yaField.setText("");
		Long date = (Long) yearBox.getSelectedItem() * 10000
				+ (Long) monthBox.getSelectedItem() * 100
				+ (Long) dateBox.getSelectedItem();
		moterLabel.setText(hallLoadBlService.getid(orgCode, date));
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		for(int i=0;i<tableModel.getRowCount();i++){
			tableModel.removeRow(i);
		}
		
	}

	private boolean createTip(String str) {
		TipDialog tipDialog = new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);
		return false;
	}
}
