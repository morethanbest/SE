package businesslogicservice.userblservice;
import java.rmi.RemoteException;

import po.Job;
public interface UserloginBlService {
	
	public Job login(long id,String password)throws RemoteException;

}
