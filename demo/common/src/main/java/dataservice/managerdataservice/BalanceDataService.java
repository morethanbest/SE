package dataservice.managerdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BalanceDataService extends Remote {
	public double allin()throws RemoteException;
	
	public double allout()throws RemoteException;
}
