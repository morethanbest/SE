package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.ArrivalVO;

public interface ArrivalBlService {
	public ResultMessage addArrival(ArrivalVO vo)throws RemoteException;
	public ResultMessage update(ArrivalVO vo)throws RemoteException;

	public String getDepartureByTrans(String transcode) throws  RemoteException;
	public String getDepartureByLoad(String loadcode) throws RemoteException;

	public String getid(String centercode) throws  RemoteException;

}
