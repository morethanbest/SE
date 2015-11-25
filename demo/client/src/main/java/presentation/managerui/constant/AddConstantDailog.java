package presentation.managerui.constant;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import po.ResultMessage;
import presentation.enums.CityType;
import presentation.enums.ContstantType;
import presentation.enums.OrderTypes;
import presentation.enums.PackageTypes;
import presentation.enums.TransportTypes;
import vo.ConstantsVO;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogicservice.managerblservice.ConstantsBlService;


public class AddConstantDailog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JComboBox<String> type;
	private JComboBox<String> select_1;
	private JComboBox<String> select_2;

	/**
	 * Create the dialog.
	 */
	public AddConstantDailog(final ConstantPanel parent) {
		setModal(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
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
					select_2.setVisible(true);
					addDistanceItems();
				} else if (type.getSelectedItem().equals(
						ContstantType.PackageType.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
					select_2.setVisible(false);
					addPackTypeItems();
				} else if (type.getSelectedItem().equals(
						ContstantType.OrderType.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
					select_2.setVisible(false);
					addOrderTypeItems();
				} else if (type.getSelectedItem().equals(
						ContstantType.TransportType.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
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

		addDistanceItems();

		JLabel label = new JLabel("常量值");
		label.setBounds(292, 97, 73, 32);
		contentPanel.add(label);

		textField = new JTextField();
		textField.setBounds(231, 142, 187, 32);
		contentPanel.add(textField);
		textField.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("确定");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ConstantsBlService constantsBlService = new ConstantsController();
						String name = (String) type.getSelectedItem();
						name = name.concat("-").concat(
								(String) select_1.getSelectedItem());
						if (select_2.isVisible())
							name = name.concat("-").concat(
									(String) select_2.getSelectedItem());
						try {
							ConstantsVO vo = new ConstantsVO(name, Double
									.parseDouble(textField.getText()));
							if(constantsBlService.addConstants(vo) == ResultMessage.failure)
								parent.setHint("系统提示：添加失败，该常量已存在！");;
							parent.refreshList();
							dispose();
						} catch (NumberFormatException e1) {
							textField.setText("Wrong Input!");
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

	private void addDistanceItems() {
		for (CityType city : CityType.values()) {
			select_1.addItem(city.getName());
			select_2.addItem(city.getName());
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
