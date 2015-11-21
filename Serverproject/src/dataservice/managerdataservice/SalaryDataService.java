package dataservice.managerdataservice;

import java.rmi.RemoteException;

import po.Job;
import po.ResultMessage;
import po.SalaryPO;

public interface SalaryDataService {
	public ResultMessage addSalary (SalaryPO po)throws RemoteException;
	
	public ResultMessage updateSalary (SalaryPO po)throws RemoteException;
	
	public ResultMessage delSalary (SalaryPO po)throws RemoteException;
	
	public SalaryPO  findSalary (Job job)throws RemoteException;
}
