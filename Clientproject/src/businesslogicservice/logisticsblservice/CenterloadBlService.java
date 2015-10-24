package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.CenterloadVO;

public interface CenterloadBlService {
	public ResultMessage addCenterLoadForm(CenterloadVO vo)throws RemoteException;

}
