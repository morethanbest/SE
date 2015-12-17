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
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.CityVO;
import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogicservice.managerblservice.ConstantsBlService;
import po.ResultMessage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class AddOrganizationDailog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> citySelect;
	private JComboBox<String> orgSelect;
	private JTextField nameField;


	/**
	 * Create the dialog.
	 * @param organizationPanel 
	 */
	public AddOrganizationDailog(final OrganizationPanel parent) {
		setBounds(100, 100, 340, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		citySelect = new JComboBox<String>();
		citySelect.setBounds(65, 31, 172, 31);
		contentPanel.add(citySelect);
		addCityItems();
		
		orgSelect = new JComboBox<String>();
		orgSelect.setBounds(65, 114, 172, 31);
		contentPanel.add(orgSelect);
		addOrgTypeItems();
		
		nameField = new JTextField();
		nameField.setBounds(65, 187, 172, 31);
		contentPanel.add(nameField);
		nameField.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaptionBorder);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(nameField.getText().equals("")){
							TipDialog Dialog=new TipDialog("请输入组织名！");
							Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							Dialog.setVisible(true);
						}
						else{
							ResultMessage resultMessage=parent.addOrganization(nameField.getText(), (String) orgSelect.getSelectedItem(), (String)citySelect.getSelectedItem());
							if(resultMessage==ResultMessage.failure){
								TipDialog Dialog=new TipDialog("组织增加失败！");
								Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								Dialog.setVisible(true);
							}
							else{
								dispose();
							}
							
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
