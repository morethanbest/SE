package presentation.Financial.account;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vo.AccountVO;

public class AddAccountDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameField;
    private JTextField sumField;
	/**
	 * Create the dialog.
	 */
	public AddAccountDialog(final AccountPanel parent) {
		setBounds(100, 100, 371, 277);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel JLName = new JLabel("账号：");
		JLName.setBounds(25, 36, 40, 20);
		contentPanel.add(JLName);
		
		nameField = new JTextField();
		nameField.setBounds(120, 36, 155, 20);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
		JLabel JLSum = new JLabel("余额：");
		JLSum.setBounds(25, 96, 40, 20);
		contentPanel.add(JLSum);
		
		sumField = new JTextField();
		sumField.setBounds(120, 96, 155, 20);
		contentPanel.add(sumField);
		sumField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						AccountVO VO=new AccountVO(0, nameField.getText(), Double.parseDouble(sumField.getText()));
						parent.addAccount(VO);
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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

}
