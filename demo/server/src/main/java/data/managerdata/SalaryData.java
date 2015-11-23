package data.managerdata;

import dataservice.managerdataservice.SalaryDataService;
import po.Job;
import po.ResultMessage;
import po.SalaryPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SalaryData extends UnicastRemoteObject implements SalaryDataService{

	public SalaryData() throws RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage addSalary(SalaryPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateSalary(SalaryPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage delSalary(SalaryPO po) throws RemoteException {
		return null;
	}

	@Override
	public SalaryPO findSalary(Job job) throws RemoteException {
		return null;
	}
}
