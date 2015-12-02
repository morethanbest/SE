package businesslogicservice.transportblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ResultMessage;
import vo.DriverVO;


public interface DriverBlService {
	public ResultMessage addDriver (DriverVO vo)throws RemoteException;
	
	public ResultMessage delDriver (DriverVO vo)throws RemoteException;
	
	public ResultMessage revDriver (DriverVO vo)throws RemoteException;
	
	public DriverVO getDriverbyDN (String driverNumber,String orgcode)throws RemoteException;
	
	public List<DriverVO> getDriverbyName (String name,String orgcode)throws RemoteException;
	//得到 司机的编号  形式为  6位的营业厅编号 加上了三位的数字
	public String getid(String orgcode) throws RemoteException;



	
	
}
