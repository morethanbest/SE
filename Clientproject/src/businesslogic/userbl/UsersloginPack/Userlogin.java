package businesslogic.userbl.UsersloginPack;

import java.rmi.RemoteException;

import po.Job;

public class Userlogin {
	LoginConfirm con;
	public Userlogin(LoginConfirm con) {
		// TODO Auto-generated constructor stub
		this.con=con;
	}
	
	public Job login(long id, String password) {
		Job job=con.log(id,password);
		return job;
	}

}
