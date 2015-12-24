package presentation.managerui.salary;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import businesslogic.managerbl.SalaryPack.SalaryController;
import businesslogicservice.managerblservice.SalaryBlService;
import po.Job;
import po.ResultMessage;
import po.SalaryMode;
import presentation.tip.DoubleField;
import presentation.tip.TipDialog;
import vo.SalaryVO;

public class AddSalaryDialog extends JDialog {
	
	JLabel job;
	JLabel salarymode;
	JLabel base; 
	JLabel bonus;
	DoubleField basetext;
	DoubleField bonustext;
	
	JComboBox<String> jobSelect;
	JComboBox<String> modeSelect;
	
	JButton addBtn;
	JButton cancelBtn;
	public AddSalaryDialog(SalaryPanel parent) {
		// TODO Auto-generated constructor stub
		setBounds(100, 100, 450, 350);
		getContentPane().setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		job =new JLabel();
		job.setText("职业");
		job.setBounds(90, 50, 90, 21);
		add(job);
		
		
		
		
		jobSelect = new JComboBox<String>();
		jobSelect.setBounds(180, 50, 180, 21);
		jobSelect.setEditable(false);
		jobSelect.setEnabled(true);
		add(jobSelect);
		addjobItem();
		
		salarymode = new JLabel();
		salarymode.setText("薪水策略");
		salarymode.setBounds(90, 100, 90, 21);
		add(salarymode);
	
		modeSelect = new JComboBox<String>();
		modeSelect.setBounds(180, 100, 180, 21);
		modeSelect.setEditable(false);
		modeSelect.setEnabled(true);
		add(modeSelect);
		addmodeItem();
		modeSelect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(modeSelect.getSelectedIndex()!=0){
					bonustext.setEditable(false);
					bonustext.setText("0");
				}else{
					bonustext.setEditable(true);
				}
			}
		});
		
		base =new JLabel();
		base.setText("底薪");
		base.setBounds(90, 150, 90, 21);
		add(base);
		
		basetext = new DoubleField(50);
		basetext.setBounds(180, 150, 180, 21);
		basetext.setEditable(true);
		add(basetext);
		
		bonus =new JLabel();
		bonus.setText("提成（计次）");
		bonus.setBounds(90, 200, 90, 21);
		add(bonus);
		
		bonustext = new DoubleField(50);
		bonustext.setBounds(180, 200, 180, 21);
		bonustext.setEditable(true);
		add(bonustext);
		
		addBtn = new JButton();
		addBtn.setText("确定");
		addBtn.setBounds(100, 250, 100, 21);
		add(addBtn);
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(basetext.getText().equals("")){
					TipDialog dialog=new TipDialog("请输入底薪!");
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}else if(bonustext.getText().equals("")){
					TipDialog dialog=new TipDialog("请输入提成!");
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}else{
					SalaryBlService salaryBlService=new SalaryController();
					SalaryVO vo =new SalaryVO(getjobSelect(), getmodeSelect(), Double.parseDouble(basetext.getText()), Double.parseDouble(bonustext.getText()));
					ResultMessage resultMessage=salaryBlService.addSalary(vo);
					if(resultMessage==ResultMessage.failure){
						TipDialog dialog=new TipDialog("该薪水策略已存在!");
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}
					else{
						dispose();
					}
					parent.refreshList();
					
				}
				
			}
		});
		
		cancelBtn = new JButton();
		cancelBtn.setText("取消");
		cancelBtn.setBounds(250, 250, 100, 21);
		add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		
	}
	private Job getjobSelect(){
		String string=(String)jobSelect.getSelectedItem();
		switch (string) {
		case "快递员":
			return Job.Courier;
		case "营业厅业务员":
			return Job.hallsalesman ;
		case "中转中心业务员":
			return Job.transfercentersalesman;
		case "中转中心库存管理人员":
			return Job.CenterDepot;
		case "财务人员":
			return Job.Financial;
		case "高级财务人员":
			return Job.advanceFinancial;
		case "司机":
			return Job.drivers;
		case "管理员":
			return Job.administrator;
		case "总经理":
			return Job.manager;
		default:
			return null;
		}
	}
	
	private SalaryMode getmodeSelect(){
		String string=(String)modeSelect.getSelectedItem();
		switch (string) {
		case "计次":
			return SalaryMode.chargebytimes;
		case "月薪":
			return SalaryMode.monthly;
		case "提成":
			return SalaryMode.deduct;
		default:
			return null;
		}
	}
	
	private void addjobItem(){
		Job[] jobs=Job.values();
		for(int i=0;i<jobs.length;i++){
			jobSelect.addItem(jobs[i].getName());
		}
	}
	
	private void addmodeItem(){
		SalaryMode[] modes=SalaryMode.values();
		for(int i=0;i<modes.length;i++){
			modeSelect.addItem(modes[i].getName());
		}
	}
	
	

}
