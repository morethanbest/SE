package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.SalaryVO;

public interface SalaryBlService {
	public ResultMessage salary(SalaryVO vo)throws RemoteException;

}
