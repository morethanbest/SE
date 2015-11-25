package presentation.managerui.organization;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import presentation.enums.CityType;
import presentation.enums.OrganizationType;
import presentation.enums.TransportTypes;
import vo.ConstantsVO;
import vo.OrganizationVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class OrganizationPanel extends JPanel {
	private JTable table;
	JComboBox<String> orgSelect;
	JComboBox<String> citySelect;
	JButton btnAdd;
	JButton btnNewButton;
	JButton btnNewButton_1;
	
	/**
	 * Create the panel.
	 */
	public OrganizationPanel() {
		setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 58, 954, 10);
		add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 81, 930, 326);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		orgSelect = new JComboBox<String>();
		orgSelect.setBounds(0, 0, 174, 31);
		add(orgSelect);
		addOrgTypeItems();
		
		citySelect = new JComboBox<String>();
		citySelect.setBounds(188, 0, 174, 31);
		add(citySelect);
		addCityTypeItems();
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(587, 0, 113, 31);
		add(btnAdd);
		
		btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(714, 0, 113, 31);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Revise");
		btnNewButton_1.setBounds(841, 0, 113, 31);
		add(btnNewButton_1);

	}
	
	private void addCityTypeItems() {
		citySelect.addItem("全部");
		for (CityType city : CityType.values()) {
			citySelect.addItem(city.getName());
		}
	}
	
	private void addOrgTypeItems() {
		orgSelect.addItem("全部");
		for (OrganizationType org : OrganizationType.values()) {
			orgSelect.addItem(org.getName());
		}
	}
	
	private void displayByVO(List<OrganizationVO> list) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);// 清除原有行

		for (OrganizationVO vo : list) {
			String[] row = new String[2];
			row[0] = vo.getName();
//			row[1] = Double.toString(vo.getValue());

			tableModel.addRow(row);
		}

		if (table.getRowCount() < 11) {
			int n = table.getRowCount();
			for (int i = 0; i < 11 - n; i++) {
				tableModel.addRow(new String[2]);
			}
		}

	}
}
