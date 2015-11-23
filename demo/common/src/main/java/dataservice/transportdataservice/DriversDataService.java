package dataservice.transportdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.DriversPO;
import po.ResultMessage;

public interface DriversDataService extends Remote {
	public ResultMessage insertDriver(DriversPO po)throws RemoteException;
	
	public ResultMessage deleteDriver(DriversPO po)throws RemoteException;
	
	public ResultMessage updateDriver(DriversPO po)throws RemoteException;
	
	public DriversPO findDriver(String identity)throws RemoteException;
}
