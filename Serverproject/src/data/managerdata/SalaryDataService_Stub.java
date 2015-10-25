package data.managerdata;

import java.rmi.RemoteException;

import po.Job;
import po.SalaryMode;
import po.SalaryPO;
import dataservice.managerdataservice.SalaryDataService;

public class SalaryDataService_Stub implements SalaryDataService{

	@Override
	public void updateSalary(SalaryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
	}

	@Override
	public SalaryPO findSalary(long id) throws RemoteException {
		// TODO Auto-generated method stub
		SalaryPO po=new SalaryPO(03, Job.drivers, SalaryMode.monthly,5000 , 0);
		return po;
	}

	

}
