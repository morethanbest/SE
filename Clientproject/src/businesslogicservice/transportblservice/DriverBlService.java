package businesslogicservice.transportblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.DriverVO;


public interface DriverBlService {
	public ResultMessage addDriver (DriverVO vo)throws RemoteException;
	
	public ResultMessage delDriver (DriverVO vo)throws RemoteException;
	
	public ResultMessage revDriver (DriverVO vo)throws RemoteException;
	
	public DriverVO getDriverbyDN (String driverNumber)throws RemoteException;
	
	public DriverVO getDriverbyName (String name)throws RemoteException;
	
	
}
