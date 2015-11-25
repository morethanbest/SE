package businesslogicservice.transportblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ResultMessage;
import vo.DriverVO;


public interface DriverBlService {
	public ResultMessage addDriver (DriverVO vo)throws RemoteException;
	
	public ResultMessage delDriver (DriverVO vo)throws RemoteException;
	
	public ResultMessage revDriver (DriverVO vo)throws RemoteException;
	
	public DriverVO getDriverbyDN (String driverNumber)throws RemoteException;
	
	public List<DriverVO> getDriverbyName (String name)throws RemoteException;

	public long getid() throws RemoteException;

	
	
}
