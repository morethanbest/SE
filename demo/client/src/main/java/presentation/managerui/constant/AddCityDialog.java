package presentation.managerui.constant;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogicservice.managerblservice.ConstantsBlService;

import javax.swing.JLabel;

import vo.CityVO;

public class AddCityDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField codeField;
	private JTextField cityField;


	/**
	 * Create the dialog.
	 */
	public AddCityDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		codeField = new JTextField();
		codeField.setBounds(157, 142, 213, 39);
		contentPanel.add(codeField);
		codeField.setColumns(10);
		{
			cityField = new JTextField();
			cityField.setBounds(157, 90, 213, 39);
			contentPanel.add(cityField);
			cityField.setColumns(10);
		}
		{
			JLabel lblCity = new JLabel("City");
			lblCity.setBounds(71, 100, 72, 18);
			contentPanel.add(lblCity);
		}
		{
			JLabel lblCode = new JLabel("Code");
			lblCode.setBounds(71, 152, 72, 18);
			contentPanel.add(lblCode);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ConstantsBlService constantsBlService = new ConstantsController();
						constantsBlService.addCity(new CityVO(cityField.getText(), codeField.getText()));
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
}
