package businesslogic.userbl.UsersPack;


import businesslogicservice.userblservice.UserBlService;
import po.ResultMessage;
import vo.UserVO;

public class UserController implements UserBlService{



	@Override
	public ResultMessage addUser(UserVO vo){
		// TODO Auto-generated method stub
		AddUser add=new AddUser();
		User user=new User(add);
		ResultMessage result=user.addUser(vo);
		return result;
		}



	@Override
	public UserVO getUserbyName(String username){
		// TODO Auto-generated method stub
		FindUser find=new FindUser();
		User user=new User(find);
		UserVO gotvo=user.getUserbyName(username);
		return gotvo;
	}

	
	
	@Override
	public ResultMessage delUser(UserVO vo){
		// TODO Auto-generated method stub
		DelUser del=new DelUser();
		User user=new User(del);
		ResultMessage result=user.delUser(vo);
		return result;
	}

	
	
	@Override
	public ResultMessage revUser(UserVO vo){
		// TODO Auto-generated method stub
		RevUser rev=new RevUser();
		User user=new User(rev);
		ResultMessage result=user.revUser(vo);
		return result;
	}

}
