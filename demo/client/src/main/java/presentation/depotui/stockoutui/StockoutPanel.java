package presentation.depotui.stockoutui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import po.Formstate;
import po.Organizationtype;
import presentation.enums.TransportTypes;
import vo.OrganizationVO;
import vo.StockoutVO;
import businesslogic.commoditybl.StockoutPack.StockoutController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.commodityblservice.StockoutBlService;
import businesslogicservice.managerblservice.OrganizationBlService;

import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockoutPanel extends JPanel {
	private JTextField orderField;
	private JTextField codeField;
	private JComboBox<String> typeBox;
	private JComboBox<String> orgBox;
	private JComboBox<String> transportBox;
	private JComboBox<Long> yearBox;
	private String city;
	private JComboBox<Long> dateBox;
	private JComboBox<Long> monthBox;
	private JButton button;
	private StockoutBlService stockoutBlService;

	/**
	 * Create the panel.
	 */
	public StockoutPanel(String orgCode, String city) {
		this.city = city;
		stockoutBlService = new StockoutController();
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		orderField = new JTextField();
		orderField.setColumns(10);
		orderField.setBounds(141, 35, 220, 24);
		add(orderField);

		yearBox = new JComboBox<Long>();
		yearBox.setBounds(555, 35, 78, 24);
		add(yearBox);

		monthBox = new JComboBox<Long>();
		monthBox.setBounds(641, 35, 65, 24);
		add(monthBox);

		addYearItems(yearBox, monthBox);

		dateBox = new JComboBox<Long>();
		dateBox.setBounds(710, 35, 65, 24);
		add(dateBox);

		addDateItems(yearBox, monthBox, dateBox);

		typeBox = new JComboBox<String>();
		typeBox.setBounds(141, 106, 220, 24);
		add(typeBox);
		typeBox.addItem("运往市内");
		typeBox.addItem("运往市外");

		transportBox = new JComboBox<String>();
		transportBox.setBounds(555, 106, 220, 24);
		add(transportBox);
		addTransportTypeItems();

		codeField = new JTextField();
		codeField.setColumns(10);
		codeField.setBounds(555, 181, 220, 24);
		add(codeField);

		orgBox = new JComboBox<String>();
		orgBox.setBounds(141, 181, 220, 24);
		add(orgBox);
		addOrganizationItems(orgBox);

		button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			Long date = (Long) yearBox.getSelectedItem() * 10000
					+ (Long) monthBox.getSelectedItem() * 100
					+ (Long) dateBox.getSelectedItem();

			public void actionPerformed(ActionEvent e) {
				stockoutBlService.Stockout(new StockoutVO(stockoutBlService
						.getid(orgCode), orderField.getText(), date,
						(String) orgBox.getSelectedItem(),
						(String) transportBox.getSelectedItem(), codeField
								.getText(), Formstate.waiting));
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
		if (typeBox.getSelectedIndex() == 0) {
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
}
