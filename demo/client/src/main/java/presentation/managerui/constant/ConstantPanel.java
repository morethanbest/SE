package presentation.managerui.constant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import presentation.enums.ContstantType;
import presentation.enums.OrderTypes;
import presentation.enums.PackageTypes;
import presentation.enums.TransportTypes;
import presentation.managerui.ManagerPanel;
import presentation.tip.TipDialog;
import vo.CityVO;
import vo.ConstantsVO;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogicservice.managerblservice.ConstantsBlService;
import po.ResultMessage;

import java.awt.SystemColor;
import java.awt.Font;

public class ConstantPanel extends JPanel implements ActionListener {
	private JTable table;
	private JComboBox<String> type;
	private JComboBox<String> select_1;
	private JComboBox<String> select_2;
	private ConstantsBlService constantsBlService;
	private List<ConstantsVO> list1;
	private List<CityVO> cityList;
	private JButton btnDelete;
	private ManagerPanel managerPanel;
	private JButton btnRevise;
	private JButton btnAdd;
	/**
	 * Create the panel.
	 * 
	 * @param managerPanel
	 */
	public ConstantPanel(final ManagerPanel managerPanel) {
		setBackground(SystemColor.inactiveCaptionBorder);
		this.managerPanel = managerPanel;
		constantsBlService = new ConstantsController();
		cityList = constantsBlService.getAllCity();

		
		setLayout(null);

		btnAdd = new JButton("增加");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(530, 0, 120, 32);
		add(btnAdd);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 54, 954, 2);
		add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 79, 894, 317);
		add(scrollPane);

		table = new JTable();
		table.setFont(new Font("微软雅黑 Light", Font.BOLD, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"\u540D\u79F0", "\u6570\u503C"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		table.setRowHeight(30);

		type = new JComboBox<String>();
		type.setBounds(48, 0, 120, 32);
		add(type);
		addTypeItems();
		type.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (type.getSelectedItem().equals(ContstantType.City.getName())) {
					select_2.setVisible(false);
					addCityItems();
					displayByCity(cityList);
				} else {
					if (type.getSelectedItem().equals(
							ContstantType.Distance.getName())) {
						select_2.setVisible(true);
						addDistanceItems();
						list1 = constantsBlService
								.getConstants(ContstantType.Distance.getName());
						displayByVO(list1);
					} else if (type.getSelectedItem().equals(
							ContstantType.PackageType.getName())) {
						select_2.setVisible(false);
						addPackTypeItems();
						list1 = constantsBlService
								.getConstants(ContstantType.PackageType
										.getName());
						displayByVO(list1);
					} else if (type.getSelectedItem().equals(
							ContstantType.OrderType.getName())) {
						select_2.setVisible(false);
						addOrderTypeItems();
						list1 = constantsBlService
								.getConstants(ContstantType.OrderType.getName());
						displayByVO(list1);
					} else if (type.getSelectedItem().equals(
							ContstantType.TransportType.getName())) {
						select_2.setVisible(false);
						addTransportTypeItems();
						list1 = constantsBlService
								.getConstants(ContstantType.TransportType
										.getName());
						displayByVO(list1);
					}
				}
				// testdisplayByVO();//作者测试用，真实使用时注释掉
			}
		});

		select_1 = new JComboBox<String>();
		select_1.setBounds(182, 0, 120, 32);
		add(select_1);

		select_2 = new JComboBox<String>();
		select_2.setBounds(316, 0, 120, 32);
		add(select_2);

		btnDelete = new JButton("删除");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tableModel = (DefaultTableModel) table
						.getModel();
				if(type.getSelectedItem().equals(
						ContstantType.City.getName())){
					try {
						String cellValue1 = (String) tableModel.getValueAt(
								table.getSelectedRow(), 0);
						String cellValue2 = (String) tableModel
								.getValueAt(table.getSelectedRow(), 1);
						if(constantsBlService.delCity(new CityVO(cellValue1,cellValue2))==ResultMessage.failure){
							TipDialog tipDialog=new TipDialog("该常量不可删除！");
							tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							tipDialog.setVisible(true);	
						}
						updateCity();
						refreshList();
					} catch (ArrayIndexOutOfBoundsException  e1) {
						TipDialog tipDialog=new TipDialog("请选择删除项！");
						tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						tipDialog.setVisible(true);		
					} catch (NullPointerException e1) {
						TipDialog tipDialog=new TipDialog("请选择删除项！");
						tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						tipDialog.setVisible(true);		
					}
				}
				else{
					try {
						String cellValue1 = (String) tableModel.getValueAt(
								table.getSelectedRow(), 0);
						double cellValue2 = Double.parseDouble((String) tableModel
								.getValueAt(table.getSelectedRow(), 1));
						if(constantsBlService.delConstants(new ConstantsVO(cellValue1,cellValue2))==ResultMessage.failure){
							TipDialog tipDialog=new TipDialog("该常量不可删除！");
							tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							tipDialog.setVisible(true);	
						}
						refreshList();
					} catch (ArrayIndexOutOfBoundsException  e1) {
						TipDialog tipDialog=new TipDialog("请选择删除项！");
						tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						tipDialog.setVisible(true);		
					} catch (NullPointerException e1) {
						TipDialog tipDialog=new TipDialog("请选择删除项！");
						tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						tipDialog.setVisible(true);		
					}
				}
			}
		});
		btnDelete.setBounds(664, 0, 120, 32);
		add(btnDelete);
		
		btnRevise = new JButton("修改");
		btnRevise.setBounds(798, 0, 113, 32);
		add(btnRevise);
		
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
		tableModel.setRowCount(10);
		refreshList();
        
		btnDelete.addActionListener(this);
		btnRevise.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAdd)){
			AddConstantDailog dialog = new AddConstantDailog(this, cityList);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		else if(e.getSource().equals(btnRevise)){
			DefaultTableModel tableModel = (DefaultTableModel) table
					.getModel();
			if(type.getSelectedItem().equals(
					ContstantType.City.getName())){
				try {
					String cellValue1 = (String) tableModel.getValueAt(
							table.getSelectedRow(), 0);
					String cellValue2 = (String) tableModel
							.getValueAt(table.getSelectedRow(), 1);
					RevConstantDialog revConstantDialog=new RevConstantDialog(this, cellValue1, cellValue2, true);
					revConstantDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					revConstantDialog.setVisible(true);
				} catch (ArrayIndexOutOfBoundsException  e1) {
					TipDialog tipDialog=new TipDialog("请选择修改项！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);		
				} catch (NullPointerException e1) {
					TipDialog tipDialog=new TipDialog("请选择修改项！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);		
				}
			}
			else{
				try {
					String cellValue1 = (String) tableModel.getValueAt(
							table.getSelectedRow(), 0);
					String cellValue2 = (String) tableModel
							.getValueAt(table.getSelectedRow(), 1);
					RevConstantDialog revConstantDialog=new RevConstantDialog(this, cellValue1, cellValue2, false);
					revConstantDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					revConstantDialog.setVisible(true);
				} catch (ArrayIndexOutOfBoundsException  e1) {
					TipDialog tipDialog=new TipDialog("请选择修改项！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);		
				} catch (NullPointerException e1) {
					TipDialog tipDialog=new TipDialog("请选择修改项！");
					tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tipDialog.setVisible(true);		
				}
			}
		}

	}

	private void addTypeItems() {
		for (ContstantType city : ContstantType.values()) {
			type.addItem(city.getName());
		}
	}

	private void addDistanceItems() {
		select_1.removeAllItems();
		select_2.removeAllItems();
		select_1.addItem("全部");
		select_2.addItem("全部");
		for(CityVO vo:cityList){
			select_1.addItem(vo.getName());
			select_2.addItem(vo.getName());
		}
	}

	private void addPackTypeItems() {
		select_1.removeAllItems();
		select_2.removeAllItems();
		select_1.addItem("全部");
		for (PackageTypes packages : PackageTypes.values()) {
			select_1.addItem(packages.getName());
		}
	}

	private void addCityItems() {
		select_1.removeAllItems();
		select_2.removeAllItems();
		select_1.addItem("全部");
		for(CityVO vo:cityList){
			select_1.addItem(vo.getName());
		}
	}

	private void addOrderTypeItems() {
		select_1.removeAllItems();
		select_2.removeAllItems();
		select_1.addItem("全部");
		for (OrderTypes order : OrderTypes.values()) {
			select_1.addItem(order.getName());
		}
	}

	private void addTransportTypeItems() {
		select_1.removeAllItems();
		select_2.removeAllItems();
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

	private void displayByCity(List<CityVO> list) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (CityVO vo : list) {
			String[] row = new String[2];
			row[0] = vo.getName();
			row[1] = vo.getZone();

			tableModel.addRow(row);
		}

		if (table.getRowCount() < 11) {
			int n = table.getRowCount();
			for (int i = 0; i < 11 - n; i++) {
				tableModel.addRow(new String[2]);
			}
		}
	}
	
	void updateCity(){
		cityList = constantsBlService.getAllCity();
		addCityItems();
		displayByCity(cityList);
	}

	public void refreshList() {
		if (select_1.getSelectedItem() == null
				|| (select_2.getSelectedItem() == null && type
						.getSelectedItem().equals(
								ContstantType.Distance.getName()))) {
			return;
		}
		if (type.getSelectedItem().equals(ContstantType.Distance.getName())) {
			if (select_1.getSelectedItem().equals("全部")
					&& select_2.getSelectedItem().equals("全部")) {
				list1 = constantsBlService.getConstants(ContstantType.Distance
						.getName());
			} else if (select_1.getSelectedItem().equals("全部")) {
				list1 = constantsBlService.getConstants(ContstantType.Distance
						.getName().concat("-")
						.concat((String) select_2.getSelectedItem()));
			} else if (select_2.getSelectedItem().equals("全部")) {
				list1 = constantsBlService.getConstants(ContstantType.Distance
						.getName().concat("-")
						.concat((String) select_1.getSelectedItem()));
			} else {
				list1 = constantsBlService.getConstants(ContstantType.Distance
						.getName().concat("-")
						.concat((String) select_1.getSelectedItem())
						.concat("-")
						.concat((String) select_2.getSelectedItem()));
			}
			displayByVO(list1);
		} else if (type.getSelectedItem().equals(ContstantType.City.getName())) {
			if (select_1.getSelectedItem().equals("全部")) {
				displayByCity(cityList);
			} else {
				for (CityVO vo : cityList) {
					if (vo.getName().equals(select_1.getSelectedItem())) {
						List<CityVO> thisvo = new ArrayList<CityVO>();
						thisvo.add(vo);
						displayByCity(thisvo);
					}
				}
			}
		} else if (type.getSelectedItem().equals(
				ContstantType.PackageType.getName())) {
			if (select_1.getSelectedItem().equals("全部")) {
				list1 = constantsBlService
						.getConstants(ContstantType.PackageType.getName());
			} else {
				list1 = constantsBlService
						.getConstants(ContstantType.PackageType.getName()
								.concat("-")
								.concat((String) select_1.getSelectedItem()));
			}
			displayByVO(list1);
		} else if (type.getSelectedItem().equals(
				ContstantType.OrderType.getName())) {
			if (select_1.getSelectedItem().equals("全部")) {
				list1 = constantsBlService.getConstants(ContstantType.OrderType
						.getName());
			} else {
				list1 = constantsBlService.getConstants(ContstantType.OrderType
						.getName().concat("-")
						.concat((String) select_1.getSelectedItem()));
			}
			displayByVO(list1);
		} else if (type.getSelectedItem().equals(
				ContstantType.TransportType.getName())) {
			if (select_1.getSelectedItem().equals("全部")) {
				list1 = constantsBlService
						.getConstants(ContstantType.TransportType.getName());
			} else {
				list1 = constantsBlService
						.getConstants(ContstantType.TransportType.getName()
								.concat("-")
								.concat((String) select_1.getSelectedItem()));
			}
			displayByVO(list1);
		}
	}

	void setHint(String str) {
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
