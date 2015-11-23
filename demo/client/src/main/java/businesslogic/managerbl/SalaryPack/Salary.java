package businesslogic.managerbl.SalaryPack;

import po.Job;
import po.SalaryMode;
import vo.ResultMessage;
import vo.SalaryVO;

public class Salary {
	MockAddSalary adds;
	MockDelSalary dels;
	MockFindSalary finds;
	MockRevSalary revs;
	MockIdInfo id;
	
	public Salary(MockAddSalary adds,MockIdInfo id){
		this.adds=adds;
		this.id=id;
	}
	
	public Salary(MockDelSalary dels){
		this.dels=dels;
	}
	
	public Salary(MockFindSalary finds){
		this.finds=finds;
	}
	
	public Salary(MockRevSalary revs){
		this.revs=revs;
		
	}
	
	public ResultMessage addSalary(SalaryVO vo){
		Job job=vo.getJob();
		SalaryMode salarymode=vo.getSalarymode();
		double base=vo.getBase();
		double bonus=vo.getBonus();
		long id=this.id.getid();
		adds.setAddInfo(id,salarymode,job,base,bonus);
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
