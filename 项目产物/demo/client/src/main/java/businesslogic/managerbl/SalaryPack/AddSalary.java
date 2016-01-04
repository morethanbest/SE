package businesslogic.managerbl.SalaryPack;

import dataservice.managerdataservice.SalaryDataService;
import init.RMIHelper;
import po.Job;
import po.ResultMessage;
import po.SalaryMode;
import po.SalaryPO;

import java.rmi.RemoteException;

public class AddSalary {
    SalaryMode salarymode;
    Job job;
    double base;
    double bonus;
    public void setAddInfo(SalaryMode salarymode,Job job,double base,double bonus){
        this.salarymode=salarymode;
        this.job=job;
        this.base=base;
        this.bonus=bonus;
    }
    public ResultMessage addSalary(){
        SalaryPO po=new SalaryPO(job, salarymode,  base,  bonus);
        SalaryDataService salary= RMIHelper.getSalarydata();
        ResultMessage result;
        try {
            result = salary.addSalary(po);
        } catch (Exception e) {
            result = ResultMessage.failure;
            System.out.println("add salary fail");
        }
        return result;
    }
}
