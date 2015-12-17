package presentation.managerui.staff;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businesslogic.managerbl.OrganizationPack.OrganizationController;
import businesslogic.managerbl.StaffPack.Staff;
import businesslogic.managerbl.StaffPack.StaffController;
import businesslogicservice.managerblservice.OrganizationBlService;
import businesslogicservice.managerblservice.StaffBlService;
import po.Job;
import po.ResultMessage;
import presentation.tip.NumberField;
import presentation.tip.TipDialog;
import vo.OrganizationVO;
import vo.StaffVO;
import vo.UserVO;

import javax.swing.JLabel;

public class AddStaffDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nameField;
	private NumberField orgcodeField;
	private JTextField orgnameField;
	private JTextField cityField;
	private JComboBox<String> jobSelect;
	private JComboBox<String> orgSelect;
	private boolean isagain=false;	
	/**
	 * Create the dialog.
	 */
	public AddStaffDialog(final StaffManagePanel parent) {
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel JLname = new JLabel("姓名：");
		JLname.setBounds(25, 36, 60, 20);
		contentPanel.add(JLname);
		
		nameField = new JTextField();
		nameField.setBounds(100, 36, 182, 20);
		contentPanel.add(nameField);
		nameField.setColumns(10);
		
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
		JLorgtype.setBounds(25, 336, 80, 20);
		contentPanel.add(JLorgtype);
		
		orgSelect = new JComboBox<String >();
		orgSelect.setBounds(100, 336, 182, 20);
		addOrgItem();
		orgSelect.setEnabled(false);
		contentPanel.add(orgSelect);
		
		JLabel JLprgcode = new JLabel("机构编号：");
		JLprgcode.setBounds(25, 396, 80, 20);
		contentPanel.add(JLprgcode);
		
		orgcodeField = new NumberField(20);
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
						StaffBlService staffBlService=new StaffController();
						OrganizationBlService organizationBlService = new OrganizationController();
						if(isagain==false){
							
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
				            	newjob=Job.advanceFinancial;
				            	break;
				            case 6:
				            	newjob=Job.drivers;
				            	break;
				            case 7:
				            	newjob=Job.manager;
				            	break;
				            case 8:
				            	newjob=Job.administrator;
				            	break;
							default:
								break;
							}
							OrganizationVO organizationVO=organizationBlService.findOrgByCode(orgcodeField.getText());
							if(organizationVO==null){
								TipDialog Dialog=new TipDialog("请输入正确的组织编号！");
								Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								Dialog.setVisible(true);
							}
							else if(nameField.getText().equals("")){
								TipDialog Dialog=new TipDialog("请输入姓名！");
								Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								Dialog.setVisible(true);
							}
							else{
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
								StaffVO vo=new StaffVO(staffBlService.getid(), nameField.getText(), newjob, orgnameField.getText(), 
										orgcodeField.getText(), organizationVO.getType(), cityField.getText());
								ResultMessage resultMessage=staffBlService.addStaff(vo);
								if(resultMessage==ResultMessage.failure){
									TipDialog Dialog=new TipDialog("增加员工失败！");
									Dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
									Dialog.setVisible(true);
								}
								else {
									isagain=true;
									nameField.setEditable(false);
									orgcodeField.setEditable(false);
									orgnameField.setEditable(false);
									cityField.setEditable(false);
									jobSelect.setEnabled(false);
									orgSelect.setEnabled(false);
								}
								
							}
						}
						else{
							parent.refreshList();
							dispose();
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	private void addJobItem(){
		jobSelect.addItem("快递员");
		jobSelect.addItem("营业厅业务员");
		jobSelect.addItem("中转中心业务员");
		jobSelect.addItem("中转中心库存管理人员");
		jobSelect.addItem("财务人员");
		jobSelect.addItem("高级财务人员");
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
