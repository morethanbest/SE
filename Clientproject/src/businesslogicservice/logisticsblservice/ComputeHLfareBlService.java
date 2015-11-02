package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.HLFareVO;

public interface ComputeHLfareBlService {
	public double computeHLfare (HLFareVO vo)throws RemoteException;

}
