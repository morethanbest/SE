package data.userdata;

import java.rmi.RemoteException;

import data.database.UserDB;
import dataservice.userdataservice.UserLoginDataService;
import po.Job;

public class UserLoginData implements UserLoginDataService {

	@Override
	public Job login(long id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		UserDB db=new UserDB();
		Job job=db.checkforjob(id, password);
		return job;
	}

}
