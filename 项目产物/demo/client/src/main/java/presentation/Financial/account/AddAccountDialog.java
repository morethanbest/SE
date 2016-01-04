package presentation.Financial.account;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import po.ResultMessage;
import presentation.mycomp.MyButton_LightBlue;
import presentation.tip.DoubleField;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.AccountVO;

public class AddAccountDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private NumberField nameField;
    private DoubleField sumField;
	/**
	 * Create the dialog.
	 */
	public AddAccountDialog(final AccountPanel parent) {
		setBounds(100, 100, 371, 277);
		setBackground(SystemColor.inactiveCaptionBorder);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel JLName = new JLabel("账号：");
		JLName.setBounds(25, 36, 40, 20);
		contentPanel.add(JLName);
		
		nameField = new NumberField(12);
		nameField.setBounds(120, 36, 155, 20);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
		JLabel JLSum = new JLabel("余额：");
		JLSum.setBounds(25, 96, 40, 20);
		contentPanel.add(JLSum);
		
		sumField = new DoubleField(12);
		sumField.setBounds(120, 96, 155, 20);
		contentPanel.add(sumField);
		sumField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				MyButton_LightBlue okButton = new MyButton_LightBlue("OK");
				okButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						if(nameField.getText().equals("")){
							TipDialog Dialog=new TipDialog("请输入账号！");
							Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							Dialog.setVisible(true);
						}
						else if(sumField.getText().equals("")){
							TipDialog Dialog=new TipDialog("请输入余额！");
							Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							Dialog.setVisible(true);
						}
						else{
							try {
								double sum=Double.parseDouble(sumField.getText());
								AccountVO VO=new AccountVO(0, nameField.getText(), sum);
								ResultMessage resultMessage=parent.addAccount(VO);
								if(resultMessage==ResultMessage.failure){
									TipDialog Dialog=new TipDialog("账号重复！");
									Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									Dialog.setVisible(true);
								}
								else{
									dispose();
								}
								
							} catch (Exception e2) {
								// TODO: handle exception
								TipDialog Dialog=new TipDialog("请输入规范的余额！");
								Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								Dialog.setVisible(true);
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

}
