package presentation.courierui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import vo.CityVO;
import vo.OrderVO;
import vo.OrganizationVO;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogic.orderbl.OrderPack.OrderController;
import businesslogicservice.managerblservice.ConstantsBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import businesslogicservice.orderblservice.OrderBlService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

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

		sdetailField = new JTextField();
		sdetailField.setBounds(620, 85, 270, 24);
		add(sdetailField);
		sdetailField.setColumns(10);

		sjobField = new JTextField();
		sjobField.setBounds(172, 148, 226, 24);
		add(sjobField);
		sjobField.setColumns(10);

		stelField = new JTextField();
		stelField.setBounds(480, 148, 159, 24);
		add(stelField);
		stelField.setColumns(10);

		sphoneField = new JTextField();
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
		rdetailField.setColumns(10);
		rdetailField.setBounds(620, 225, 270, 24);
		add(rdetailField);

		rjobField = new JTextField();
		rjobField.setColumns(10);
		rjobField.setBounds(172, 286, 226, 24);
		add(rjobField);

		rtelField = new JTextField();
		rtelField.setColumns(10);
		rtelField.setBounds(480, 287, 159, 24);
		add(rtelField);

		rphoneField = new JTextField();
		rphoneField.setColumns(10);
		rphoneField.setBounds(732, 286, 196, 24);
		add(rphoneField);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(114, 336, 854, 2);
		add(separator_2);

		numberField = new JTextField();
		numberField.setBounds(172, 361, 86, 24);
		add(numberField);
		numberField.setColumns(10);

		weightField = new JTextField();
		weightField.setBounds(354, 361, 86, 24);
		add(weightField);
		weightField.setColumns(10);

		volumeField = new JTextField();
		volumeField.setBounds(553, 361, 86, 24);
		add(volumeField);
		volumeField.setColumns(10);

		nameField = new JTextField();
		nameField.setBounds(732, 361, 196, 24);
		add(nameField);
		nameField.setColumns(10);

		packBox = new JComboBox<String>();
		packBox.setBounds(174, 417, 159, 24);
		add(packBox);

		orderBox = new JComboBox<String>();
		orderBox.setBounds(480, 417, 159, 24);
		add(orderBox);

		label_2 = new JLabel("托运货物信息");
		label_2.setBounds(4, 364, 96, 18);
		add(label_2);

		separator_3 = new JSeparator();
		separator_3.setBounds(114, 463, 854, 2);
		add(separator_3);

		fareField = new JTextField();
		fareField.setText("0");
		fareField.setBounds(199, 494, 86, 24);
		add(fareField);
		fareField.setColumns(10);

		button = new JButton("获取运费");
		button.setBounds(299, 493, 113, 27);
		add(button);

		button_2 = new JButton("提交订单");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String saddress;
					String raddress = (String) rcityBox.getSelectedItem();
					raddress = raddress.concat("-").concat((String) rareaBox.getSelectedItem());
					raddress = raddress.concat("-").concat(rdetailField.getText());
					double number = Double.parseDouble(numberField.getText());
					double weight = Double.parseDouble(weightField.getText());
					double volume = Double.parseDouble(volumeField.getText());
					orderBlService.addOrder(new OrderVO(snameField.getText(),
							saddress, sjobField.getText(), stelField.getText(),
							sphoneField.getText(), rnameField.getText(),
							raddress, rjobField.getText(), rtelField
									.getText(), rphoneField.getText(), number,
							weight, volume, nameField.getText(), packagefee,
							orderBlService.getOrdercode(), ordertype));
				} catch (NumberFormatException e1) {

				}
			}
		});
		button_2.setBounds(770, 483, 168, 47);
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

	}
	
	public void addCityItems(JComboBox<String> citySelect) {
		citySelect.removeAllItems();
		ConstantsBlService constantsBlService = new ConstantsController();
		List<CityVO> cityList = constantsBlService.getAllCity();
		for (CityVO city : cityList) {
			citySelect.addItem(city.getName());
		}
	}
	
	public void addOrganizationItems(JComboBox<String> citySelect, JComboBox<String> orgSelect){
		orgSelect.removeAllItems();
		OrganizationBlService organizationBlService = new OrganizationController();
		List<OrganizationVO> orgList;
		orgList = organizationBlService.getOrganizationbyCity((String) citySelect.getSelectedItem());
		for(OrganizationVO org : orgList){
			orgSelect.addItem(org.getName());
		}
	}
}
