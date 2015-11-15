package businesslogic.userbl;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.UserVO;
import businesslogicservice.userblservice.UserBlService;

public class UserController implements UserBlService{

	public UserController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage addUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage revUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO getUserbyID(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
