package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.ArrivalVO;

public interface ArrivalBlService {
	public ResultMessage addArrivalFromHall(ArrivalVO vo,String orgcode)throws RemoteException;
	public ResultMessage addArrivalFromCenter(ArrivalVO vo,String orgcode)throws  RemoteException;
	public ResultMessage update(ArrivalVO vo)throws RemoteException;

	public String getDepartureByTrans(String transcode) throws  RemoteException;
	public String getDepartureByLoad(String loadcode) throws RemoteException;

	public long  getid(String centercode) throws  RemoteException;

}
