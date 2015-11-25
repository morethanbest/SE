package data.userdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.database.userDB.UserDB;
import dataservice.userdataservice.UserLoginDataService;
import po.UserPO;

public class UserLoginData extends UnicastRemoteObject implements UserLoginDataService {
	public UserLoginData() throws  RemoteException{
		super();
	}
	@Override
	public UserPO login(long id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return UserDB.check(id, password);
	}

}
