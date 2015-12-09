package presentation.courierui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import po.Formstate;
import po.Job;
import po.Ordertype;
import presentation.enums.OrderTypes;
import presentation.enums.PackageTypes;
import presentation.enums.StaffType;
import vo.CityVO;
import vo.OrderFareVO;
import vo.OrderVO;
import vo.OrganizationVO;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogic.orderbl.OrderPack.OrderController;
import businesslogicservice.managerblservice.ConstantsBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import businesslogicservice.orderblservice.OrderBlService;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.SystemColor;

public class OrderPanel extends JPanel {
	private JTextField snameField;
	private JTextField sdetailField;
	private JTextField sjobField;
	private JTextField stelField;
	private JTextField sphoneField;
	private JTextField rnameField;
	private JTextField rdetailField;
	private JTextField rtelField;
	private JTextField rphoneField;
	private JComboBox<String> packBox;
	private JTextField numberField;
	private JTextField weightField;
	private JTextField volumeField;
	private JTextField nameField;
	private JLabel label_2;
	private JSeparator separator_3;
	private JTextField fareField;
	private JButton button;
	private JButton button_2;
	private JButton btnNewButton;
	private JSeparator separator_4;
	private JComboBox<String> scityBox;
	private JComboBox<String> sareaBox;
	private JComboBox<String> rcityBox;
	private JComboBox<String> rareaBox;
	private JComboBox<String> orderBox;
	private JTextField rjobField;
	private OrderBlService orderBlService;

