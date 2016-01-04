package presentation.managerui.constant;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogicservice.managerblservice.ConstantsBlService;
import po.ResultMessage;
import presentation.enums.ContstantType;
import presentation.enums.OrderTypes;
import presentation.enums.PackageTypes;
import presentation.enums.TransportTypes;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.DoubleField;
import presentation.tip.TipDialog;
import vo.CityVO;
import vo.ConstantsVO;


public class AddConstantDailog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DoubleField textField;
	private MyComboBox<String> type;
	private MyComboBox<String> select_1;
	private MyComboBox<String> select_2;
	private MyTextField cityField;
	/**
	 * Create the dialog.
	 */
	public AddConstantDailog(final ConstantPanel parent, final List<CityVO> list) {
//		setModal(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		type = new MyComboBox<String>();
		type.setBounds(14, 37, 187, 32);
		contentPanel.add(type);
		addTypeItems();
		type.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (type.getSelectedItem().equals(
						ContstantType.Distance.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
					select_1.setVisible(true);
					select_2.setVisible(true);
					cityField.setVisible(false);
					addDistanceItems(list);
				} else if (type.getSelectedItem().equals(
						ContstantType.PackageType.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
					select_1.setVisible(true);
					select_2.setVisible(false);
					cityField.setVisible(false);
					addPackTypeItems();
				} else if (type.getSelectedItem().equals(
						ContstantType.OrderType.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
					select_1.setVisible(true);
					select_2.setVisible(false);
					cityField.setVisible(false);
					addOrderTypeItems();
				} else if (type.getSelectedItem().equals(
						ContstantType.TransportType.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
					select_1.setVisible(true);
					select_2.setVisible(false);
					cityField.setVisible(false);
					addTransportTypeItems();
				} else if (type.getSelectedItem().equals(
						ContstantType.City.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
					select_1.setVisible(false);
					select_2.setVisible(false);
					cityField.setVisible(true);
					
				}
			}
		});

		select_1 = new MyComboBox<String>();
		select_1.setBounds(231, 37, 187, 32);
		contentPanel.add(select_1);
		
		cityField = new MyTextField();
		cityField.setBounds(231, 37, 187, 32);
		contentPanel.add(cityField);
		cityField.setColumns(10);
		cityField.setVisible(false);
		
		select_2 = new MyComboBox<String>();
		select_2.setBounds(14, 142, 187, 32);
		contentPanel.add(select_2);

		addDistanceItems(list);

		JLabel label = new JLabel("常量值");
		label.setBounds(292, 97, 73, 32);
		contentPanel.add(label);

		textField = new DoubleField(20);
		textField.setBounds(231, 142, 187, 32);
		contentPanel.add(textField);
		textField.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaptionBorder);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				MyButton_LightBlue okButton = new MyButton_LightBlue("确定");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ConstantsBlService constantsBlService = new ConstantsController();
						String name = (String) type.getSelectedItem();
						if(select_1.isVisible()&&select_2.isVisible()){
							name = name.concat("-").concat(
									(String) select_1.getSelectedItem());
							name = name.concat("-").concat(
								(String) select_2.getSelectedItem());
							
							if(textField.getText().equals("")){
								TipDialog tipDialog=new TipDialog("请输入常量值！");
								tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								tipDialog.setVisible(true);		
							}
							else {
								ConstantsVO vo = new ConstantsVO(name, Double
										.parseDouble(textField.getText()));
								if(constantsBlService.addConstants(vo) == ResultMessage.failure){
									
									TipDialog tipDialog=new TipDialog("该常量已存在！");
									tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									tipDialog.setVisible(true);		
								}
								else{
									parent.refreshList();
									dispose();
								}
							}
							
						}
						else if(select_1.isVisible()){
							name = name.concat("-").concat(
									(String) select_1.getSelectedItem());
							
							if(textField.getText().equals("")){
								TipDialog tipDialog=new TipDialog("请输入常量值！");
								tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								tipDialog.setVisible(true);		
							}
							else {
								ConstantsVO vo = new ConstantsVO(name, Double
										.parseDouble(textField.getText()));
								if(constantsBlService.addConstants(vo) == ResultMessage.failure){
									
									TipDialog tipDialog=new TipDialog("该常量已存在！");
									tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									tipDialog.setVisible(true);		
								}		
								else{
									parent.refreshList();
									dispose();
								}
							}
						}
						else{
							if(cityField.getText().equals("")){
								TipDialog tipDialog=new TipDialog("请输入城市！");
								tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								tipDialog.setVisible(true);		
							}
							else if(textField.getText().equals("")){
								TipDialog tipDialog=new TipDialog("请输入常量值！");
								tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								tipDialog.setVisible(true);	
							}
							else{
								ResultMessage resultMessage=constantsBlService.addCity(new CityVO(cityField.getText(), textField.getText()));
								if(resultMessage==ResultMessage.failure){
									TipDialog tipDialog=new TipDialog("城市已存在！");
									tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									tipDialog.setVisible(true);		
								}
								else{
									parent.updateCity();
									parent.refreshList();
									dispose();
								}
								
							}
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("取消");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void addTypeItems() {
		for (ContstantType city : ContstantType.values()) {
			type.addItem(city.getName());
		}
	}

	private void addDistanceItems(List<CityVO> list2) {
		for(CityVO vo:list2){
			select_1.addItem(vo.getName());
			select_2.addItem(vo.getName());
		}
	}

	private void addPackTypeItems() {
		for (PackageTypes city : PackageTypes.values()) {
			select_1.addItem(city.getName());
		}
	}

	private void addOrderTypeItems() {
		for (OrderTypes city : OrderTypes.values()) {
			select_1.addItem(city.getName());
		}
	}

	private void addTransportTypeItems() {
		for (TransportTypes city : TransportTypes.values()) {
			select_1.addItem(city.getName());
		}
	}
	

	
}
