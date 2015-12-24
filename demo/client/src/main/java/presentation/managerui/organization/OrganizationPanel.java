package presentation.managerui.organization;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import po.Organizationtype;
import po.ResultMessage;
import presentation.enums.OrganizationType;
import presentation.mycomp.WorkPanel;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.mycomp.myscrollpane.MyScrollPane;
import presentation.tip.TipDialog;
import vo.CityVO;
import vo.OrganizationVO;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogicservice.managerblservice.ConstantsBlService;
import businesslogicservice.managerblservice.OrganizationBlService;

public class OrganizationPanel extends WorkPanel implements ActionListener {
	private JTable table;
	private MyComboBox<String> orgSelect;
	private JComboBox<String> citySelect;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnRevise;
	private List<OrganizationVO> list;
	private OrganizationBlService organizationBlService;

	/**
	 * Create the panel.
	 */
	public OrganizationPanel() {
		setBackground(SystemColor.inactiveCaptionBorder);
		setLayout(null);

		organizationBlService = new OrganizationController();

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 954, 10);
		add(separator);

		MyScrollPane scrollPane = new MyScrollPane();
		scrollPane.setBounds(10, 81, 930, 326);
		add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"\u673A\u6784\u7F16\u53F7", "\u673A\u6784\u540D\u79F0", "\u6240\u5728\u57CE\u5E02", "\u673A\u6784\u7C7B\u578B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setRowHeight(30);
		scrollPane.setViewportView(table);

		orgSelect = new MyComboBox<String>();
		orgSelect.setBounds(0, 0, 174, 31);
		add(orgSelect);
		addOrgTypeItems();

		citySelect = new JComboBox<String>();
		citySelect.setBounds(199, 0, 174, 31);
		add(citySelect);
		addCityItems();

		ItemListener listener = new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				refreshList();
			}
		};

		citySelect.addItemListener(listener);
		orgSelect.addItemListener(listener);

		btnAdd = new JButton("增加");
		btnAdd.addActionListener(this);
		btnAdd.setBounds(587, 0, 113, 31);
		add(btnAdd);

		btnDelete = new JButton("删除");
		btnDelete.addActionListener(this);
		btnDelete.setBounds(714, 0, 113, 31);
		add(btnDelete);

		btnRevise = new JButton("修改");
		btnRevise.setBounds(841, 0, 113, 31);
		add(btnRevise);
		btnRevise.addActionListener(this);

		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(10);
		refreshList();
	}

	public void addCityItems() {
		citySelect.removeAllItems();
		ConstantsBlService constantsBlService = new ConstantsController();
		List<CityVO> cityList = constantsBlService.getAllCity();
		citySelect.addItem("全部");
		for (CityVO city : cityList) {
			citySelect.addItem(city.getName());
		}
	}

	private void addOrgTypeItems() {
		orgSelect.addItem("全部");
		for (OrganizationType org : OrganizationType.values()) {
			orgSelect.addItem(org.getName());
		}
	}

	private void displayByVO() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (OrganizationVO vo : list) {
			String[] row = new String[4];
			row[0] = vo.getOrganizationcode();
			row[1] = vo.getName();
			row[2] = vo.getCity();
			row[3] = getOrganizationStr(vo.getType());

			tableModel.addRow(row);
		}

		if (table.getRowCount() < 11) {
			int n = table.getRowCount();
			for (int i = 0; i < 11 - n; i++) {
				tableModel.addRow(new String[4]);
			}
		}

	}

	void refreshList() {
		if (citySelect.getSelectedItem() == null
				|| orgSelect.getSelectedItem() == null)
			return;
		if (citySelect.getSelectedItem().equals("全部")
				&& orgSelect.getSelectedItem().equals("全部"))
			list = organizationBlService.getOrganizationAll();
		else if (citySelect.getSelectedItem().equals("全部"))
			list = organizationBlService
					.getOrganizationbyType(getOrganizationType((String) orgSelect
							.getSelectedItem()));
		else if (orgSelect.getSelectedItem().equals("全部"))
			list = organizationBlService
					.getOrganizationbyCity((String) citySelect
							.getSelectedItem());
		else
			list = organizationBlService.getOrganizationbyBoth(
					(String) citySelect.getSelectedItem(),
					getOrganizationType((String) orgSelect.getSelectedItem()));

		displayByVO();
	}

	private Organizationtype getOrganizationType(String str) {
		for (OrganizationType org : OrganizationType.values()) {
			if (org.getName().equals(str)) {
				return org.getOrg();
			}
		}

		return null;
	}

	private String getOrganizationStr(Organizationtype org) {
		for (OrganizationType orgs : OrganizationType.values()) {
			if (orgs.getOrg() == org) {
				return orgs.getName();
			}
		}

		return null;
	}

	public ResultMessage addOrganization(String name, String org, String city){
		String code = organizationBlService.getOrganizationCode(city, getOrganizationType(org));
		ResultMessage resultMessage=organizationBlService.addOrganization(new OrganizationVO(name, code, getOrganizationType(org), city));
		refreshList();
		return resultMessage;
	}
	
	public ResultMessage revOrganization(OrganizationVO vo){
		ResultMessage resultMessage=organizationBlService.revOrganization(vo);
		refreshList();
		return resultMessage;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnAdd)) {
			AddOrganizationDailog dialog = new AddOrganizationDailog(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if(e.getSource().equals(btnDelete)){
			DefaultTableModel tableModel = (DefaultTableModel) table
					.getModel();
			try {
				organizationBlService.delOrganization(list.get(table.getSelectedRow()));
				refreshList();
			} catch (ArrayIndexOutOfBoundsException e1) {
				TipDialog Dialog=new TipDialog("请选择删除项！");
				Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				Dialog.setVisible(true);
			} catch (NullPointerException e1) {
				TipDialog Dialog=new TipDialog("请选择删除项！");
				Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				Dialog.setVisible(true);
			}
		}else if(e.getSource().equals(btnRevise)){
			DefaultTableModel tableModel = (DefaultTableModel) table
					.getModel();
			try {
                OrganizationVO organizationVO=list.get(table.getSelectedRow());
                RevOrganizationDialog revOrganizationDialog=new RevOrganizationDialog(this,organizationVO);
                revOrganizationDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                revOrganizationDialog.setVisible(true);
			} catch (ArrayIndexOutOfBoundsException e1) {
				TipDialog Dialog=new TipDialog("请选择修改项！");
				Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				Dialog.setVisible(true);
			} catch (NullPointerException e1) {
				TipDialog Dialog=new TipDialog("请选择修改项！");
				Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				Dialog.setVisible(true);
			}
		}

	}

}
