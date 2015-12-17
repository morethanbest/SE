package presentation.courierui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogic.orderbl.OrderPack.OrderController;
import businesslogicservice.managerblservice.ConstantsBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import businesslogicservice.orderblservice.OrderBlService;
import init.ClientInitException;
import init.RMIHelper;
import po.Formstate;
import po.Ordertype;
import presentation.enums.OrderTypes;
import presentation.enums.PackageTypes;
import presentation.mainui.MainFrame;
import presentation.tip.DoubleField;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.CityVO;
import vo.OrderFareVO;
import vo.OrderVO;
import vo.OrganizationVO;

public class OrderPanel extends JPanel {
	private JTextField snameField;
	private JTextField sdetailField;
	private JTextField sjobField;
	private JTextField stelField;
	private NumberField sphoneField;
	private JTextField rnameField;
	private JTextField rdetailField;
	private JTextField rjobField;
	private JTextField rtelField;
	private NumberField rphoneField;
	private JComboBox<String> packBox;
	private DoubleField numberField;
	private DoubleField weightField;
	private DoubleField volumeField;
	private JTextField nameField;
	private JLabel label_2;
	private JSeparator separator_3;
	private DoubleField fareField;
	private JButton button;
	private JButton button_2;
	private JButton btnNewButton;
	private JSeparator separator_4;
	private JComboBox<String> scityBox;
	private JComboBox<String> sareaBox;
	private JComboBox<String> rcityBox;
	private JComboBox<String> rareaBox;
	private JComboBox<String> orderBox;
	private OrderBlService orderBlService;
	private JLabel label_17;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JButton button_1;
	private JButton button_3;

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
		snameField.setBounds(158, 85, 96, 24);
		add(snameField);
		snameField.setColumns(10);

		scityBox = new JComboBox<String>();
		scityBox.setBounds(319, 85, 86, 24);
		add(scityBox);
		addCityItems(scityBox);

		sareaBox = new JComboBox<String>();
		sareaBox.setBounds(466, 85, 143, 24);
		add(sareaBox);
		addOrganizationItems(scityBox, sareaBox);

		sdetailField = new JTextField();
		sdetailField.setText("白宫");
		sdetailField.setBounds(712, 85, 256, 24);
		add(sdetailField);
		sdetailField.setColumns(10);

		sjobField = new JTextField();
		sjobField.setText("美国总统");
		sjobField.setBounds(158, 148, 247, 24);
		add(sjobField);
		sjobField.setColumns(10);

		stelField = new NumberField(50);
		stelField.setText("911");
		stelField.setBounds(466, 148, 159, 24);
		add(stelField);
		stelField.setColumns(10);

		sphoneField = new NumberField(50);
		sphoneField.setText("911");
		sphoneField.setBounds(712, 148, 194, 24);
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
		rnameField.setBounds(158, 225, 96, 24);
		add(rnameField);

		rcityBox = new JComboBox<String>();
		rcityBox.setBounds(319, 225, 86, 24);
		add(rcityBox);
		addCityItems(rcityBox);

		rareaBox = new JComboBox<String>();
		rareaBox.setBounds(466, 225, 143, 24);
		add(rareaBox);
		addOrganizationItems(rcityBox, rareaBox);

		rdetailField = new JTextField();
		rdetailField.setText("中南海");
		rdetailField.setColumns(10);
		rdetailField.setBounds(712, 225, 256, 24);
		add(rdetailField);

		rjobField = new JTextField();
		rjobField.setText("中国主席");
		rjobField.setColumns(10);
		rjobField.setBounds(158, 287, 247, 24);
		add(rjobField);

		rtelField = new NumberField(50);
		rtelField.setText("110");
		rtelField.setColumns(10);
		rtelField.setBounds(466, 287, 159, 24);
		add(rtelField);

		rphoneField = new NumberField(50);
		rphoneField.setText("110");
		rphoneField.setColumns(10);
		rphoneField.setBounds(712, 287, 194, 24);
		add(rphoneField);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(114, 336, 854, 2);
		add(separator_2);

		numberField = new DoubleField(50);
		numberField.setText("1");
		numberField.setBounds(189, 361, 86, 24);
		add(numberField);
		numberField.setColumns(10);

		weightField = new DoubleField(50);
		weightField.setText("1");
		weightField.setBounds(360, 361, 86, 24);
		add(weightField);
		weightField.setColumns(10);

		volumeField = new DoubleField(50);
		volumeField.setText("1");
		volumeField.setBounds(536, 361, 86, 24);
		add(volumeField);
		volumeField.setColumns(10);

		nameField = new JTextField();
		nameField.setText("核弹");
		nameField.setBounds(725, 361, 203, 24);
		add(nameField);
		nameField.setColumns(10);

		packBox = new JComboBox<String>();
		packBox.setBounds(198, 417, 172, 24);
		add(packBox);
		addPackTypeItems();

		orderBox = new JComboBox<String>();
		orderBox.setBounds(480, 417, 172, 24);
		add(orderBox);
		addOrderTypeItems();

		label_2 = new JLabel("托运货物信息");
		label_2.setBounds(4, 364, 96, 18);
		add(label_2);

		separator_3 = new JSeparator();
		separator_3.setBounds(114, 463, 854, 2);
		add(separator_3);

		fareField = new DoubleField(50);
		fareField.setText("0");
		fareField.setBounds(750, 418, 68, 24);
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
		button.setBounds(832, 417, 96, 27);
		add(button);

