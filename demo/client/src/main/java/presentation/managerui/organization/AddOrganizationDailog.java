package presentation.managerui.organization;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import presentation.enums.OrganizationType;
import vo.CityVO;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogicservice.managerblservice.ConstantsBlService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddOrganizationDailog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField codeField;
	private JComboBox<String> citySelect;
	private JComboBox<String> orgSelect;
	private JTextField nameField;


	/**
	 * Create the dialog.
	 * @param organizationPanel 
	 */
	public AddOrganizationDailog(final OrganizationPanel parent) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		citySelect = new JComboBox<String>();
		citySelect.setBounds(29, 56, 172, 31);
		contentPanel.add(citySelect);
		addCityItems();
		
		orgSelect = new JComboBox<String>();
		orgSelect.setBounds(234, 56, 172, 31);
		contentPanel.add(orgSelect);
		addOrgTypeItems();
		
		codeField = new JTextField();
		codeField.setBounds(234, 132, 172, 31);
		contentPanel.add(codeField);
		codeField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setBounds(29, 132, 172, 31);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parent.addOrganization(nameField.getText(), codeField.getText(), (String) orgSelect.getSelectedItem(), (String)citySelect.getSelectedItem());
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void addCityItems() {
		ConstantsBlService constantsBlService = new ConstantsController();
		List<CityVO> cityList = constantsBlService.getAllCity();
		for (CityVO city : cityList) {
			citySelect.addItem(city.getName());
		}
	}
	
	private void addOrgTypeItems() {
		for (OrganizationType org : OrganizationType.values()) {
			orgSelect.addItem(org.getName());
		}
	}
}
