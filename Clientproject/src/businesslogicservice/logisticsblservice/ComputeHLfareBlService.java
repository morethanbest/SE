package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.HLFareVO;

public interface ComputeHLfareBlService {
	public double ComputeHLfare (HLFareVO vo)throws RemoteException;

}
