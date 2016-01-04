package businesslogicservice.userblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.UserVO;

public interface Inline {
	public ResultMessage addNew() throws RemoteException;

}
