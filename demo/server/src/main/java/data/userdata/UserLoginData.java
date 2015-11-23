package data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.database.UserDB;
import dataservice.userdataservice.UserLoginDataService;
import po.LoginPO;

public class UserLoginData extends UnicastRemoteObject implements UserLoginDataService {
	public UserLoginData() throws  RemoteException{
		super();
	}
	@Override
	public LoginPO login(long id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		LoginPO po=UserDB.check(id, password);
		return po;
	}

}
