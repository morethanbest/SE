package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.CLFareVO;
import vo.ResultMessage; 
import vo.CenterloadVO;

public interface CenterloadBlService {
	public ResultMessage addCenterLoadForm(CenterloadVO vo)throws RemoteException;
	public double ComputeCenterLoadFare (CLFareVO vo)throws RemoteException;
	public ResultMessage update(CenterloadVO vo)throws RemoteException;
}
