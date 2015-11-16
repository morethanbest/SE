package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import po.Job;
import vo.ResultMessage;
import vo.SalaryVO;
import vo.StaffVO;

public interface SalaryBlService {
public ResultMessage addSalary(SalaryVO vo)throws RemoteException;
	
	public ResultMessage delSalary(SalaryVO vo)throws RemoteException;
	
	public ResultMessage revSalary(SalaryVO vo)throws RemoteException;
	
	public StaffVO getSalary(Job job)throws RemoteException;

}
