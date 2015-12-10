package presentation.centersalesmanui.arrivalui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JLabel;

import po.Arrivalstate;
import po.Formstate;
import po.Organizationtype;
import vo.ArrivalVO;
import vo.OrganizationVO;
import businesslogic.logisticsbl.ArrivalPack.ArrivalController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.logisticsblservice.ArrivalBlService;
import businesslogicservice.managerblservice.OrganizationBlService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArrivalPanel extends JPanel {
	private JTextField codeField;
	private JLabel orgLabel;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private JButton button;
	private JComboBox<String> departureBox;
	private JComboBox<String> stateBox;
	private ArrivalBlService arrivalBlService;
	private JComboBox<String> typeBox;

	/**
	 * Create the panel.
	 */
	public ArrivalPanel(String orgCode) {
		arrivalBlService = new ArrivalController();

		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		orgLabel = new JLabel(orgCode);
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

		button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				arrivalBlService.addArrival(new ArrivalVO(arrivalBlService
						.getid(orgCode), orgCode, date,typeBox.getSelectedIndex() == 1 ,codeField.getText(),
						(String) departureBox.getSelectedItem(),
						getStateType((String) stateBox.getSelectedItem()),
						Formstate.waiting));
			}
		});
		button.setBounds(416, 309, 113, 27);
		add(button);

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

		Calendar c = Calendar.getInstance();
		yearBox.setSelectedItem((long) c.get(Calendar.YEAR));
		monthBox.setSelectedItem((long) c.get(Calendar.MONTH) + 1);
		dateBox.setSelectedItem((long) c.get(Calendar.DAY_OF_MONTH));
		
		typeBox = new JComboBox<String>();
		typeBox.setBounds(139, 213, 242, 24);
		add(typeBox);
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
}
