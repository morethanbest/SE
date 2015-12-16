package presentation.centersalesmanui.arrivalui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JLabel;

import po.Arrivalstate;
import po.Formstate;
import po.Organizationtype;
import presentation.centersalesmanui.CenterSalesmanPanel;
import presentation.managerui.examui.ExamPanel;
import vo.ArrivalVO;
import vo.OrganizationVO;
import businesslogic.logisticsbl.ArrivalPack.ArrivalController;
import businesslogic.managerbl.ExamPack.ExamController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.logisticsblservice.ArrivalBlService;
import businesslogicservice.managerblservice.ExamArrivals;
import businesslogicservice.managerblservice.OrganizationBlService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArrivalUpdatePanel extends JPanel {
	private JTextField codeField;
	private JLabel orgLabel;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JButton update;
	private JComboBox<String> departureBox;
	private JComboBox<String> stateBox;
	private ArrivalBlService controller;
	private JComboBox<String> typeBox;
	private JButton button_1;
	private JButton button_2;
	private ArrivalVO vo;

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

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(139, 132, 74, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(237, 132, 61, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(320, 132, 61, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		stateBox = new JComboBox<String>();
		stateBox.setBounds(547, 131, 242, 24);
		add(stateBox);
		addStateTypeItems();

		update = new JButton("提交修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				if(typeBox.getSelectedIndex() == 1)
					controller.updateFromHall(new ArrivalVO(vo.getId(), orgLabel.getText(), date,
							typeBox.getSelectedIndex() == 1 ,codeField.getText(),
							(String) departureBox.getSelectedItem(),
							getStateType((String) stateBox.getSelectedItem()),
							vo.getFormstate()), orgName);
				else
					controller.updateFromCenter(new ArrivalVO(vo.getId(), orgLabel.getText(), date,
							typeBox.getSelectedIndex() == 1 ,codeField.getText(),
							(String) departureBox.getSelectedItem(),
							getStateType((String) stateBox.getSelectedItem()),
							vo.getFormstate()), orgName);
			}
		});
		update.setBounds(444, 333, 122, 36);
		add(update);

		codeField = new JTextField();
		codeField.setColumns(10);
		codeField.setBounds(547, 213, 242, 24);
		add(codeField);

		departureBox = new JComboBox<String>();
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

		typeBox = new JComboBox<String>();
		typeBox.setBounds(139, 213, 242, 24);
		add(typeBox);
		
		button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent.getSwitcher());
				parent.getArrival().refreshList();
			}
		});
		button_1.setBounds(716, 333, 122, 36);
		add(button_1);
		
		button_2 = new JButton("恢复原值");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(vo);
			}
		});
		button_2.setBounds(580, 333, 122, 36);
		add(button_2);
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
}
