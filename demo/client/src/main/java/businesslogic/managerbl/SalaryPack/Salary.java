package businesslogic.managerbl.SalaryPack;

import po.Job;
import po.SalaryMode;
import po.ResultMessage;
import vo.SalaryVO;

public class Salary {
	AddSalary adds;
	DelSalary dels;
    FindSalary finds;
	RevSalary revs;
	
	public Salary(AddSalary adds){
		this.adds=adds;
	}
	
	public Salary(DelSalary dels){

		this.dels=dels;
	}
	
	public Salary(FindSalary finds){

		this.finds=finds;
	}
	
	public Salary(RevSalary revs){

		this.revs=revs;
	}
	
	public ResultMessage addSalary(SalaryVO vo){
		Job job=vo.getJob();
		SalaryMode salarymode=vo.getSalarymode();
		double base=vo.getBase();
		double bonus=vo.getBonus();
		adds.setAddInfo(salarymode,job,base,bonus);
		ResultMessage result=adds.addSalary();
		return result;
		
	}
	
	public ResultMessage delSalary(SalaryVO vo){
		SalaryMode salarymode=vo.getSalarymode();
		double base=vo.getBase();
		double bonus=vo.getBonus();
		Job job=vo.getJob();
		dels.setDelInfo(job,salarymode,base,bonus);
		ResultMessage result=dels.delete();
		return result;
	}
	
	public SalaryVO findSalary(Job job){
		finds.setFindInfo(job);
		SalaryVO vo=finds.findSalary();
		return vo;
	}
	
	public ResultMessage revSalary(SalaryVO vo){
		SalaryMode salarymode=vo.getSalarymode();
		double base=vo.getBase();
		double bonus=vo.getBonus();
		Job job=vo.getJob();
		revs.setRevInfo(job,salarymode,base,bonus);
		ResultMessage result=revs.rev();
		return result;
	}
}
