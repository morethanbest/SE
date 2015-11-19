package data.userdata;

import java.rmi.RemoteException;

import data.database.UserDB;
import dataservice.userdataservice.UserLoginDataService;
import vo.ResultMessage;

public class UserLoginData implements UserLoginDataService {

	@Override
	public ResultMessage login(String username, String password) throws RemoteException {
		// TODO Auto-generated method stub
		UserDB db=new UserDB();
		ResultMessage result=db.check(username, password);
		return result;
	}

}
