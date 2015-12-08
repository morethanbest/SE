package presentation.administratorui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import po.Job;
import po.Organizationtype;
import vo.OrganizationVO;
import vo.UserVO;

import javax.swing.JLabel;

public class AddUserDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameToSearch;
	private JTextField nameField;
	private JTextField passwordField;
	private JTextField orgcodeField;
	private JTextField orgnameField;
	private JTextField cityField;
	private JComboBox<String> jobSelect;
	private JComboBox<String> orgSelect;
	private boolean isagain=false;
	/**
	 * Create the dialog.
	 */
	public AddUserDialog(final UserPanel parent) {
		setBounds(100, 100, 450, 519);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel JLname = new JLabel("账号：");
		JLname.setBounds(25, 36, 60, 20);
		contentPanel.add(JLname);
		
		nameField = new JTextField();
		nameField.setBounds(100, 36, 182, 20);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
		JLabel JLpassword = new JLabel("密码：");
		JLpassword.setBounds(25, 96, 60, 20);
		contentPanel.add(JLpassword);
		
		passwordField = new JTextField();
		passwordField.setBounds(100, 96, 182, 20);
		contentPanel.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel JLjob = new JLabel("职位：");
		JLjob.setBounds(25, 156, 60, 20);
		contentPanel.add(JLjob);
		
		jobSelect = new JComboBox<String >();
		jobSelect.setBounds(100, 156, 182, 20);
		addJobItem();
		contentPanel.add(jobSelect);
		
		JLabel JLcity = new JLabel("城市：");
		JLcity.setBounds(25, 216, 60, 20);
		contentPanel.add(JLcity);
		
		cityField = new JTextField();
		cityField.setEditable(false);
		cityField.setColumns(10);
		cityField.setBounds(100, 216, 182, 20);
		contentPanel.add(cityField);
		
		JLabel JLorgname = new JLabel("机构名：");
		JLorgname.setBounds(25, 276, 60, 20);
		contentPanel.add(JLorgname);
		
		orgnameField = new JTextField();
		orgnameField.setEditable(false);
		orgnameField.setColumns(10);
		orgnameField.setBounds(100, 276, 182, 20);
		contentPanel.add(orgnameField);
		
		JLabel JLorgtype = new JLabel("机构类别：");
		JLorgtype.setBounds(25, 336, 60, 20);
		contentPanel.add(JLorgtype);
		
		orgSelect = new JComboBox<String >();
		orgSelect.setBounds(100, 336, 182, 20);
		addOrgItem();
		orgSelect.setEnabled(false);
		contentPanel.add(orgSelect);
		
		JLabel JLprgcode = new JLabel("机构编号：");
		JLprgcode.setBounds(25, 396, 60, 20);
		contentPanel.add(JLprgcode);
		
		orgcodeField = new JTextField();
		orgcodeField.setColumns(10);
		orgcodeField.setBounds(100, 396, 182, 20);
		contentPanel.add(orgcodeField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(isagain==false){
							nameField.setEditable(false);
							passwordField.setEditable(false);
							orgcodeField.setEditable(false);
							orgnameField.setEditable(false);
							cityField.setEditable(false);
							jobSelect.setEnabled(false);
							orgSelect.setEnabled(false);
							Job newjob = null;
							switch (jobSelect.getSelectedIndex()) {
							case 0:
								newjob=Job.Courier;
								break;
				            case 1:
				            	newjob=Job.hallsalesman;
								break;
				            case 2:
				            	newjob=Job.transfercentersalesman;
				            	break;
				            case 3:
				            	newjob=Job.CenterDepot;
				            	break;
				            case 4:
				            	newjob=Job.Financial;
				            	break;
				            case 5:
				            	newjob=Job.drivers;
				            	break;
				            case 6:
				            	newjob=Job.manager;
				            	break;
				            case 7:
				            	newjob=Job.administrator;
				            	break;
							default:
								break;
							}
							OrganizationVO organizationVO=parent.getOrgByCode(orgcodeField.getText());
							orgnameField.setText(organizationVO.getName());
							switch (organizationVO.getType()) {
							case hall:
								orgSelect.setSelectedIndex(0);
								break;
							case transfercenter:
								orgSelect.setSelectedIndex(1);
								break;
							case headquarters:
								orgSelect.setSelectedIndex(2);
								break;
							default:
								break;
							}
							cityField.setText(organizationVO.getCity());
							UserVO vo=new UserVO(nameField.getText(), passwordField.getText(), newjob, orgnameField.getText(),
									orgcodeField.getText(),organizationVO.getType(), cityField.getText());
							parent.addUser(vo);
							isagain=true;
						}
						else{
							dispose();
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void addJobItem(){
		jobSelect.addItem("快递员");
		jobSelect.addItem("营业厅业务员");
		jobSelect.addItem("中转中心业务员");
		jobSelect.addItem("仓库管理员");
		jobSelect.addItem("财务人员");
		jobSelect.addItem("司机");
		jobSelect.addItem("总经理");
		jobSelect.addItem("管理员");
	}
	private void addOrgItem(){
		orgSelect.addItem("营业厅");
		orgSelect.addItem("中转中心");
		orgSelect.addItem("总部");
	}

}
