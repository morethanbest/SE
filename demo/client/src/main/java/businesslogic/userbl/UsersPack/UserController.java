package businesslogic.userbl.UsersPack;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.UserVO;
import businesslogicservice.userblservice.UserBlService;

public class UserController implements UserBlService{



	@Override
	public ResultMessage addUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		IdInfo id=new IdInfo();
		AddUser add=new AddUser();
		User user=new User(add,id);
		ResultMessage result=user.addUser(vo);
		return result;
		}



	@Override
	public UserVO getUserbyID(long id) throws RemoteException {
		// TODO Auto-generated method stub
		
		FindUser find=new FindUser();
		User user=new User(find);
		UserVO gotvo=user.getUserbyID(id);
		
		return gotvo;
	}

	
	
	@Override
	public ResultMessage delUser(UserVO vo, long id) throws RemoteException {
		// TODO Auto-generated method stub
		DelUser del=new DelUser();
		User user=new User(del);
		ResultMessage result=user.delUser(vo, id);
		return result;
	}

	
	
	@Override
	public ResultMessage revUser(UserVO vo, long id) throws RemoteException {
		// TODO Auto-generated method stub
		RevUser rev=new RevUser();
		User user=new User(rev);
		ResultMessage result=user.revUser(vo, id);
		return result;
	}

}
