package data.userdata;

import dataservice.userdataservice.UserDataService;
import po.ResultMessage;
import po.UserPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UsersData extends UnicastRemoteObject implements UserDataService{

	public UsersData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage add(UserPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage delete(UserPO po) throws RemoteException {
		return null;
	}

	@Override
	public UserPO find(long id) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(UserPO po) throws RemoteException {
		return null;
	}
}
