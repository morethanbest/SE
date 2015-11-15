package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.HLFareVO;
import vo.ResultMessage; 
import vo.HallLoadVO;

public interface HallLoadBlService {
	public ResultMessage addHallLoadForm (HallLoadVO vo)throws RemoteException;
	public double computeHallLoadFare (HLFareVO vo)throws RemoteException;
	public ResultMessage update(HallLoadVO vo)throws RemoteException;
}
