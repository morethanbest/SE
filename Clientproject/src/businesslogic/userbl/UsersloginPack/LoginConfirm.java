package businesslogic.userbl.UsersloginPack;

import java.rmi.RemoteException;

import data.datafactory.databaseFactory;
import data.userdata.UserLoginData;
import po.Job;

public class LoginConfirm {

	public Job log(long id, String password){
		databaseFactory fac=new databaseFactory();
		UserLoginData userdata=fac.getUserLogin();
		Job job=Job.visitor;
		try {
			job=userdata.login(id,password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("RemoteException!!");
			e.printStackTrace();
		}
		return job;
	}

}
