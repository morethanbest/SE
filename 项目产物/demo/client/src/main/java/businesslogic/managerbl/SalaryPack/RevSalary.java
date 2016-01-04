package businesslogic.managerbl.SalaryPack;

import dataservice.managerdataservice.SalaryDataService;
import init.RMIHelper;
import po.Job;
import po.ResultMessage;
import po.SalaryMode;
import po.SalaryPO;

import java.rmi.RemoteException;

public class RevSalary {
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
        SalaryDataService salary= RMIHelper.getSalarydata();
        SalaryPO newpo=new SalaryPO(job,salarymode,base,bonus);
        ResultMessage result;
        try {
            result = salary.updateSalary(newpo);
        } catch (Exception e) {
            result=ResultMessage.failure;
            System.out.println("revsalary fail");
        }
        return result;

    }
}