	/**
	 * Create the panel.
	 * 
	 * @param courierPanel
	 */
	public OrderPanel(CourierPanel courierPanel) {
		setBackground(new Color(244, 247, 252));
		orderBlService = new OrderController();
		setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(98, 74, 2, 466);
		add(separator);

		JLabel label = new JLabel("寄件人信息");
		label.setBounds(14, 88, 75, 18);
		add(label);

		snameField = new JTextField();
		snameField.setText("奥巴马");
		snameField.setBounds(172, 85, 96, 24);
		add(snameField);
		snameField.setColumns(10);

		scityBox = new JComboBox<String>();
		scityBox.setBounds(326, 85, 86, 24);
		add(scityBox);
		addCityItems(scityBox);

		sareaBox = new JComboBox<String>();
		sareaBox.setBounds(470, 85, 86, 24);
		add(sareaBox);
		addOrganizationItems(scityBox, sareaBox);

		sdetailField = new JTextField();
		sdetailField.setText("白宫");
		sdetailField.setBounds(620, 85, 270, 24);
		add(sdetailField);
		sdetailField.setColumns(10);

		sjobField = new JTextField();
		sjobField.setText("美国总统");
		sjobField.setBounds(172, 148, 226, 24);
		add(sjobField);
		sjobField.setColumns(10);

		stelField = new JTextField();
		stelField.setText("911");
		stelField.setBounds(480, 148, 159, 24);
		add(stelField);
		stelField.setColumns(10);

		sphoneField = new JTextField();
		sphoneField.setText("911");
		sphoneField.setBounds(732, 148, 196, 24);
		add(sphoneField);
		sphoneField.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(114, 191, 854, 2);
		add(separator_1);

		JLabel label_1 = new JLabel("收件人信息");
		label_1.setBounds(14, 228, 75, 18);
		add(label_1);

		rnameField = new JTextField();
		rnameField.setText("习近平");
		rnameField.setColumns(10);
		rnameField.setBounds(172, 225, 96, 24);
		add(rnameField);

		rcityBox = new JComboBox<String>();
		rcityBox.setBounds(326, 225, 86, 24);
		add(rcityBox);
		addCityItems(rcityBox);

		rareaBox = new JComboBox<String>();
		rareaBox.setBounds(470, 225, 86, 24);
		add(rareaBox);
		addOrganizationItems(rcityBox, rareaBox);

		rdetailField = new JTextField();
		rdetailField.setText("中南海");
		rdetailField.setColumns(10);
		rdetailField.setBounds(620, 225, 270, 24);
		add(rdetailField);

		rjobField = new JTextField();
		rjobField.setText("中国主席");
		rjobField.setColumns(10);
		rjobField.setBounds(172, 286, 226, 24);
		add(rjobField);

		rtelField = new JTextField();
		rtelField.setText("110");
		rtelField.setColumns(10);
		rtelField.setBounds(480, 287, 159, 24);
		add(rtelField);

		rphoneField = new JTextField();
		rphoneField.setText("110");
		rphoneField.setColumns(10);
		rphoneField.setBounds(732, 286, 196, 24);
		add(rphoneField);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(114, 336, 854, 2);
		add(separator_2);

		numberField = new JTextField();
		numberField.setText("1");
		numberField.setBounds(172, 361, 86, 24);
		add(numberField);
		numberField.setColumns(10);

		weightField = new JTextField();
		weightField.setText("1");
		weightField.setBounds(354, 361, 86, 24);
		add(weightField);
		weightField.setColumns(10);

		volumeField = new JTextField();
		volumeField.setText("1");
		volumeField.setBounds(553, 361, 86, 24);
		add(volumeField);
		volumeField.setColumns(10);

		nameField = new JTextField();
		nameField.setText("核弹");
		nameField.setBounds(732, 361, 196, 24);
		add(nameField);
		nameField.setColumns(10);

		packBox = new JComboBox<String>();
		packBox.setBounds(172, 417, 159, 24);
		add(packBox);
		addPackTypeItems();

		orderBox = new JComboBox<String>();
		orderBox.setBounds(480, 417, 159, 24);
		add(orderBox);
		addOrderTypeItems();

		label_2 = new JLabel("托运货物信息");
		label_2.setBounds(4, 364, 96, 18);
		add(label_2);

		separator_3 = new JSeparator();
		separator_3.setBounds(114, 463, 854, 2);
		add(separator_3);

		fareField = new JTextField();
		fareField.setText("0");
		fareField.setBounds(172, 500, 68, 24);
		add(fareField);
		fareField.setColumns(10);

		button = new JButton("获取运费");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String saddress = (String) scityBox.getSelectedItem();
				String raddress = (String) rcityBox.getSelectedItem();
				double number = Double.parseDouble(numberField.getText());
				double weight = Double.parseDouble(weightField.getText());
				double volume = Double.parseDouble(volumeField.getText());
				double fare = orderBlService.orderFare(new OrderFareVO(saddress, raddress,
						number, weight, volume, (String) packBox
								.getSelectedItem(),
						getOrderType((String) orderBox.getSelectedItem())));
				fareField.setText(fare + "");

			}
		});
		button.setBounds(254, 499, 86, 27);
		add(button);

		button_2 = new JButton("提交订单");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 添加订单
				try {
					String saddress = (String) scityBox.getSelectedItem();
					saddress = saddress.concat("-").concat(
							(String) sareaBox.getSelectedItem());
					saddress = saddress.concat("-").concat(
							sdetailField.getText());
					String raddress = (String) rcityBox.getSelectedItem();
					raddress = raddress.concat("-").concat(
							(String) rareaBox.getSelectedItem());
					raddress = raddress.concat("-").concat(
							rdetailField.getText());
					double number = Double.parseDouble(numberField.getText());
					double weight = Double.parseDouble(weightField.getText());
					double volume = Double.parseDouble(volumeField.getText());
					double fare = Double.parseDouble(fareField.getText());
					orderBlService.addOrder(
							new OrderVO(snameField.getText(), saddress,
									sjobField.getText(), stelField.getText(),
									sphoneField.getText(),
									rnameField.getText(), raddress, rjobField
											.getText(), rtelField.getText(),
									rphoneField.getText(), number, weight,
									volume, nameField.getText(),
									(String) packBox.getSelectedItem(),
									orderBlService.getOrdercode(courierPanel
											.getOrgCode()),
									getOrderType((String) orderBox
											.getSelectedItem()), fare, Formstate.waiting),
							courierPanel.getOrgCode());
					// System.out.println(orderBlService.getOrdercode(courierPanel.getOrgCode()));
				} catch (NumberFormatException e1) {
					System.out.println("wronginput");
				}

			}
		});
		button_2.setBounds(434, 489, 133, 47);
		add(button_2);

		btnNewButton = new JButton("收件");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courierPanel.switchPanel();
			}
		});
		btnNewButton.setBounds(823, 13, 145, 42);
		add(btnNewButton);

		separator_4 = new JSeparator();
		separator_4.setBounds(14, 68, 954, 1);
		add(separator_4);

		JLabel orderCode = new JLabel("");
		orderCode.setBounds(654, 500, 314, 18);
		add(orderCode);

		rcityBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addOrganizationItems(rcityBox, rareaBox);
			}

		});
		scityBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				addOrganizationItems(scityBox, sareaBox);
			}

		});

	}

	public void addCityItems(JComboBox<String> citySelect) {
		citySelect.removeAllItems();
		ConstantsBlService constantsBlService = new ConstantsController();
		List<CityVO> cityList = constantsBlService.getAllCity();
		for (CityVO city : cityList) {
			citySelect.addItem(city.getName());
		}
	}

	public void addOrganizationItems(JComboBox<String> citySelect,
			JComboBox<String> orgSelect) {
		orgSelect.removeAllItems();
		OrganizationBlService organizationBlService = new OrganizationController();
		List<OrganizationVO> orgList;
		orgList = organizationBlService
				.getOrganizationbyCity((String) citySelect.getSelectedItem());
		for (OrganizationVO org : orgList) {
			orgSelect.addItem(org.getName());
		}
	}

	private void addOrderTypeItems() {
		for (OrderTypes o : OrderTypes.values()) {
			orderBox.addItem(o.getName());
		}
	}

	private Ordertype getOrderType(String str) {
		for (OrderTypes o : OrderTypes.values()) {
			if (o.getName().equals(str)) {
				return o.getOrdertype();
			}
		}

		return null;
	}

	private void addPackTypeItems() {
		for (PackageTypes packages : PackageTypes.values()) {
			packBox.addItem(packages.getName());
		}
	}

	private String getOrderTypeStr(Ordertype o) {
		for (OrderTypes order : OrderTypes.values()) {
			if (order.getOrdertype() == o) {
				return order.getName();
			}
		}

		return null;
	}
}
