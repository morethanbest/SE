package businesslogic.userbl.blstub;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.UserBlService;
import vo.ResultMessage;
import vo.UserVO;

public class UserBlService_Stub implements UserBlService {



	@Override
	public ResultMessage addUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage delUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage revUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public UserVO getUserbyID(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return new UserVO(1,"1","1","1");
	}

}
