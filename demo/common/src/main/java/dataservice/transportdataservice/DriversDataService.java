package dataservice.transportdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.DriversPO;
import po.ResultMessage;

public interface DriversDataService extends Remote {
	public ResultMessage insertDriver(DriversPO po)throws RemoteException;
	
	public ResultMessage deleteDriver(DriversPO po)throws RemoteException;
	
	public ResultMessage updateDriver(DriversPO po)throws RemoteException;
	
	public DriversPO findDriverBynum(String identity)throws RemoteException;

	public List<DriversPO> findDriverByname(String identity)throws RemoteException;

	public long getCurrentID() throws RemoteException;
}
