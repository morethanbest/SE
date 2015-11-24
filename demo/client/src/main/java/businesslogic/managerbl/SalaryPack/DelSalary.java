package businesslogic.managerbl.SalaryPack;

import dataservice.managerdataservice.SalaryDataService;
import init.RMIHelper;
import po.Job;
import po.ResultMessage;
import po.SalaryMode;
import po.SalaryPO;

import java.rmi.RemoteException;

public class DelSalary {
    Job job;
    SalaryMode salarymode;
    double base;
    double bonus;
    public void setDelInfo(Job job,SalaryMode salarymode,double base,double bonus){
        this.job=job;
        this.salarymode=salarymode;
        this.base=base;
        this.bonus=bonus;
    }

    public ResultMessage delete(){
        SalaryPO po=new SalaryPO(job,salarymode,base,bonus);
        SalaryDataService salary= RMIHelper.getSalarydata();
        ResultMessage result;
        try {
            result = salary.delSalary(po);
        } catch (Exception e) {
            result=ResultMessage.failure;
            System.out.println("deletesalary fail");
        }
        return result;

    }
}
