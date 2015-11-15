package businesslogicservice.userblservice;
import java.rmi.RemoteException;

import vo.ResultMessage;
public interface UserloginBlService {
	
	public ResultMessage login(long id,String password)throws RemoteException;

}
