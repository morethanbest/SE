package data.balancedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.balancedataservice.BalanceDataService;

public class BalanceData extends UnicastRemoteObject implements BalanceDataService {
	
	public BalanceData() throws RemoteException {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public double allin() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double allout() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
