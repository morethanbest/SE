package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.ArrivalVO;

public interface ArrivalBlService {
	public ResultMessage addArrivalFromHall(ArrivalVO vo,String orgname)throws RemoteException;
	
	public ResultMessage addArrivalFromCenter(ArrivalVO vo,String orgname)throws  RemoteException;
	
	public ResultMessage update(ArrivalVO vo)throws RemoteException;

	public long  getid() throws  RemoteException;

}
