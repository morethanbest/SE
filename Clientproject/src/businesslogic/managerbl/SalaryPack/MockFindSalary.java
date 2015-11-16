package businesslogic.managerbl.SalaryPack;

import po.Job;
import po.SalaryMode;
import po.SalaryPO;
import vo.SalaryVO;

public class MockFindSalary extends FindSalary {
	Job job;
	
	public void setFindInfo(Job job){
		this.job=job;
	}
	public SalaryVO findSalary(){
		SalaryPO po=new SalaryPO(5,job,SalaryMode.chargebytimes,1,1);		//以后为从数据层拿
		Job job=po.getJob();
		SalaryMode salarymode=po.getSalarymode();
		double base=po.getBase();
		double bonus=po.getBonus();
		SalaryVO vo=new SalaryVO(job,salarymode,base,bonus);
		return vo;
	}
}
