package presentation.managerui.salary;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;

import businesslogic.managerbl.SalaryPack.SalaryController;
import businesslogicservice.managerblservice.SalaryBlService;
import po.Job;
import po.ResultMessage;
import po.SalaryMode;
import presentation.mycomp.MyButton_LightBlue;
import presentation.mycomp.mycombobox.MyComboBox;
import presentation.tip.DoubleField;
import presentation.tip.TipDialog;
import vo.SalaryVO;

public class RevSalaryDialog extends JDialog {
	
	JLabel joblabel;
	JLabel salarymode;
	JLabel base; 
	JLabel bonus;
	DoubleField basetext;
	DoubleField bonustext;
	
	MyComboBox<String> jobSelect;
	MyComboBox<String> modeSelect;
	
	MyButton_LightBlue addBtn;
	MyButton_LightBlue cancelBtn;
	
	private SalaryVO vo;
	public RevSalaryDialog(SalaryPanel parent,Job job) {
		// TODO Auto-generated constructor stub
		SalaryBlService salaryBlService=new SalaryController();
		vo=salaryBlService.getSalary(job);
		
		setBounds(100, 100, 450, 350);
		getContentPane().setLayout(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		
		joblabel =new JLabel();
		joblabel.setText("职业");
		joblabel.setBounds(90, 50, 90, 21);
		add(joblabel);
		
		jobSelect = new MyComboBox<String>();
		jobSelect.setBounds(180, 50, 180, 21);
		jobSelect.setEditable(false);
		add(jobSelect);
		addjobItem();
		jobSelect.setSelectedItem(job.getName());
		jobSelect.setEnabled(false);
		
		salarymode = new JLabel();
		salarymode.setText("薪水策略");
		salarymode.setBounds(90, 100, 90, 21);
		add(salarymode);
	
		modeSelect = new MyComboBox<String>();
		modeSelect.setBounds(180, 100, 180, 21);
		modeSelect.setEditable(false);
		add(modeSelect);
		addmodeItem();
		modeSelect.setSelectedItem(vo.getSalarymode().getName());
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
		basetext.setText(Double.toString(vo.getBase()));
		
		bonus =new JLabel();
		bonus.setText("提成（计次）");
		bonus.setBounds(90, 200, 90, 21);
		add(bonus);
		
		bonustext = new DoubleField(50);
		bonustext.setBounds(180, 200, 180, 21);
		bonustext.setEditable(true);
		add(bonustext);
		bonustext.setText(Double.toString(vo.getBonus()));
		if(modeSelect.getSelectedIndex()!=0){
			bonustext.setEditable(false);
		}else{
			bonustext.setEditable(true);
		}
		
		addBtn = new MyButton_LightBlue("");
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
					ResultMessage resultMessage=salaryBlService.revSalary(vo);
					if(resultMessage==ResultMessage.failure){
						TipDialog dialog=new TipDialog("该薪水策略修改失败!");
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
		
		cancelBtn = new MyButton_LightBlue("");
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
