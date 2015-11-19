package dataservice.transportdataservice;

import java.rmi.RemoteException;

import po.DriversPO;
import vo.ResultMessage;

public interface DriversDataService {
	public ResultMessage insertDriver(DriversPO po)throws RemoteException;
	
	public ResultMessage deleteDriver(DriversPO po)throws RemoteException;
	
	public ResultMessage updateDriver(DriversPO po)throws RemoteException;
	
	public DriversPO findDriver(String identity)throws RemoteException;
}
