package businesslogic.userbl.UsersloginPack;



import java.rmi.RemoteException;

import po.Job;
import businesslogicservice.userblservice.UserloginBlService;

public class UserloginController implements UserloginBlService{



	@Override
	public Job login(long id, String password) {
		LoginConfirm con=new LoginConfirm();
		Userlogin login=new Userlogin(con);
		Job job=login.login(id,password);
		return job;
	}
}
