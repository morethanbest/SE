package presentation.courierui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import po.Formstate;
import po.Ordertype;
import po.ResultMessage;
import presentation.enums.OrderTypes;
import presentation.enums.PackageTypes;
import presentation.mainui.MainFrame;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.PersonPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.DoubleField;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
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

public class OrderPanel extends PersonPanel {
	private MyTextField snameField;
	private MyTextField sdetailField;
	private MyTextField sjobField;
	private MyTextField stelField;
	private NumberField sphoneField;
	private MyTextField rnameField;
	private MyTextField rdetailField;
	private MyTextField rjobField;
	private MyTextField rtelField;
	private NumberField rphoneField;
	private MyComboBox<String> packBox;
	private DoubleField numberField;
	private DoubleField weightField;
	private DoubleField volumeField;
	private MyTextField nameField;
	private JSeparator separator_3;
	private DoubleField fareField;
	private MyButton_LightBlue button;
	private MyButton_LightBlue button_2;
	private MyButton_LightBlue btnNewButton;
	private JSeparator separator_4;
	private MyComboBox<String> scityBox;
	private MyComboBox<String> sareaBox;
	private MyComboBox<String> rcityBox;
	private MyComboBox<String> rareaBox;
	private MyComboBox<String> orderBox;
	private OrderBlService orderBlService;
	private MyButton_LightBlue button_1;
	private MyButton_LightBlue button_3;
    /**
	 * Create the panel.
	 * 
	 * @param courierPanel
	 */
	public OrderPanel(CourierPanel courierPanel,MainFrame parent) {
		setBackground(new Color(244, 247, 252));
		setBackground(SystemColor.inactiveCaptionBorder);
		orderBlService = new OrderController();
		setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(98, 74, 2, 466);
		add(separator);

		JLabel label = new JLabel("寄件人信息");
		label.setBounds(14, 88, 75, 18);
		add(label);

		snameField = new MyTextField();
		snameField.setText("张三");
		snameField.setBounds(158, 85, 96, 24);
		add(snameField);
		snameField.setColumns(10);

		scityBox = new MyComboBox<String>();
		scityBox.setBounds(319, 85, 86, 24);
		add(scityBox);
		addCityItems(scityBox);

		sareaBox = new MyComboBox<String>();
		sareaBox.setBounds(466, 85, 143, 24);
		add(sareaBox);
		addOrganizationItems(scityBox, sareaBox);

		sdetailField = new MyTextField();
		sdetailField.setText("泗阳");
		sdetailField.setBounds(712, 85, 256, 24);
		add(sdetailField);
		sdetailField.setColumns(10);

		sjobField = new MyTextField();
		sjobField.setText("个体户");
		sjobField.setBounds(158, 148, 247, 24);
		add(sjobField);
		sjobField.setColumns(10);

		stelField = new NumberField(50);
		stelField.setText("18260038801");
		stelField.setBounds(466, 148, 159, 24);
		add(stelField);
		stelField.setColumns(10);

		sphoneField = new NumberField(50);
		sphoneField.setText("18260038801");
		sphoneField.setBounds(712, 148, 194, 24);
		add(sphoneField);
		sphoneField.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(114, 191, 854, 2);
		add(separator_1);

		JLabel label_1 = new JLabel("收件人信息");
		label_1.setBounds(14, 228, 75, 18);
		add(label_1);

		rnameField = new MyTextField();
		rnameField.setText("李四");
		rnameField.setColumns(10);
		rnameField.setBounds(158, 225, 96, 24);
		add(rnameField);

		rcityBox = new MyComboBox<String>();
		rcityBox.setBounds(319, 225, 86, 24);
		add(rcityBox);
		addCityItems(rcityBox);

		rareaBox = new MyComboBox<String>();
		rareaBox.setBounds(466, 225, 143, 24);
		add(rareaBox);
		addOrganizationItems(rcityBox, rareaBox);

		rdetailField = new MyTextField();
		rdetailField.setText("临河");
		rdetailField.setColumns(10);
		rdetailField.setBounds(712, 225, 256, 24);
		add(rdetailField);

		rjobField = new MyTextField();
		rjobField.setText("教师");
		rjobField.setColumns(10);
		rjobField.setBounds(158, 287, 247, 24);
		add(rjobField);

		rtelField = new NumberField(50);
		rtelField.setText("18017227740");
		rtelField.setColumns(10);
		rtelField.setBounds(466, 287, 159, 24);
		add(rtelField);

		rphoneField = new NumberField(50);
		rphoneField.setText("18017227740");
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

		nameField = new MyTextField();
		nameField.setText("玉米");
		nameField.setBounds(725, 361, 203, 24);
		add(nameField);
		nameField.setColumns(10);

		packBox = new MyComboBox<String>();
		packBox.setBounds(198, 417, 172, 24);
		add(packBox);
		addPackTypeItems();

		orderBox = new MyComboBox<String>();
		orderBox.setBounds(480, 417, 172, 24);
		add(orderBox);
		addOrderTypeItems();

		JLabel label_2 = new JLabel("托运货物信息");
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

		button = new MyButton_LightBlue("获取运费");
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

		button_2 = new MyButton_LightBlue("提交订单");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 添加订单
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
					String code = orderBlService.getOrdercode(courierPanel
							.getOrgCode());
					if(orderBlService.addOrder(
							new OrderVO(snameField.getText(), saddress,
									sjobField.getText(), stelField.getText(),
									sphoneField.getText(),
									rnameField.getText(), raddress, rjobField
											.getText(), rtelField.getText(),
									rphoneField.getText(), number, weight,
									volume, nameField.getText(),
									(String) packBox.getSelectedItem(),
									code,getOrderType((String) orderBox
									.getSelectedItem()), fare, Formstate.waiting),
							courierPanel.getOrgCode()) == ResultMessage.success)
					{
						addSuccessfully(code);
					}else{
						TipDialog tipDialog=new TipDialog("添加失败！");
						tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						tipDialog.setVisible(true);	
					}
					
			}
		});
		button_2.setBounds(319, 478, 151, 47);
		add(button_2);

		btnNewButton = new MyButton_LightBlue("收件");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courierPanel.switchPanel("recieve");
			}
		});
		btnNewButton.setBounds(722, 11, 96, 40);
		btnNewButton.setForeground(SystemColor.windowBorder);
		btnNewButton.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(btnNewButton);
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
		
		JLabel label_17 = new JLabel("原件数：");
		label_17.setBounds(113, 364, 72, 18);
		add(label_17);
		
		JLabel label_18 = new JLabel("重量：");
		label_18.setBounds(296, 364, 58, 18);
		add(label_18);
		
		JLabel label_19 = new JLabel("体积：");
		label_19.setBounds(481, 364, 58, 18);
		add(label_19);
		
		JLabel label_20 = new JLabel("货物名称：");
		label_20.setBounds(636, 364, 75, 18);
		add(label_20);
		
		JLabel label_21 = new JLabel("运费：");
		label_21.setBounds(678, 420, 58, 18);
		add(label_21);
		
		JLabel label_22 = new JLabel("订单类型：");
		label_22.setBounds(389, 420, 82, 18);
		add(label_22);
		
		JLabel label_23 = new JLabel("包装类型：");
		label_23.setBounds(112, 420, 86, 18);
		add(label_23);
		
		button_1 = new MyButton_LightBlue("查看已提交订单");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				courierPanel.switchPanel("orderc");
				courierPanel.getOrderc().refreshList();
			}
		});
		button_1.setBounds(783, 474, 143, 27);
		add(button_1);
		
		button_3 = new MyButton_LightBlue("注销");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.skipToLogin();
			}
		});
		button_3.setBounds(872, 11, 96, 40);
		button_3.setForeground(SystemColor.windowBorder);
		button_3.setFont(new Font("微软雅黑 Light", Font.BOLD, 13));
		button_3.setBackground(SystemColor.inactiveCaptionBorder);
		setNoneBorder(button_3);
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
	private void setNoneBorder(JButton button){
		button.setBorderPainted(false);
		button.setFocusPainted(false);
	}
	private void addSuccessfully(String code){
		TipDialog tipDialog=new TipDialog("添加成功！订单编号为" + code);
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
