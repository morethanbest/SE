package businesslogic.managerbl.SalaryPack;

import po.Job;
import po.SalaryMode;
import po.SalaryPO;
import vo.ResultMessage;

public class MockRevSalary extends RevSalary {
	Job job;
	SalaryMode salarymode;
	double base;
	double bonus;
	public void setRevInfo(Job job,SalaryMode salarymode,double base,double bonus){
		this.job=job;
		this.salarymode=salarymode;
		this.base=base;
		this.bonus=bonus;
	}
	
	public ResultMessage rev(){
		SalaryPO po=new SalaryPO(5,job,salarymode,base,bonus);		//以后为从数据层拿，再删去
		long id = po.getId();
		SalaryPO newpo=new SalaryPO(id,job,salarymode,base,bonus);
		ResultMessage result=ResultMessage.success;
		return result;
		
	}
}
