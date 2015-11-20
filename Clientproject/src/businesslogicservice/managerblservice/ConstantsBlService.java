package businesslogicservice.managerblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ConstantsPO;
import vo.ConstantsVO;
import vo.ResultMessage;

public interface ConstantsBlService {
	public ResultMessage addConstants (ConstantsVO vo)throws RemoteException;
	
	public ResultMessage delConstants(ConstantsVO vo)throws RemoteException;
	
	public List<ConstantsVO> getConstants(String name)throws RemoteException;
	//更新数据，通过原名查找，再将vo覆盖上
	public ResultMessage revConstants (String originalname,ConstantsVO vo)throws RemoteException;


}
