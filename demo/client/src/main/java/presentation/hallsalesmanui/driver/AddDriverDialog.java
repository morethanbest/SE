package presentation.hallsalesmanui.driver;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddDriverDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
    private JTextField nameField;
    private JTextField codeField;
    private JTextField phoneField;
    private JComboBox<String> SexSelect;
    private JComboBox<String> ByearSelect;
    private JComboBox<String> BmouthSelect;
    private JComboBox<String> BdaySelect;
    private JComboBox<String> DyearSelect;
    private JComboBox<String> DmouthSelect;
    private JComboBox<String> DdaySelect;
	/**
	 * Create the dialog.
	 */
	public AddDriverDialog(final DriverPanel parent) {
		setBounds(100, 100, 549, 351);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel JLName = new JLabel("姓名：");
		JLName.setBounds(29, 36, 40, 20);
		contentPanel.add(JLName);
		
		nameField = new JTextField();
		nameField.setBounds(80, 36, 155, 20);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
		JLabel JLSex = new JLabel("性别：");
		JLSex.setBounds(250, 36, 40, 20);
		contentPanel.add(JLSex);
		
		SexSelect = new JComboBox<String>();
		SexSelect.setBounds(320, 36, 155, 20);
		contentPanel.add(SexSelect);
		
		JLabel JLCode = new JLabel("编号：");
		JLCode.setBounds(29, 96, 40, 20);
		contentPanel.add(JLCode);
		
		codeField = new JTextField();
		codeField.setBounds(80, 96, 155, 20);
		contentPanel.add(codeField);
		codeField.setColumns(10);
		
		JLabel JLPhone = new JLabel("手机号：");
		JLPhone.setBounds(250, 96, 60, 20);
		contentPanel.add(JLPhone);
		
		phoneField = new JTextField();
		phoneField.setBounds(320, 96, 155, 20);
		contentPanel.add(phoneField);
		phoneField.setColumns(10);
		
		JLabel JLBirth = new JLabel("出生日期：");
		JLBirth.setBounds(29, 156, 70, 20);
		contentPanel.add(JLBirth);
		
		ByearSelect = new JComboBox<String>();
		ByearSelect.setBounds(83, 156, 65, 20);
		contentPanel.add(ByearSelect);
		
		BmouthSelect = new JComboBox<String>();
		BmouthSelect.setBounds(150, 156, 40, 20);
		contentPanel.add(BmouthSelect);
		
		BdaySelect = new JComboBox<String>();
		BdaySelect.setBounds(195, 156, 40, 20);
		contentPanel.add(BdaySelect);
		
		JLabel JLDriver = new JLabel("行驶期限：");
		JLDriver.setBounds(250, 156, 70, 20);
		contentPanel.add(JLDriver);
		
		ByearSelect = new JComboBox<String>();
		ByearSelect.setBounds(304, 156, 65, 20);
		contentPanel.add(ByearSelect);
		
		BmouthSelect = new JComboBox<String>();
		BmouthSelect.setBounds(371, 156, 40, 20);
		contentPanel.add(BmouthSelect);
		
		BdaySelect = new JComboBox<String>();
		BdaySelect.setBounds(416, 156, 40, 20);
		contentPanel.add(BdaySelect);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
