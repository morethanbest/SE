package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import po.ConstantsPO;
import vo.ConstantsVO;
import vo.ResultMessage;

public interface ConstantsBlService {
	public ResultMessage addConstants (ConstantsVO vo)throws RemoteException;
	
	public ResultMessage delConstants(ConstantsVO vo)throws RemoteException;
	
	public ConstantsVO getConstants(String name)throws RemoteException;
	
	public ResultMessage revConstants (ConstantsVO vo)throws RemoteException;

}
