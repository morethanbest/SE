package presentation.courierui;

import java.awt.CardLayout;
import java.awt.Color;
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
import po.Ordertype;
import presentation.enums.OrderTypes;
import presentation.enums.PackageTypes;
import vo.CityVO;
import vo.OrderVO;
import vo.OrganizationVO;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogic.orderbl.OrderPack.OrderController;
import businesslogicservice.managerblservice.ConstantsBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import businesslogicservice.orderblservice.OrderBlService;

public class OrderUpdatePanel extends JPanel {
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
	private JButton update;
	private JSeparator separator_4;
	private JComboBox<String> scityBox;
	private JComboBox<String> sareaBox;
	private JComboBox<String> rcityBox;
	private JComboBox<String> rareaBox;
	private JComboBox<String> orderBox;
	private JTextField rjobField;
//换成exam开头的方法
	private OrderBlService controller;
	private JButton back;
	private JLabel orderCode;
	private OrderVO temp;

	/**
	 * Create the panel.
	 * 
	 */
//这里换参数
	public OrderUpdatePanel(CourierPanel parent, CardLayout card) {
		setBackground(new Color(244, 247, 252));
		controller = new OrderController();
		setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(98, 43, 2, 466);
		add(separator);

		JLabel label = new JLabel("寄件人信息");
		label.setBounds(0, 54, 75, 18);
		add(label);

		snameField = new JTextField();
		snameField.setText("奥巴马");
		snameField.setBounds(151, 51, 96, 24);
		add(snameField);
		snameField.setColumns(10);

		scityBox = new JComboBox<String>();
		scityBox.setBounds(305, 51, 86, 24);
		add(scityBox);
		addCityItems(scityBox);

		sareaBox = new JComboBox<String>();
		sareaBox.setBounds(449, 51, 86, 24);
		add(sareaBox);
		addOrganizationItems(scityBox, sareaBox);

		sdetailField = new JTextField();
		sdetailField.setText("白宫");
		sdetailField.setBounds(599, 51, 270, 24);
		add(sdetailField);
		sdetailField.setColumns(10);

		sjobField = new JTextField();
		sjobField.setText("美国总统");
		sjobField.setBounds(151, 105, 226, 24);
		add(sjobField);
		sjobField.setColumns(10);

		stelField = new JTextField();
		stelField.setText("911");
		stelField.setBounds(458, 105, 159, 24);
		add(stelField);
		stelField.setColumns(10);

		sphoneField = new JTextField();
		sphoneField.setText("911");
		sphoneField.setBounds(710, 105, 196, 24);
		add(sphoneField);
		sphoneField.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(114, 142, 831, 2);
		add(separator_1);

		JLabel label_1 = new JLabel("收件人信息");
		label_1.setBounds(0, 191, 75, 18);
		add(label_1);

		rnameField = new JTextField();
		rnameField.setText("习近平");
		rnameField.setColumns(10);
		rnameField.setBounds(151, 157, 96, 24);
		add(rnameField);

		rcityBox = new JComboBox<String>();
		rcityBox.setBounds(305, 157, 86, 24);
		add(rcityBox);
		addCityItems(rcityBox);

		rareaBox = new JComboBox<String>();
		rareaBox.setBounds(449, 157, 86, 24);
		add(rareaBox);
		addOrganizationItems(rcityBox, rareaBox);

		rdetailField = new JTextField();
		rdetailField.setText("中南海");
		rdetailField.setColumns(10);
		rdetailField.setBounds(599, 157, 270, 24);
		add(rdetailField);

		rjobField = new JTextField();
		rjobField.setText("中国主席");
		rjobField.setColumns(10);
		rjobField.setBounds(150, 207, 226, 24);
		add(rjobField);

		rtelField = new JTextField();
		rtelField.setText("110");
		rtelField.setColumns(10);
		rtelField.setBounds(458, 208, 159, 24);
		add(rtelField);

		rphoneField = new JTextField();
		rphoneField.setText("110");
		rphoneField.setColumns(10);
		rphoneField.setBounds(710, 207, 196, 24);
		add(rphoneField);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(125, 244, 820, 2);
		add(separator_2);

		numberField = new JTextField();
		numberField.setText("1");
		numberField.setBounds(151, 259, 86, 24);
		add(numberField);
		numberField.setColumns(10);

		weightField = new JTextField();
		weightField.setText("1");
		weightField.setBounds(333, 259, 86, 24);
		add(weightField);
		weightField.setColumns(10);

		volumeField = new JTextField();
		volumeField.setText("1");
		volumeField.setBounds(532, 259, 86, 24);
		add(volumeField);
		volumeField.setColumns(10);

		nameField = new JTextField();
		nameField.setText("核弹");
		nameField.setBounds(711, 259, 196, 24);
		add(nameField);
		nameField.setColumns(10);

		packBox = new JComboBox<String>();
		packBox.setBounds(151, 315, 159, 24);
		add(packBox);
		addPackTypeItems();

		orderBox = new JComboBox<String>();
		orderBox.setBounds(459, 315, 159, 24);
		add(orderBox);
		addOrderTypeItems();

		label_2 = new JLabel("托运货物信息");
		label_2.setBounds(0, 262, 96, 18);
		add(label_2);

		separator_3 = new JSeparator();
		separator_3.setBounds(125, 352, 820, 2);
		add(separator_3);

		fareField = new JTextField();
		fareField.setText("0");
		fareField.setBounds(571, 0, 68, 24);
		add(fareField);
		fareField.setColumns(10);
//所有运费删掉

		update = new JButton("提交修改");
		update.addActionListener(new ActionListener() {
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
//原本的添加单据要删掉
					controller.updateLogistics(
							new OrderVO(snameField.getText(), saddress,
									sjobField.getText(), stelField.getText(),
									sphoneField.getText(),
									rnameField.getText(), raddress, rjobField
											.getText(), rtelField.getText(),
									rphoneField.getText(), number, weight,
									volume, nameField.getText(),
									(String) packBox.getSelectedItem(),
									orderCode.getText(),
									getOrderType((String) orderBox
											.getSelectedItem()), fare, temp.getFormstate()));
				} catch (NumberFormatException e1) {
					System.out.println("wronginput");
				}

			}
		});
		update.setBounds(434, 362, 133, 36);
		add(update);

		separator_4 = new JSeparator();
		separator_4.setBounds(0, 31, 954, 1);
		add(separator_4);

		orderCode = new JLabel("");
		orderCode.setBounds(98, 0, 314, 18);
		add(orderCode);
		
		back = new JButton("返回");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.switchPanel("orderc");
				parent.getOrderc().refreshList();
			}
		});
		back.setBounds(717, 362, 122, 36);
		add(back);
		
		JButton undo = new JButton("恢复原值");
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(temp);
			}
		});
		undo.setBounds(581, 362, 122, 36);
		add(undo);

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

	
	public void init(OrderVO vo){
		this.temp = vo;
		orderCode.setText(vo.getOrdercode());
		fareField.setText(vo.getTotalfee() + "");
		
		snameField.setText(vo.getSendername());
		String[] saddress = vo.getSenderaddress().split("-");
		scityBox.setSelectedItem(saddress[0]);
		sareaBox.setSelectedItem(saddress[1]);
		sdetailField.setText(saddress[2]);
		sjobField.setText(vo.getSenderunit());
		stelField.setText(vo.getSenderphone());
		sphoneField.setText(vo.getSendercellphone());
		
		rnameField.setText(vo.getReceivername());
		String[] raddress = vo.getReceiveraddress().split("-");
		rcityBox.setSelectedItem(raddress[0]);
		rareaBox.setSelectedItem(raddress[1]);
		rdetailField.setText(raddress[2]);
		rjobField.setText(vo.getReceiverunit());
		rtelField.setText(vo.getReceiverphone());
		rphoneField.setText(vo.getReceivercellphone());
		
		numberField.setText(vo.getNumbers() + "");
		weightField.setText(vo.getWeight() + "");
		volumeField.setText(vo.getVolume() + "");
		nameField.setText(vo.getProductname());
		packBox.setSelectedItem(vo.getPackagetype());
		orderBox.setSelectedItem(vo.getOrdertype().getName());
		
		update.setEnabled(vo.getFormstate() == Formstate.waiting || vo.getFormstate() == Formstate.fail);
	}
}
