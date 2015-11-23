package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.CLFareVO;
import vo.CenterloadVO;

public interface CenterloadBlService {
	public ResultMessage addCenterLoadForm(CenterloadVO vo)throws RemoteException;
	public double computeCenterLoadFare (CLFareVO vo)throws RemoteException;
	public ResultMessage update(CenterloadVO vo)throws RemoteException;
}
