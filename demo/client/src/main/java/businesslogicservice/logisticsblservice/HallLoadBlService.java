package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.HLFareVO;
import vo.HallLoadVO;

public interface HallLoadBlService {
	public ResultMessage addHallLoadForm (HallLoadVO vo)throws RemoteException;
	public double computeHallLoadFare (HLFareVO vo)throws RemoteException;
	public ResultMessage update(HallLoadVO vo)throws RemoteException;
}
