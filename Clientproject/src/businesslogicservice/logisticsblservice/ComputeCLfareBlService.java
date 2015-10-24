package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.CLfareFareVO;

public interface ComputeCLfareBlService {
	public double ComputeCLfare (CLfareFareVO vo)throws RemoteException;

}
