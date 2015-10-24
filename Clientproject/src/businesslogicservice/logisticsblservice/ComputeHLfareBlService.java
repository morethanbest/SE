package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.HLfareFareVO;

public interface ComputeHLfareBlService {
	public double ComputeHLfare (HLfareFareVO vo)throws RemoteException;

}
