package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.SalaryVO;

public interface SalaryBlSrevice {
	public ResultMessage salary(SalaryVO vo)throws RemoteException;

}