		button_2 = new JButton("提交订单");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 添加订单
				try {
					if(!checkFormat())
						return;
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
					addSuccessfully();
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
		btnNewButton.setBounds(647, 10, 145, 42);
		add(btnNewButton);

		separator_4 = new JSeparator();
		separator_4.setBounds(14, 68, 954, 1);
		add(separator_4);
		
		JLabel label_3 = new JLabel("姓名：");
		label_3.setBounds(114, 88, 58, 18);
		add(label_3);
		
		JLabel label_4 = new JLabel("姓名：");
		label_4.setBounds(114, 228, 58, 18);
		add(label_4);
		
		JLabel label_5 = new JLabel("城市：");
		label_5.setBounds(268, 88, 52, 18);
		add(label_5);
		
		JLabel label_6 = new JLabel("城市：");
		label_6.setBounds(268, 228, 52, 18);
		add(label_6);
		
		JLabel label_7 = new JLabel("地区：");
		label_7.setBounds(419, 88, 52, 18);
		add(label_7);
		
		JLabel label_8 = new JLabel("地区：");
		label_8.setBounds(419, 228, 52, 18);
		add(label_8);
		
		JLabel label_9 = new JLabel("具体地址：");
		label_9.setBounds(623, 88, 75, 18);
		add(label_9);
		
		JLabel label_10 = new JLabel("具体地址：");
		label_10.setBounds(623, 228, 75, 18);
		add(label_10);
		
		JLabel label_11 = new JLabel("单位：");
		label_11.setBounds(114, 151, 58, 18);
		add(label_11);
		
		JLabel label_12 = new JLabel("单位：");
		label_12.setBounds(114, 289, 58, 18);
		add(label_12);
		
		JLabel label_13 = new JLabel("电话：");
		label_13.setBounds(419, 151, 54, 18);
		add(label_13);
		
		JLabel label_14 = new JLabel("电话：");
		label_14.setBounds(419, 290, 54, 18);
		add(label_14);
		
		JLabel label_15 = new JLabel("手机：");
		label_15.setBounds(647, 151, 52, 18);
		add(label_15);
		
		JLabel label_16 = new JLabel("手机：");
		label_16.setBounds(647, 290, 53, 18);
		add(label_16);
		
		label_17 = new JLabel("原件数：");
		label_17.setBounds(113, 364, 72, 18);
		add(label_17);
		
		label_18 = new JLabel("重量：");
		label_18.setBounds(296, 364, 58, 18);
		add(label_18);
		
		label_19 = new JLabel("体积：");
		label_19.setBounds(481, 364, 58, 18);
		add(label_19);
		
		label_20 = new JLabel("货物名称：");
		label_20.setBounds(636, 364, 75, 18);
		add(label_20);
		
		label_21 = new JLabel("运费：");
		label_21.setBounds(678, 420, 58, 18);
		add(label_21);
		
		label_22 = new JLabel("订单类型：");
		label_22.setBounds(389, 420, 82, 18);
		add(label_22);
		
		label_23 = new JLabel("包装类型：");
		label_23.setBounds(112, 420, 86, 18);
		add(label_23);
		
		button_1 = new JButton("查看已提交订单");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(793, 511, 143, 27);
		add(button_1);
		
		button_3 = new JButton("注销");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			           RMIHelper.init();
			           MainFrame frame= new MainFrame();
			           frame.start();
			        } catch (ClientInitException e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(
			                    null,
			                    "Client boots fail!\nCause: " + e1.getMessage(),
			                    "Fatal Error",
			                    JOptionPane.ERROR_MESSAGE
			            );
			        }
			}
		});
		button_3.setBounds(816, 10, 145, 42);
		add(button_3);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{snameField, scityBox, sareaBox, sdetailField, sjobField, stelField, sphoneField, rnameField, rcityBox, rareaBox, rdetailField, rjobField, rtelField, rphoneField, numberField, weightField, volumeField, nameField, packBox, orderBox, fareField}));

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
	
	private boolean checkFormat(){
		if(snameField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("寄件人姓名不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(sdetailField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("寄件人具体地址不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(sjobField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("寄件人单位不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(stelField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("寄件人电话不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(sphoneField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("寄件人手机不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(rnameField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("收件人姓名不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(rdetailField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("收件人具体地址不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(rjobField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("收件人单位不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(rtelField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("收件人电话不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(rphoneField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("收件人手机不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(numberField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("原件数不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(weightField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("重量不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(volumeField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("体积不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(nameField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("货物名称不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}else if(fareField.getText().equals("")){
			TipDialog tipDialog=new TipDialog("运费不能为空！");
			tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			tipDialog.setVisible(true);	
			return false;
		}
		return true;
	}
	
	private void addSuccessfully(){
		TipDialog tipDialog=new TipDialog("添加成功！");
		tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		tipDialog.setVisible(true);	
		snameField.setText("");
		sdetailField.setText("");
		sjobField.setText("");
		stelField.setText("");
		sphoneField.setText("");
		rnameField.setText("");
		rdetailField.setText("");
		rjobField.setText("");
		rtelField.setText("");
		rphoneField.setText("");
		numberField.setText("");
		weightField.setText("");
		volumeField.setText("");
		nameField.setText("");
		fareField.setText("");	
	}
	
	private void addPackTypeItems() {
		for (PackageTypes packages : PackageTypes.values()) {
			packBox.addItem(packages.getName());
		}
	}
}
