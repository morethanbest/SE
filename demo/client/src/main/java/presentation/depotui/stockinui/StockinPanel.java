package presentation.depotui.stockinui;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import po.Block;
import po.CommodityLocation;
import po.Formstate;
import po.Organizationtype;
import po.ResultMessage;
import presentation.depotui.DepotPanel;
import presentation.tip.OrderField;
import presentation.tip.TipDialog;
import vo.OrganizationVO;
import vo.StockinVO;
import businesslogic.commoditybl.InboundPack.InboundController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogic.orderbl.CheckExist;
import businesslogicservice.commodityblservice.InboundBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import businesslogicservice.orderblservice.CheckExistBlService;

public class StockinPanel extends JPanel {
	private OrderField codeField;
	private JComboBox<String> typeBox;
	private JComboBox<String> orgBox;
	private JButton button;
	private JComboBox<String> quBox;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private String city;
	private String orgcode;
	private CommodityLocation location;
	private InboundBlService inboundBlService;
	private JComboBox<Long> paiBox;
	private JComboBox<Long> jiaBox;
	private JComboBox<Long> weiBox;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_6;
	private JButton button_1;

	/**
	 * Create the panel.
	 */
	public StockinPanel(String orgCode, String city,DepotPanel parent, CardLayout card) {
		inboundBlService = new InboundController();
		this.city = city;
		this.orgcode=orgCode;
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		codeField = new OrderField();
		codeField.setBounds(143, 35, 220, 24);
		add(codeField);
		codeField.setColumns(10);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(557, 35, 78, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(643, 35, 65, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(712, 35, 65, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		typeBox = new JComboBox<String>();
		typeBox.setBounds(143, 106, 220, 24);
		add(typeBox);
		typeBox.addItem("运往市内");
		typeBox.addItem("运往市外");

		orgBox = new JComboBox<String>();
		orgBox.setBounds(143, 185, 220, 24);
		add(orgBox);
		addOrganizationItems(orgBox);


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

		label = new JLabel("");
		label.setBounds(823, 188, 72, 18);
		add(label);

		paiBox = new JComboBox<Long>();
		paiBox.setBounds(699, 106, 78, 24);
		add(paiBox);

		jiaBox = new JComboBox<Long>();
		jiaBox.setBounds(557, 185, 78, 24);
		add(jiaBox);

		weiBox = new JComboBox<Long>();
		weiBox.setBounds(699, 185, 78, 24);
		add(weiBox);

		

		quBox = new JComboBox<String>();
		quBox.setBounds(557, 106, 78, 24);
		add(quBox);
		addBlockItems();
		quBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addpaijiawei();
			}
		});
		addpaijiawei();
		
		ItemListener listener2 = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				checkAvailable();
			}
		};
		paiBox.addItemListener(listener2);
		jiaBox.addItemListener(listener2);
		weiBox.addItemListener(listener2);

		
		button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				location = new CommodityLocation(
						getBlockIndex((String) quBox.getSelectedItem()),
						(Long) paiBox.getSelectedItem(),
						(Long) jiaBox.getSelectedItem(),
						(Long) weiBox.getSelectedItem());
				if(checkFormat()){
					if(inboundBlService.Inbound(new StockinVO(inboundBlService
							.getid(orgCode), codeField.getText(), date, location,
							(String) orgBox.getSelectedItem(), Formstate.waiting)) == ResultMessage.success)
					addSucess();
					else
						createTip("添加失败！");
				}
			}
		});
		button.setBounds(416, 312, 113, 27);
		add(button);
		
		checkAvailable();
		
		label_1 = new JLabel("订单编号：");
		label_1.setBounds(57, 38, 86, 18);
		add(label_1);
		
		label_2 = new JLabel("运送方向：");
		label_2.setBounds(57, 109, 86, 18);
		add(label_2);
		
		label_3 = new JLabel("机构名称：");
		label_3.setBounds(57, 188, 86, 18);
		add(label_3);
		
		label_4 = new JLabel("入库日期：");
		label_4.setBounds(472, 38, 86, 18);
		add(label_4);
		
		label_5 = new JLabel("库存分区：");
		label_5.setBounds(472, 109, 86, 18);
		add(label_5);
		
		label_7 = new JLabel("排号：");
		label_7.setBounds(644, 109, 51, 18);
		add(label_7);
		
		label_8 = new JLabel("位号：");
		label_8.setBounds(643, 188, 51, 18);
		add(label_8);
		
		label_6 = new JLabel("架号：");
		label_6.setBounds(505, 188, 51, 18);
		add(label_6);
		
		button_1 = new JButton("查看已提交单据");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(parent.getSwitcher());
				parent.getInc().refreshList();
			}
		});
		button_1.setBounds(807, 312, 113, 27);
		add(button_1);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{codeField, typeBox, orgBox, yearBox, monthBox, dateBox, quBox, paiBox, jiaBox, weiBox}));

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
	
	private void addpaijiawei(){
		List<Long> list = inboundBlService.getEachBlockLimit(
				getBlockIndex((String) quBox.getSelectedItem()),
				orgcode);
		try {
			fillBox(paiBox, list.get(0));
			fillBox(jiaBox, list.get(1));
			fillBox(weiBox, list.get(2));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("addpaijiawei");
		}
		
	}
	
	private void checkAvailable(){
			location = new CommodityLocation(getBlockIndex((String) quBox.getSelectedItem()),
					(Long) paiBox.getSelectedItem(), (Long) jiaBox.getSelectedItem(),
					(Long) weiBox.getSelectedItem());
			setAvailableTip(inboundBlService.wheConflict(orgcode, location));
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

	private void addBlockItems() {
		for (Block block : Block.values()) {
			quBox.addItem(block.getName());
		}
	}

	private long getBlockIndex(String str) {
		for (Block block : Block.values()) {
			if (block.getName().equals(str))
				return block.getBlocknum();
		}

		return -1;
	}

	private void fillBox(JComboBox<Long> box, long k) {
		box.removeAllItems();
		for (long i = 1; i <= k; i++) {
			box.addItem(i);
		}
	}

	private void setAvailableTip(boolean isEmpty) {
		button.setEnabled(isEmpty);
		if (isEmpty)
			label.setText("可用");
		else
			label.setText("不可用");
	}
	
	private boolean checkFormat(){
		CheckExistBlService check = new CheckExist();
		if(codeField.getText().length() != 10){
			return createTip("订单编号必须为10位！");
		} else if(!check.checkExist(codeField.getText())){
			return createTip("订单:" + codeField.getText() + " 不存在！");
		}	
		return true;
	}
	
	private void addSucess(){
		createTip("添加成功！");
		codeField.setText("");
		setAvailableTip(false);
	}
	
	private boolean createTip(String str){
		TipDialog tipDialog=new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);	
		return false;
	}
}
