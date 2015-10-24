package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.ArrivalVO;

public interface ArrivalBlService {
	public ResultMessage Arrival(ArrivalVO vo)throws RemoteException;

}
