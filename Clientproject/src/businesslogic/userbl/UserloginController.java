package businesslogic.userbl;

import java.rmi.RemoteException;

import vo.ResultMessage;
import businesslogicservice.userblservice.UserloginBlService;

public class UserloginController implements UserloginBlService{

	public UserloginController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage login(long id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
