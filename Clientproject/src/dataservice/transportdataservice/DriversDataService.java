package dataservice.transportdataservice;

import java.rmi.RemoteException;

import po.DriversPO;

public interface DriversDataService {
	public void insertDriver(DriversPO po)throws RemoteException;
	
	public void deleteDriver(DriversPO po)throws RemoteException;
	
	public void updateDriver(DriversPO po)throws RemoteException;
	
	public DriversPO findDriver(long identity)throws RemoteException;
}
