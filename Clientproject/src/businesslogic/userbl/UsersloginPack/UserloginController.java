package businesslogic.userbl.UsersloginPack;

import java.rmi.RemoteException;

import vo.ResultMessage;
import businesslogicservice.userblservice.UserloginBlService;

public class UserloginController implements UserloginBlService{



	@Override
	public ResultMessage login(long id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		LoginConfirm con=new LoginConfirm();
		Userlogin login=new Userlogin(con);
		ResultMessage result=login.login(id,password);
		return result;
		
		
		
		
		
		
		
	}

}
