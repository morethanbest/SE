package presentation.hallsalesmanui.goodrecieving;

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

import businesslogic.logisticsbl.CheckForExistBl;
import businesslogic.logisticsbl.GoodsRecevingPack.GoodsRecevingController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.logisticsblservice.CheckForExistBlService;
import businesslogicservice.logisticsblservice.GoodsRecevingBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import po.Arrivalstate;
import po.Formstate;
import po.Organizationtype;
import po.ResultMessage;
import presentation.hallsalesmanui.HallsalesmanPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.TipDialog;
import vo.GoodsReceivingVO;
import vo.OrganizationVO;

public class GoodRecievingPanel extends WorkPanel {
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyComboBox<String> destinBox;
	private MyComboBox<String> stateBox;
	private MyButton_LightBlue button;
	private GoodsRecevingBlService goodsRecevingBlService;
	private MyTextField codeField;
	private String city;
	private MyComboBox<String> typeBox;
	private MyButton_LightBlue button_1;

	/**
	 * Create the panel.
	 */
	public GoodRecievingPanel(String orgCode, String city, HallsalesmanPanel parent, CardLayout card) {
		this.city = city;
		goodsRecevingBlService = new GoodsRecevingController();
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		codeField = new MyTextField();
		codeField.setBounds(140, 230, 242, 24);
		add(codeField);
		codeField.setColumns(10);

		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(140, 67, 74, 24);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(238, 67, 61, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(321, 67, 61, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		destinBox = new MyComboBox<String>();
		destinBox.setBounds(518, 67, 242, 24);
		add(destinBox);
		addOrganizationItems(destinBox);

		stateBox = new MyComboBox<String>();
		stateBox.setBounds(518, 149, 242, 24);
		add(stateBox);
		addStateTypeItems();

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

		typeBox = new MyComboBox<String>();
		typeBox.setBounds(140, 149, 242, 24);
		add(typeBox);
		addTypeItems();

		button = new MyButton_LightBlue("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkFormat())
					return;
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				ResultMessage r = goodsRecevingBlService.GoodsReceving(new GoodsReceivingVO(
						goodsRecevingBlService.getid(orgCode), date,typeBox.getSelectedIndex() == 1 ,codeField
								.getText(), (String) destinBox
								.getSelectedItem(),
						getStateType((String) stateBox.getSelectedItem()),
						Formstate.waiting));
				if(r == ResultMessage.success)
					addSucess();
				else
					createTip("添加失败！");
			}
		});
		button.setBounds(423, 336, 113, 27);
		add(button);
		
		JLabel label = new JLabel("收货日期：");
		label.setBounds(54, 70, 86, 18);
		add(label);
		
		JLabel label_1 = new JLabel("单据类型：");
		label_1.setBounds(54, 149, 82, 18);
		add(label_1);
		
		JLabel label_2 = new JLabel("单据编号：");
		label_2.setBounds(54, 233, 82, 18);
		add(label_2);
		
		JLabel label_3 = new JLabel("目的地：");
		label_3.setBounds(448, 70, 71, 18);
		add(label_3);
		
		JLabel label_4 = new JLabel("到达状态：");
		label_4.setBounds(433, 152, 86, 18);
		add(label_4);
		
		button_1 = new MyButton_LightBlue("查看已提交单据");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.next(parent.getSwitcher());
				parent.getGc().refreshList();
			}
		});
		button_1.setBounds(756, 336, 136, 27);
		add(button_1);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{yearBox, monthBox, dateBox, typeBox, codeField, destinBox, stateBox}));
	}

	private void addTypeItems() {
		typeBox.addItem("中转中心-装车单编号");
		typeBox.addItem("营业厅-汽运编号");
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

	private void addStateTypeItems() {
		for (Arrivalstate state : Arrivalstate.values()) {
			stateBox.addItem(state.getName());
		}
	}

	private Arrivalstate getStateType(String str) {
		for (Arrivalstate state : Arrivalstate.values()) {
			if (state.getName().equals(str)) {
				return state;
			}
		}
		return null;
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

	
	private boolean checkFormat(){
		CheckForExistBlService check2 = new CheckForExistBl();
		if(typeBox.getSelectedIndex() == 0){
			if(!check2.checkHallLoad(codeField.getText()))
				return createTip("汽运编号:" + codeField.getText() + " 不存在！");
		}else if(typeBox.getSelectedIndex() == 1){
			if(!check2.checkTrans(codeField.getText()))
				return createTip("中转单编号:" + codeField.getText() + " 不存在！");
		}
		return true;
	}
	
	private void addSucess(){
		createTip("添加成功！");
		codeField.setText("");
	}
	
	private boolean createTip(String str){
		TipDialog tipDialog=new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);	
		return false;
	}
	
}
