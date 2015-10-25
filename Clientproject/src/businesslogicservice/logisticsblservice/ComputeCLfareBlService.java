package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.CLFareVO;

public interface ComputeCLfareBlService {
	public double ComputeCLfare (CLFareVO vo)throws RemoteException;

}
