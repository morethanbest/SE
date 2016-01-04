package presentation.managerui.examui.examcourierui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogic.managerbl.ExamPack.ExamController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.managerblservice.ConstantsBlService;
import businesslogicservice.managerblservice.ExamOrdersBlService;
import businesslogicservice.managerblservice.OrganizationBlService;
import po.Formstate;
import po.Ordertype;
import po.ResultMessage;
import presentation.enums.OrderTypes;
import presentation.enums.PackageTypes;
import presentation.managerui.examui.ExamPanel;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.TipDialog;
import vo.CityVO;
import vo.OrderVO;
import vo.OrganizationVO;

public class OrderRevisePanel extends WorkPanel {
	private MyTextField snameField;
	private MyTextField sdetailField;
	private MyTextField sjobField;
	private MyTextField stelField;
	private MyTextField sphoneField;
	private MyTextField rnameField;
	private MyTextField rdetailField;
	private MyTextField rtelField;
	private MyTextField rphoneField;
	private MyComboBox<String> packBox;
	private MyTextField numberField;
	private MyTextField weightField;
	private MyTextField volumeField;
	private MyTextField nameField;
	private JLabel label_2;
	private JSeparator separator_3;
	private MyTextField fareField;
	private MyButton_LightBlue update;
	private JSeparator separator_4;
	private MyComboBox<String> scityBox;
	private MyComboBox<String> sareaBox;
	private MyComboBox<String> rcityBox;
	private MyComboBox<String> rareaBox;
	private MyComboBox<String> orderBox;
	private MyTextField rjobField;
//换成exam开头的方法
	private ExamOrdersBlService ea;
	private MyButton_LightBlue back;
	private JLabel orderCode;
	private OrderVO temp;

