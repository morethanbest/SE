package businesslogic.userbl.UsersPack;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.UserVO;
import businesslogic.transportbl.DriverPack.DelDriverMock;
import businesslogic.userbl.UsersPack.AddUserMock;
import businesslogic.userbl.UsersPack.IdInfoMock;
import businesslogic.userbl.UsersPack.User;
import businesslogicservice.userblservice.UserBlService;

public class UserController implements UserBlService{



	@Override
	public ResultMessage addUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		IdInfoMock idgetter=new IdInfoMock(666);
		AddUserMock add=new AddUserMock();
		User user=new User(add,idgetter);
		ResultMessage result=user.addUser(vo);
		return result;
		}



	@Override
	public UserVO getUserbyID(long id) throws RemoteException {
		// TODO Auto-generated method stub
		UserVO vo=new UserVO(id,"1","1","1");
		FindUserMock find=new FindUserMock(vo);
		User user=new User(find);
		UserVO gotvo=user.getUserbyID(id);
		
		return gotvo;
	}

	
	
	@Override
	public ResultMessage delUser(UserVO vo, long id) throws RemoteException {
		// TODO Auto-generated method stub
		DelUserMock del=new DelUserMock();
		User user=new User(del);
		ResultMessage result=user.delUser(vo, id);
		return result;
	}

	
	
	@Override
	public ResultMessage revUser(UserVO vo, long id) throws RemoteException {
		// TODO Auto-generated method stub
		RevUserMock rev=new RevUserMock();
		User user=new User(rev);
		ResultMessage result=user.revUser(vo, id);
		return result;
	}

}
