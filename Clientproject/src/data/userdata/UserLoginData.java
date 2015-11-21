package data.userdata;

import java.rmi.RemoteException;

import data.database.UserDB;
import dataservice.userdataservice.UserLoginDataService;
import po.LoginPO;

public class UserLoginData implements UserLoginDataService {

	@Override
	public LoginPO login(long id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		LoginPO po=UserDB.check(id, password);
		return po;
	}

}
