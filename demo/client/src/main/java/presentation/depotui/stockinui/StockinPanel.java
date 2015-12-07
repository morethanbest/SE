package presentation.depotui.stockinui;

import javax.swing.JPanel;

import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import po.CommodityLocation;
import po.Formstate;
import po.Organizationtype;
import vo.OrganizationVO;
import vo.StockinVO;
import businesslogic.commoditybl.InboundPack.InboundController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.commodityblservice.InboundBlService;
import businesslogicservice.managerblservice.OrganizationBlService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class StockinPanel extends JPanel {
	private JTextField codeField;
	private JComboBox<String> typeBox;
	private JComboBox<String> orgBox;
	private JButton button;
	private JComboBox<String> quBox;
	private JComboBox<Long> yearBox;
	private JComboBox<Long> monthBox;
	private JComboBox<Long> dateBox;
	private String city;
	private CommodityLocation location;
	private InboundBlService inboundBlService;

	/**
	 * Create the panel.
	 */
	public StockinPanel(String orgCode, String city) {
		inboundBlService = new InboundController();
		this.city = city;
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		codeField = new JTextField();
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
		
		JLabel locationLabel = new JLabel("");
		locationLabel.setBounds(557, 188, 220, 18);
		add(locationLabel);

		typeBox = new JComboBox<String>();
		typeBox.setBounds(143, 106, 220, 24);
		add(typeBox);
		typeBox.addItem("运往市内");
		typeBox.addItem("运往市外");

		orgBox = new JComboBox<String>();
		orgBox.setBounds(143, 185, 220, 24);
		add(orgBox);
		addOrganizationItems(orgBox);

		quBox = new JComboBox<String>();
		quBox.setBounds(557, 106, 220, 24);
		add(quBox);
		quBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				location = inboundBlService.getAvailLoc(orgCode, quBox.getSelectedIndex() + 1);
				locationLabel.setText("货物将被安置在 " + location.getLinenum() + "排 " + location.getShelfnum() + "架 " + location.getLocationnum() + "位");
			}
		});
		quBox.addItem("航运区");
		quBox.addItem("铁运区");
		quBox.addItem("汽运区");
		quBox.addItem("机动区");

		
		button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Long date = (Long) yearBox.getSelectedItem() * 10000
						+ (Long) monthBox.getSelectedItem() * 100
						+ (Long) dateBox.getSelectedItem();
				inboundBlService.Inbound(new StockinVO(inboundBlService.getid(orgCode), codeField.getText(), date, location, (String) orgBox.getSelectedItem(), Formstate.waiting));
			}
		});
		button.setBounds(416, 312, 113, 27);
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
	
	
}
