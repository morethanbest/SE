package businesslogic.managerbl.SalaryPack;

import businesslogicservice.managerblservice.SalaryBlService;
import po.Job;
import po.ResultMessage;
import vo.SalaryVO;

import java.rmi.RemoteException;

/**
 * Created by 超 on 2015/11/24.
 */
public class SalaryController implements SalaryBlService{

    @Override
    public ResultMessage addSalary(SalaryVO vo){
        AddSalary addSalary=new AddSalary();
        Salary salary =new Salary(addSalary);
        ResultMessage result=salary.addSalary(vo);
        return result;

    }

    @Override
    public ResultMessage delSalary(SalaryVO vo){
        DelSalary delSalary=new DelSalary();
        Salary salary =new Salary(delSalary);
        ResultMessage result=salary.delSalary(vo);
        return result;
    }

    @Override
    public ResultMessage revSalary(SalaryVO vo){
        RevSalary revSalary=new RevSalary();
        Salary salary=new Salary(revSalary);
        ResultMessage result=salary.revSalary(vo);
        return result;

    }

    @Override
    public SalaryVO getSalary(Job job){
        FindSalary findSalary=new FindSalary();
        Salary salary=new Salary(findSalary);
        SalaryVO vo=salary.findSalary(job);
        return vo;

    }

}
