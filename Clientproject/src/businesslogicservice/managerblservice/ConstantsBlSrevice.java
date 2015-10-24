package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.ConstantsVO;

public interface ConstantsBlSrevice {
	public ResultMessage addContants (ConstantsVO vo)throws RemoteException;
	
	public ResultMessage delContants()throws RemoteException;
	
	public ResultMessage revContants (ConstantsVO vo)throws RemoteException;

}
