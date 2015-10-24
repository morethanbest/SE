package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.HallLoadVO;

public interface HallLoadBlService {
	public ResultMessage addHallLoadForm (HallLoadVO vo)throws RemoteException;

}
