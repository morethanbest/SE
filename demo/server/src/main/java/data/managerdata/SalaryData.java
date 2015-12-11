package data.managerdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.database.managerDB.SalaryDB;
import dataservice.managerdataservice.SalaryDataService;
import po.Job;
import po.ResultMessage;
import po.SalaryPO;

public class SalaryData extends UnicastRemoteObject implements SalaryDataService {
	public SalaryData() throws RemoteException
	{
		super();
	}
	@Override
	public ResultMessage addSalary(SalaryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return SalaryDB.write(po.getJob(), po.getSalarymode(), po.getBase(), po.getBonus());
		else
			return ResultMessage.failure;
	}

	@Override
	public ResultMessage updateSalary(SalaryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return SalaryDB.update(po.getJob(), po.getSalarymode(), po.getBase(), po.getBonus());
		else
			return ResultMessage.failure;
		
	}

	@Override
	public ResultMessage delSalary(SalaryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return SalaryDB.delete(po.getJob());
		else
			return ResultMessage.failure;
		
	}

	@Override
	public SalaryPO findSalary(Job job) throws RemoteException {
		// TODO Auto-generated method stub
		return SalaryDB.search(job);
	}

}
