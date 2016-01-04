package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import po.Job;
import po.ResultMessage;
import vo.SalaryVO;

public interface SalaryBlService {
    public ResultMessage addSalary(SalaryVO vo);
	
	public ResultMessage delSalary(SalaryVO vo);
	
	public ResultMessage revSalary(SalaryVO vo);
	
	public SalaryVO getSalary(Job job);

}
