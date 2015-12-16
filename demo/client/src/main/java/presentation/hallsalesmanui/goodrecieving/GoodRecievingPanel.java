package presentation.hallsalesmanui.goodrecieving;

import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import po.Arrivalstate;
import po.Formstate;
import po.Organizationtype;
import presentation.enums.OrganizationType;
import presentation.tip.TipDialog;
import vo.CityVO;
import vo.GoodsReceivingVO;
import vo.OrganizationVO;
import businesslogic.logisticsbl.GoodsRecevingPack.GoodsRecevingController;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.logisticsblservice.GoodsRecevingBlService;
import businesslogicservice.managerblservice.ConstantsBlService;
import businesslogicservice.managerblservice.OrganizationBlService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JLabel;

public class GoodRecievingPanel extends JPanel {
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JComboBox<String> destinBox;
	private JComboBox<String> stateBox;
	private JButton button;
	private GoodsRecevingBlService goodsRecevingBlService;
	private JTextField codeField;
	private String city;
	private JComboBox<String> typeBox;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;

	/**
	 * Create the panel.
	 */
	public GoodRecievingPanel(String orgCode, String city) {
		this.city = city;
		goodsRecevingBlService = new GoodsRecevingController();
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		codeField = new JTextField();
		codeField.setBounds(140, 230, 242, 24);
		add(codeField);
		codeField.setColumns(10);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(140, 67, 74, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(238, 67, 61, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(321, 67, 61, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		destinBox = new JComboBox<String>();
		destinBox.setBounds(518, 67, 242, 24);
		add(destinBox);
		addOrganizationItems(destinBox);

		stateBox = new JComboBox<String>();
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

		typeBox = new JComboBox<String>();
		typeBox.setBounds(140, 149, 242, 24);
		add(typeBox);
		addTypeItems();

		button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				goodsRecevingBlService.GoodsReceving(new GoodsReceivingVO(
						goodsRecevingBlService.getid(orgCode), date,typeBox.getSelectedIndex() == 1 ,codeField
								.getText(), (String) destinBox
								.getSelectedItem(),
						getStateType((String) stateBox.getSelectedItem()),
						Formstate.waiting));
				TipDialog Dialog=new TipDialog("收件单提交成功！");
				Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				Dialog.setVisible(true);
			}
		});
		button.setBounds(423, 336, 113, 27);
		add(button);
		
		label = new JLabel("入库日期：");
		label.setBounds(54, 70, 86, 18);
		add(label);
		
		label_1 = new JLabel("单据类型：");
		label_1.setBounds(54, 149, 82, 18);
		add(label_1);
		
		label_2 = new JLabel("单据编号：");
		label_2.setBounds(54, 227, 82, 18);
		add(label_2);
		
		label_3 = new JLabel("目的地：");
		label_3.setBounds(448, 70, 71, 18);
		add(label_3);
		
		label_4 = new JLabel("到达状态：");
		label_4.setBounds(433, 152, 86, 18);
		add(label_4);
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

}
