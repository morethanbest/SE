package presentation.managerui.constant;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businesslogic.managerbl.ConstantsPack.ConstantsController;
import businesslogicservice.managerblservice.ConstantsBlService;
import po.ResultMessage;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.MyTextField;
import presentation.tip.DoubleField;
import presentation.tip.TipDialog;
import vo.CityVO;
import vo.ConstantsVO;


public class RevConstantDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DoubleField valueField;
    private	MyTextField nameField;
	/**
	 * Create the dialog.
	 */
	public RevConstantDialog(final ConstantPanel parent,String name, String value, boolean iscity) {
//		setModal(true);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel label = new JLabel("常量值:");
		label.setBounds(65, 141, 73, 32);
		contentPanel.add(label);

		valueField = new DoubleField(20);
		valueField.setBounds(199, 142, 187, 32);
		contentPanel.add(valueField);
		valueField.setColumns(10);
		valueField.setText(value);
		
		JLabel label_1 = new JLabel("常量名:");
		label_1.setBounds(65, 39, 73, 32);
		contentPanel.add(label_1);
		
		nameField = new MyTextField();
		nameField.setColumns(10);
		nameField.setBounds(199, 40, 187, 32);
		contentPanel.add(nameField);
		nameField.setText(name);
		nameField.setEditable(false);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaptionBorder);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				MyButton_LightBlue okButton = new MyButton_LightBlue("确定");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ConstantsBlService constantsBlService = new ConstantsController();
						
						if(iscity==false){
							if(valueField.getText().equals("")){
								TipDialog tipDialog=new TipDialog("请输入常量值！");
								tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								tipDialog.setVisible(true);		
							}
							else {
								ConstantsVO vo = new ConstantsVO(name, Double
										.parseDouble(valueField.getText()));
								if(constantsBlService.revConstants(vo) == ResultMessage.failure){									
									TipDialog tipDialog=new TipDialog("该常量不存在！");
									tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									tipDialog.setVisible(true);		
								}
								else{
									parent.refreshList();
									dispose();
								}
							}
							
						}
						else{
							if(valueField.getText().equals("")){
								TipDialog tipDialog=new TipDialog("请输入常量值！");
								tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								tipDialog.setVisible(true);		
							}
							else {
								CityVO vo=new CityVO(name, valueField.getText());
								if(constantsBlService.revCity(vo) == ResultMessage.failure){
									TipDialog tipDialog=new TipDialog("该常量不存在或无法修改！");
									tipDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									tipDialog.setVisible(true);		
								}		
								else{
									parent.refreshList();
									parent.updateCity();
									dispose();
								}
							}
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				MyButton_LightBlue cancelButton = new MyButton_LightBlue("取消");
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
