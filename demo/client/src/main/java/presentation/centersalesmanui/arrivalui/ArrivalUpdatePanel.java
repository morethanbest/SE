package presentation.centersalesmanui.arrivalui;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import businesslogic.logisticsbl.CheckForExistBl;
import businesslogic.logisticsbl.ArrivalPack.ArrivalController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.logisticsblservice.ArrivalBlService;
import businesslogicservice.logisticsblservice.CheckForExistBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import po.Arrivalstate;
import po.Formstate;
import po.Organizationtype;
import po.ResultMessage;
import presentation.centersalesmanui.CenterSalesmanPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.ArrivalVO;
import vo.OrganizationVO;

public class ArrivalUpdatePanel extends WorkPanel {
	private NumberField codeField;
	private JLabel orgLabel;
	private MyComboBox<Long> yearBox;
	private MyComboBox<Long> monthBox;
	private MyComboBox<Long> dateBox;
	private MyButton_LightBlue update;
	private MyComboBox<String> departureBox;
	private MyComboBox<String> stateBox;
	private ArrivalBlService controller;
	private MyComboBox<String> typeBox;
	private MyButton_LightBlue button_1;
	private MyButton_LightBlue button_2;
	private ArrivalVO vo;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;

	/**
	 * Create the panel.
	 */
	public ArrivalUpdatePanel(CenterSalesmanPanel parent, CardLayout card, String orgName) {
		controller = new ArrivalController();

		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		orgLabel = new JLabel("");
		orgLabel.setBounds(139, 50, 242, 18);
		add(orgLabel);

		yearBox = new MyComboBox<Long>();
		yearBox.setBounds(139, 132, 74, 24);
		add(yearBox);

		monthBox = new MyComboBox<Long>();
		monthBox.setBounds(237, 132, 61, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new MyComboBox<Long>();
		dateBox.setBounds(320, 132, 61, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		stateBox = new MyComboBox<String>();
		stateBox.setBounds(547, 131, 242, 24);
		add(stateBox);
		addStateTypeItems();

		update = new MyButton_LightBlue("提交修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!checkFormat())
					return;
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				ResultMessage r;
				if(typeBox.getSelectedIndex() == 1)
					r = controller.updateFromHall(new ArrivalVO(vo.getId(), orgLabel.getText(), date,
							typeBox.getSelectedIndex() == 1 ,codeField.getText(),
							(String) departureBox.getSelectedItem(),
							getStateType((String) stateBox.getSelectedItem()),
							vo.getFormstate()), orgName);
				else
					r = controller.updateFromCenter(new ArrivalVO(vo.getId(), orgLabel.getText(), date,
							typeBox.getSelectedIndex() == 1 ,codeField.getText(),
							(String) departureBox.getSelectedItem(),
							getStateType((String) stateBox.getSelectedItem()),
							vo.getFormstate()), orgName);
				if(r == ResultMessage.success)
						createTip("修改成功！");
					else
						createTip("修改失败！");
			}
		});
		update.setBounds(444, 333, 122, 36);
		add(update);

		codeField = new NumberField(20);
		codeField.setColumns(10);
		codeField.setBounds(547, 213, 242, 24);
		add(codeField);

		departureBox = new MyComboBox<String>();
		departureBox.setBounds(547, 50, 242, 24);
		add(departureBox);
		addOrganizationItems(departureBox);

		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addDateItems(yearBox, monthBox, dateBox);
			}
		};
		yearBox.addItemListener(listener);
		monthBox.addItemListener(listener);

		typeBox = new MyComboBox<String>();
		typeBox.setBounds(139, 213, 242, 24);
		add(typeBox);
		
		button_1 = new MyButton_LightBlue("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent.getSwitcher());
				parent.getArrival().refreshList();
			}
		});
		button_1.setBounds(716, 333, 122, 36);
		add(button_1);
		
		button_2 = new MyButton_LightBlue("恢复原值");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button_2.setBounds(580, 333, 122, 36);
		add(button_2);
		
		label = new JLabel("机构编号：");
		label.setBounds(49, 50, 85, 18);
		add(label);
		
		label_1 = new JLabel("到达日期：");
		label_1.setBounds(49, 135, 85, 18);
		add(label_1);
		
		label_2 = new JLabel("到达类型：");
		label_2.setBounds(49, 216, 85, 18);
		add(label_2);
		
		label_3 = new JLabel("出发地：");
		label_3.setBounds(457, 50, 72, 18);
		add(label_3);
		
		label_4 = new JLabel("到达状态：");
		label_4.setBounds(457, 135, 76, 18);
		add(label_4);
		
		label_5 = new JLabel("单据编号：");
		label_5.setBounds(457, 216, 76, 18);
		add(label_5);
		addTypeItems();
	}
	
	private void addTypeItems() {
		typeBox.addItem("中转中心-中转单编号");
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
				.getOrganizationbyType(Organizationtype.transfercenter);
		for (OrganizationVO org : orgList) {
			orgSelect.addItem(org.getName());
		}
	}
	
	public void init(ArrivalVO vo){
		this.vo = vo;
		orgLabel.setText(vo.getCentercode());
		yearBox.setSelectedItem(vo.getArrivaltime() / 10000);
		monthBox.setSelectedItem((vo.getArrivaltime() % 10000) / 100);
		dateBox.setSelectedItem(vo.getArrivaltime() % 1000000);
		if(vo.getwhefromhall())
			typeBox.setSelectedIndex(1);
		else
			typeBox.setSelectedIndex(0);
		departureBox.setSelectedItem(vo.getDeparture());
		stateBox.setSelectedItem(vo.getArrivalstate().getName());
		codeField.setText(vo.getTranscode());
		
		update.setEnabled(vo.getFormstate() == Formstate.waiting || vo.getFormstate() == Formstate.fail);
	}
	
	private boolean checkFormat(){
		CheckForExistBlService check2 = new CheckForExistBl();
		if(typeBox.getSelectedIndex() == 1){
			if(!check2.checkHallLoad(codeField.getText()))
				return createTip("汽运编号:" + codeField.getText() + " 不存在！");
		}else if(typeBox.getSelectedIndex() == 0){
			if(!check2.checkTrans(codeField.getText()))
				return createTip("中转单编号:" + codeField.getText() + " 不存在！");
		}
		return true;
	}
	
	
	private boolean createTip(String str){
		TipDialog tipDialog=new TipDialog(str);
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);	
		return false;
	}
}
