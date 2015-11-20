package businesslogic.userbl.UsersloginPack;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.UserloginBlService;
import po.Job;

public class UserloginController implements UserloginBlService{



	@Override
	public Job login(long id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		LoginConfirm con=new LoginConfirm();
		Userlogin login=new Userlogin(con);
		Job job=login.login(id,password);
		return job;
		
		
		
		
		
		
		
	}

}