	/**
	 * Create the panel.
	 * 
	 */
//这里换参数
	public OrderRevisePanel(ExamPanel parent, CardLayout card) {
		setBackground(new Color(244, 247, 252));
		ea = new ExamController();
		setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(98, 43, 2, 466);
		add(separator);

		JLabel label = new JLabel("寄件人信息");
		label.setBounds(0, 54, 75, 18);
		add(label);

		JLabel label_3 = new JLabel("姓名：");
		label_3.setBounds(114, 54, 58, 18);
		add(label_3);
		
		JLabel label_4 = new JLabel("姓名：");
		label_4.setBounds(114, 160, 58, 18);
		add(label_4);
		
		JLabel label_5 = new JLabel("城市：");
		label_5.setBounds(255, 54, 52, 18);
		add(label_5);
		
		JLabel label_6 = new JLabel("城市：");
		label_6.setBounds(255, 160, 52, 18);
		add(label_6);
		
		JLabel label_7 = new JLabel("地区：");
		label_7.setBounds(401, 54, 52, 18);
		add(label_7);
		
		JLabel label_8 = new JLabel("地区：");
		label_8.setBounds(401, 160, 52, 18);
		add(label_8);
		
		JLabel label_9 = new JLabel("具体地址：");
		label_9.setBounds(605, 54, 75, 18);
		add(label_9);
		
		JLabel label_10 = new JLabel("具体地址：");
		label_10.setBounds(605, 160, 75, 18);
		add(label_10);
		
		JLabel label_11 = new JLabel("单位：");
		label_11.setBounds(114, 108, 58, 18);
		add(label_11);
		
		JLabel label_12 = new JLabel("单位：");
		label_12.setBounds(114, 210, 58, 18);
		add(label_12);
		
		JLabel label_13 = new JLabel("电话：");
		label_13.setBounds(401, 108, 54, 18);
		add(label_13);
		
		JLabel label_14 = new JLabel("电话：");
		label_14.setBounds(401, 210, 54, 18);
		add(label_14);
		
		JLabel label_15 = new JLabel("手机：");
		label_15.setBounds(605, 108, 52, 18);
		add(label_15);
		
		JLabel label_16 = new JLabel("手机：");
		label_16.setBounds(605, 210, 53, 18);
		add(label_16);
		
		JLabel label_17 = new JLabel("原件数：");
		label_17.setBounds(110, 262, 72, 18);
		add(label_17);
		
		JLabel label_18 = new JLabel("重量：");
		label_18.setBounds(255, 262, 58, 18);
		add(label_18);
		
		JLabel label_19 = new JLabel("体积：");
		label_19.setBounds(401, 262, 58, 18);
		add(label_19);
		
		JLabel label_20 = new JLabel("货物名称：");
		label_20.setBounds(605, 262, 75, 18);
		add(label_20);
		
		JLabel label_21 = new JLabel("运费：");
		label_21.setBounds(491, 3, 58, 18);
		add(label_21);
		
		JLabel label_22 = new JLabel("订单类型：");
		label_22.setBounds(401, 318, 82, 18);
		add(label_22);
		
		JLabel label_23 = new JLabel("包装类型：");
		label_23.setBounds(110, 318, 86, 18);
		add(label_23);
		
		snameField = new MyTextField();
		snameField.setText("奥巴马");
		snameField.setBounds(151, 51, 96, 24);
		add(snameField);
		snameField.setColumns(10);

		scityBox = new MyComboBox<String>();
		scityBox.setBounds(305, 51, 86, 24);
		add(scityBox);
		addCityItems(scityBox);

		sareaBox = new MyComboBox<String>();
		sareaBox.setBounds(449, 51, 138, 24);
		add(sareaBox);
		addOrganizationItems(scityBox, sareaBox);

		sdetailField = new MyTextField();
		sdetailField.setText("白宫");
		sdetailField.setBounds(677, 51, 188, 24);
		add(sdetailField);
		sdetailField.setColumns(10);

		sjobField = new MyTextField();
		sjobField.setText("美国总统");
		sjobField.setBounds(151, 105, 226, 24);
		add(sjobField);
		sjobField.setColumns(10);

		stelField = new MyTextField();
		stelField.setText("911");
		stelField.setBounds(449, 105, 138, 24);
		add(stelField);
		stelField.setColumns(10);

		sphoneField = new MyTextField();
		sphoneField.setText("911");
		sphoneField.setBounds(677, 105, 188, 24);
		add(sphoneField);
		sphoneField.setColumns(10);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(114, 142, 831, 2);
		add(separator_1);

		JLabel label_1 = new JLabel("收件人信息");
		label_1.setBounds(0, 191, 75, 18);
		add(label_1);

		rnameField = new MyTextField();
		rnameField.setText("习近平");
		rnameField.setColumns(10);
		rnameField.setBounds(151, 157, 96, 24);
		add(rnameField);

		rcityBox = new MyComboBox<String>();
		rcityBox.setBounds(305, 157, 86, 24);
		add(rcityBox);
		addCityItems(rcityBox);

		rareaBox = new MyComboBox<String>();
		rareaBox.setBounds(449, 157, 138, 24);
		add(rareaBox);
		addOrganizationItems(rcityBox, rareaBox);

		rdetailField = new MyTextField();
		rdetailField.setText("中南海");
		rdetailField.setColumns(10);
		rdetailField.setBounds(677, 157, 188, 24);
		add(rdetailField);

		rjobField = new MyTextField();
		rjobField.setText("中国主席");
		rjobField.setColumns(10);
		rjobField.setBounds(150, 207, 226, 24);
		add(rjobField);

		rtelField = new MyTextField();
		rtelField.setText("110");
		rtelField.setColumns(10);
		rtelField.setBounds(455, 208, 132, 24);
		add(rtelField);

		rphoneField = new MyTextField();
		rphoneField.setText("110");
		rphoneField.setColumns(10);
		rphoneField.setBounds(677, 207, 188, 24);
		add(rphoneField);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(125, 244, 820, 2);
		add(separator_2);

		numberField = new MyTextField();
		numberField.setText("1");
		numberField.setBounds(175, 259, 58, 24);
		add(numberField);
		numberField.setColumns(10);

		weightField = new MyTextField();
		weightField.setText("1");
		weightField.setBounds(305, 259, 86, 24);
		add(weightField);
		weightField.setColumns(10);

		volumeField = new MyTextField();
		volumeField.setText("1");
		volumeField.setBounds(455, 259, 132, 24);
		add(volumeField);
		volumeField.setColumns(10);

		nameField = new MyTextField();
		nameField.setText("核弹");
		nameField.setBounds(677, 259, 188, 24);
		add(nameField);
		nameField.setColumns(10);

		packBox = new MyComboBox<String>();
		packBox.setBounds(175, 315, 159, 24);
		add(packBox);
		addPackTypeItems();

		orderBox = new MyComboBox<String>();
		orderBox.setBounds(478, 315, 159, 24);
		add(orderBox);
		addOrderTypeItems();

		label_2 = new JLabel("托运货物信息");
		label_2.setBounds(0, 262, 96, 18);
		add(label_2);

		separator_3 = new JSeparator();
		separator_3.setBounds(125, 352, 820, 2);
		add(separator_3);

		fareField = new MyTextField();
		fareField.setText("0");
		fareField.setBounds(571, 0, 68, 24);
		add(fareField);
		fareField.setColumns(10);
//所有运费删掉

		update = new MyButton_LightBlue("提交修改");
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
					ResultMessage resultMessage =ea.updateOrderForm(
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
					if(resultMessage==ResultMessage.success){
						TipDialog tipDialog=new TipDialog("修改成功！");
						tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						tipDialog.setVisible(true);	
					}else {
						TipDialog tipDialog=new TipDialog("修改失败！");
						tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						tipDialog.setVisible(true);	
					}
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
		orderCode.setBounds(194, 0, 218, 18);
		add(orderCode);
		
		back = new MyButton_LightBlue("返回");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.previous(parent);
				parent.getOrder().refreshList();
			}
		});
		back.setBounds(717, 362, 122, 36);
		add(back);
		
		MyButton_LightBlue undo = new MyButton_LightBlue("恢复原值");
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				init(temp);
			}
		});
		undo.setBounds(581, 362, 122, 36);
		add(undo);
		
		JLabel label_24 = new JLabel("订单号：");
		label_24.setBounds(79, 3, 54, 15);
		add(label_24);

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
