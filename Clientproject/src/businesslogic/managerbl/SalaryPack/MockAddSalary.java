package businesslogic.managerbl.SalaryPack;

import po.Job;
import po.SalaryMode;
import po.SalaryPO;
import vo.ResultMessage;

public class MockAddSalary extends AddSalary {
	long id;
	SalaryMode salarymode;
	Job job;
	double base;
	double bonus;
	public void setAddInfo(long id,SalaryMode salarymode,Job job,double base,double bonus){
		this.id=id;
		this.salarymode=salarymode;
		this.job=job;
		this.base=base;
		this.bonus=bonus;
	}
	public ResultMessage addSalary(){
		SalaryPO po=new SalaryPO(id,job,salarymode,base,bonus);
		ResultMessage result=ResultMessage.success;
		return result;
	}
}
