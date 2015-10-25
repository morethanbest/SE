package businesslogicservice.transportblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.DriverVO;


public interface DriverBlService {
	public ResultMessage addDriver (DriverVO vo)throws RemoteException;
	
	public ResultMessage delDriver ()throws RemoteException;
	
	public ResultMessage revDriver (DriverVO vo)throws RemoteException;
	
	public DriverVO getDriverbyDN (long driverNumber)throws RemoteException;
	
	public DriverVO getDriverbyName (String name)throws RemoteException;
	
	
}
