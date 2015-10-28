package dataservice.managerdataservice;

import java.rmi.RemoteException;

import po.SalaryPO;

public interface SalaryDataService {
	public void updateSalary (SalaryPO po)throws RemoteException;
	
	public SalaryPO  findSalary (long id)throws RemoteException;
}
