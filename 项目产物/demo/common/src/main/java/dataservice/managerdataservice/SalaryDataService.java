package dataservice.managerdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.Job;
import po.ResultMessage;
import po.SalaryPO;

public interface SalaryDataService extends Remote {
	public ResultMessage addSalary (SalaryPO po)throws RemoteException;
	
	public ResultMessage updateSalary (SalaryPO po)throws RemoteException;
	
	public ResultMessage delSalary (SalaryPO po)throws RemoteException;
	
	public SalaryPO  findSalary (Job job)throws RemoteException;
}
