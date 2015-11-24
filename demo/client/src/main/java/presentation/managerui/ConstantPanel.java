package presentation.managerui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import presentation.enums.CityType;
import presentation.enums.ContstantType;
import presentation.enums.OrderTypes;
import presentation.enums.PackageTypes;
import presentation.enums.TransportTypes;
import vo.ConstantsVO;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogicservice.managerblservice.ConstantsBlService;

public class ConstantPanel extends JPanel implements ActionListener {
	private JTable table;
	private JButton btnNewButton;
	private JComboBox<String> type;
	private JComboBox<String> select_1;
	private JComboBox<String> select_2;
	private ConstantsBlService constantsBlService;
	private List<ConstantsVO> list;
	private JButton btnNewButton_1;
	private ManagerPanel managerPanel;
	/**
	 * Create the panel.
	 * @param managerPanel 
	 */
	public ConstantPanel(final ManagerPanel managerPanel) {
		this.managerPanel = managerPanel;
		constantsBlService = new ConstantsController();

		setLayout(null);

		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(654, 0, 120, 32);
		add(btnNewButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 54, 954, 2);
		add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 79, 894, 317);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(30);

		type = new JComboBox<String>();
		type.setBounds(48, 0, 159, 32);
		add(type);
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
					list = constantsBlService
							.getConstants(ContstantType.Distance.getName());
				} else if (type.getSelectedItem().equals(
						ContstantType.PackageType.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
					select_2.setVisible(false);
					addPackTypeItems();
					list = constantsBlService
							.getConstants(ContstantType.PackageType.getName());
				} else if (type.getSelectedItem().equals(
						ContstantType.OrderType.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
					select_2.setVisible(false);
					addOrderTypeItems();
					list = constantsBlService
							.getConstants(ContstantType.OrderType.getName());
				} else if (type.getSelectedItem().equals(
						ContstantType.TransportType.getName())) {
					select_1.removeAllItems();
					select_2.removeAllItems();
					select_2.setVisible(false);
					addTransportTypeItems();
					list = constantsBlService
							.getConstants(ContstantType.TransportType.getName());
				}
				displayByVO(list);
				// testdisplayByVO();//作者测试用，真实使用时注释掉
			}
		});

		select_1 = new JComboBox<String>();
		select_1.setBounds(253, 0, 159, 32);
		add(select_1);

		select_2 = new JComboBox<String>();
		select_2.setBounds(453, 0, 159, 32);
		add(select_2);

		btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				try {
					String cellValue1 = (String) tableModel.getValueAt(
							table.getSelectedRow(), 0);
					double cellValue2 = Double.parseDouble((String) tableModel
							.getValueAt(table.getSelectedRow(), 1));
					constantsBlService.delConstants(new ConstantsVO(cellValue1,
							cellValue2));
					refreshList();
				} catch (ArrayIndexOutOfBoundsException e1) {
					managerPanel.setHint("系统提示：未选择删除项！");
				}
			}
		});
		btnNewButton_1.setBounds(801, 0, 120, 32);
		add(btnNewButton_1);

		addDistanceItems();

		ItemListener distanceListener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				refreshList();
			}
		};
		select_1.addItemListener(distanceListener);

		select_2.addItemListener(distanceListener);

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setColumnCount(2);
		tableModel.setRowCount(11);

		refreshList();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			AddConstantDailog dialog = new AddConstantDailog(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e2) {

		}
	}

	private void addTypeItems() {
		for (ContstantType city : ContstantType.values()) {
			type.addItem(city.getName());
		}
	}

	private void addDistanceItems() {
		select_1.addItem("全部");
		select_2.addItem("全部");
		for (CityType city : CityType.values()) {
			select_1.addItem(city.getName());
			select_2.addItem(city.getName());
		}
	}

	private void addPackTypeItems() {
		select_1.addItem("全部");
		for (PackageTypes packages : PackageTypes.values()) {
			select_1.addItem(packages.getName());
		}
	}

	private void addOrderTypeItems() {
		select_1.addItem("全部");
		for (OrderTypes order : OrderTypes.values()) {
			select_1.addItem(order.getName());
		}
	}

	private void addTransportTypeItems() {
		select_1.addItem("全部");
		for (TransportTypes transport : TransportTypes.values()) {
			select_1.addItem(transport.getName());
		}
	}

	private void displayByVO(List<ConstantsVO> list) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (ConstantsVO vo : list) {
			String[] row = new String[2];
			row[0] = vo.getName();
			row[1] = Double.toString(vo.getValue());

			tableModel.addRow(row);
		}

		if (table.getRowCount() < 11) {
			int n = table.getRowCount();
			for (int i = 0; i < 11 - n; i++) {
				tableModel.addRow(new String[2]);
			}
		}

	}

	void refreshList() {
		if (select_1.getSelectedItem() == null
				|| (select_2.getSelectedItem() == null && type
						.getSelectedItem().equals(
								ContstantType.Distance.getName()))) {
			System.out.println("111");
			return;
		}
		if (type.getSelectedItem().equals(ContstantType.Distance.getName())) {
			if (select_1.getSelectedItem().equals("全部")
					&& select_2.getSelectedItem().equals("全部")) {
				list = constantsBlService.getConstants(ContstantType.Distance
						.getName());
			} else if (select_1.getSelectedItem().equals("全部")) {
				list = constantsBlService.getConstants(ContstantType.Distance
						.getName().concat("-")
						.concat((String) select_2.getSelectedItem()));
			} else if (select_2.getSelectedItem().equals("全部")) {
				list = constantsBlService.getConstants(ContstantType.Distance
						.getName().concat("-")
						.concat((String) select_1.getSelectedItem()));
			} else {
				list = constantsBlService.getConstants(ContstantType.Distance
						.getName().concat("-")
						.concat((String) select_1.getSelectedItem())
						.concat("-")
						.concat((String) select_2.getSelectedItem()));
			}
		} else if (type.getSelectedItem().equals(
				ContstantType.PackageType.getName())) {
			if (select_1.getSelectedItem().equals("全部")) {
				list = constantsBlService
						.getConstants(ContstantType.PackageType.getName());
			} else {
				list = constantsBlService
						.getConstants(ContstantType.PackageType.getName()
								.concat("-")
								.concat((String) select_1.getSelectedItem()));
			}
		} else if (type.getSelectedItem().equals(
				ContstantType.OrderType.getName())) {
			if (select_1.getSelectedItem().equals("全部")) {
				list = constantsBlService.getConstants(ContstantType.OrderType
						.getName());
			} else {
				list = constantsBlService.getConstants(ContstantType.OrderType
						.getName().concat("-")
						.concat((String) select_1.getSelectedItem()));
			}
		} else if (type.getSelectedItem().equals(
				ContstantType.TransportType.getName())) {
			if (select_1.getSelectedItem().equals("全部")) {
				list = constantsBlService
						.getConstants(ContstantType.TransportType.getName());
			} else {
				list = constantsBlService
						.getConstants(ContstantType.TransportType.getName()
								.concat("-")
								.concat((String) select_1.getSelectedItem()));
			}
		}
		displayByVO(list);
	}
	
	void setHint(String str){
		managerPanel.setHint(str);
	}

	// 作者测试用，真实使用时可以不注释掉
	private void testdisplayByVO() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行
		String[] row = new String[2];
		row[0] = "1";
		row[1] = "1";

		tableModel.addRow(row);
		if (table.getRowCount() < 11) {
			int n = table.getRowCount();
			for (int i = 0; i < 11 - n; i++) {
				tableModel.addRow(new String[2]);
			}
		}
	}
}
