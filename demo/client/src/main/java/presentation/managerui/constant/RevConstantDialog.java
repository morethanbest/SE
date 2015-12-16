package presentation.managerui.constant;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import po.ResultMessage;
import presentation.enums.ContstantType;
import presentation.enums.OrderTypes;
import presentation.enums.PackageTypes;
import presentation.enums.TransportTypes;
import presentation.tip.DoubleField;
import presentation.tip.TipDialog;
import vo.CityVO;
import vo.ConstantsVO;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogicservice.managerblservice.ConstantsBlService;
import java.awt.SystemColor;


public class RevConstantDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DoubleField textField;
	private JComboBox<String> type;
	private JComboBox<String> select_1;
	private JComboBox<String> select_2;
	/**
	 * Create the dialog.
	 */
	public RevConstantDialog(final ConstantPanel parent, final List<CityVO> list) {
//		setModal(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		type = new JComboBox<String>();
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
					addDistanceItems(list);
				} else if (type.getSelectedItem().equals(
						ContstantType.PackageType.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
					select_1.setVisible(true);
					select_2.setVisible(false);
					addPackTypeItems();
				} else if (type.getSelectedItem().equals(
						ContstantType.OrderType.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
					select_1.setVisible(true);
					select_2.setVisible(false);
					addOrderTypeItems();
				} else if (type.getSelectedItem().equals(
						ContstantType.TransportType.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
					select_1.setVisible(true);
					select_2.setVisible(false);
					addTransportTypeItems();
				}
			}
		});

		select_1 = new JComboBox<String>();
		select_1.setBounds(231, 37, 187, 32);
		contentPanel.add(select_1);
		
		select_2 = new JComboBox<String>();
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
				JButton okButton = new JButton("确定");
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
								if(constantsBlService.revConstants(vo) == ResultMessage.failure){									
									TipDialog tipDialog=new TipDialog("该常量不存在！");
									tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									tipDialog.setVisible(true);		
								}
								else{
									parent.refreshList();System.out.println(textField.getText());
									dispose();
								}
							}
							
						}
						else{
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
								if(constantsBlService.revConstants(vo) == ResultMessage.failure){
									
									TipDialog tipDialog=new TipDialog("该常量不存在！");
									tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									tipDialog.setVisible(true);		
								}		
								else{
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
			if(!city.getName().equals("城市")){
				type.addItem(city.getName());
			}
			
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
