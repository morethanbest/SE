package businesslogic.managerbl.SalaryPack;

import dataservice.managerdataservice.SalaryDataService;
import init.RMIHelper;
import po.Job;
import po.SalaryMode;
import po.SalaryPO;
import vo.SalaryVO;

import java.rmi.RemoteException;

public class FindSalary {
    Job job;

    public void setFindInfo(Job job){
        this.job=job;
    }
    public SalaryVO findSalary(){
        SalaryDataService salary= RMIHelper.getSalarydata();
        SalaryPO po;
        SalaryVO vo;
        try {
            po = salary.findSalary(job);
            Job job=po.getJob();
            SalaryMode salarymode=po.getSalarymode();
            double base=po.getBase();
            double bonus=po.getBonus();
            vo=new SalaryVO(job,salarymode,base,bonus);
        } catch (Exception e) {
            vo=null;
            System.out.println("findsalary fail");
        }
        
        return vo;
    }
}
