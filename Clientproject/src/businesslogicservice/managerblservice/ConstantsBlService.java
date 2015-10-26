package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.ConstantsVO;

public interface ConstantsBlService {
	public ResultMessage addConstants (ConstantsVO vo)throws RemoteException;
	
	public ResultMessage delConstants(ConstantsVO vo)throws RemoteException;
	
	public ResultMessage revConstants (ConstantsVO vo)throws RemoteException;

}
