package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.ArrivalVO;

public interface ArrivalBlService {
	public ResultMessage addArrival(ArrivalVO vo)throws RemoteException;
	public ResultMessage update(ArrivalVO vo)throws RemoteException;

}
