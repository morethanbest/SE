package presentation.depotui.stockoutui;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import businesslogic.commoditybl.StockoutPack.StockoutController;
import businesslogic.logisticsbl.CheckForExistBl;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogic.orderbl.CheckExist;
import businesslogicservice.commodityblservice.StockoutBlService;
import businesslogicservice.logisticsblservice.CheckForExistBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import businesslogicservice.orderblservice.CheckExistBlService;
import po.Formstate;
import po.Organizationtype;
import po.ResultMessage;
import presentation.depotui.DepotPanel;
import presentation.enums.TransportTypes;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.NumberField;
import presentation.tip.OrderField;
import presentation.tip.TipDialog;
import vo.OrganizationVO;
import vo.StockoutVO;

public class StockoutPanel extends WorkPanel {
	private OrderField orderField;
	private NumberField codeField;
	private MyComboBox<String> typeBox;
	private MyComboBox<String> orgBox;
	private MyComboBox<String> transportBox;
	private MyComboBox<Long> yearBox;
	private String city;
	private MyComboBox<Long> dateBox;
	private MyComboBox<Long> monthBox;
	private MyButton_LightBlue button;
	private StockoutBlService stockoutBlService;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private MyButton_LightBlue button_1;

	/**
	 * Create the panel.
	 */
	public StockoutPanel(String orgCode, String city, DepotPanel parent, CardLayout card) {
		this.city = city;
		stockoutBlService = new StockoutController();
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		orderField = new OrderField();
		orderField.setColumns(10);
		orderField.setBounds(141, 35, 220, 24);
		add(orderField);

		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(555, 35, 78, 24);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(641, 35, 65, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(710, 35, 65, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		typeBox = new MyComboBox<String>();
		typeBox.setBounds(141, 106, 220, 24);
		add(typeBox);
		typeBox.addItem("运往市内");
		typeBox.addItem("运往市外");

		transportBox = new MyComboBox<String>();
		transportBox.setBounds(555, 106, 220, 24);
		add(transportBox);
		addTransportTypeItems();

		codeField = new NumberField(19);
		codeField.setColumns(10);
		codeField.setBounds(555, 181, 220, 24);
		add(codeField);

		orgBox = new MyComboBox<String>();
		orgBox.setBounds(141, 181, 220, 24);
		add(orgBox);
		addOrganizationItems(orgBox);

		button = new MyButton_LightBlue("提交");
		button.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				Long date = (Long) yearBox.getSelectedItem() * 10000
					+ (Long) monthBox.getSelectedItem() * 100
					+ (Long) dateBox.getSelectedItem();
				if(checkFormat()){
				if(stockoutBlService.Stockout(new StockoutVO(stockoutBlService
						.getid(orgCode), orderField.getText(), date,
						(String) orgBox.getSelectedItem(),
						(String) transportBox.getSelectedItem(), codeField
								.getText(), Formstate.waiting)) == ResultMessage.success)
					addSucess();
				else
					createTip("添加失败！\n请检查该订单是否在仓库中...");
				}
			}
		});
		button.setBounds(397, 302, 113, 27);
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
		yearBox.setSelectedItem((long) c.get(Calendar.YEAR));
		monthBox.setSelectedItem((long) c.get(Calendar.MONTH) + 1);
		dateBox.setSelectedItem((long) c.get(Calendar.DAY_OF_MONTH));
		
		label = new JLabel("订单编号：");
		label.setBounds(55, 37, 86, 18);
		add(label);
		
		label_1 = new JLabel("运送方向：");
		label_1.setBounds(55, 108, 86, 18);
		add(label_1);
		
		label_2 = new JLabel("机构名称：");
		label_2.setBounds(55, 187, 86, 18);
		add(label_2);
		
		label_3 = new JLabel("中转类型：");
		label_3.setBounds(476, 106, 82, 18);
		add(label_3);
		
		label_4 = new JLabel("单据编号：");
		label_4.setBounds(476, 184, 82, 18);
		add(label_4);
		
		label_5 = new JLabel("出库日期：");
		label_5.setBounds(476, 38, 82, 18);
		add(label_5);
		
		button_1 = new MyButton_LightBlue("查看已提交单据");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(parent.getSwitcher());
				parent.getOutc().refreshList();
			}
		});
		button_1.setBounds(710, 283, 113, 27);
		add(button_1);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{orderField, typeBox, orgBox, yearBox, monthBox, dateBox, transportBox, codeField}));

		typeBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addOrganizationItems(orgBox);

			}
		});

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
		List<OrganizationVO> orgList;
		if (typeBox.getSelectedIndex() == 1) {
			orgList = organizationBlService
					.getOrganizationbyType(Organizationtype.transfercenter);
		} else {
			orgList = organizationBlService.getOrganizationbyCity(city);
		}
		for (OrganizationVO org : orgList) {
			orgSelect.addItem(org.getName());
		}
	}

	private void addTransportTypeItems() {
		for (TransportTypes transport : TransportTypes.values()) {
			transportBox.addItem(transport.getName());
		}
	}
	
	private boolean checkFormat(){
		CheckExistBlService check = new CheckExist();
		CheckForExistBlService check2 = new CheckForExistBl();
		if(orderField.getText().length() != 10){
			return createTip("订单编号必须为10位！");
		} else if(!check.checkExist(orderField.getText())){
			return createTip("订单:" + orderField.getText() + " 不存在！");
		}
		else if(typeBox.getSelectedIndex() == 0){
			if(!check2.checkCenterLoad(codeField.getText()))
				return createTip("汽运编号:" + codeField.getText() + " 不存在！");
		}else if(typeBox.getSelectedIndex() == 1){
			if(!check2.checkTrans(codeField.getText()))
				return createTip("中转单编号:" + codeField.getText() + " 不存在！");
		}
		return true;
	}
	
	private void addSucess(){
		createTip("添加成功！");
		orderField.setText("");
		codeField.setText("");
	}
	
	private boolean createTip(String str){
		TipDialog tipDialog=new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);	
		return false;
	}
}
