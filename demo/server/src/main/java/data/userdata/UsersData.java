package data.userdata;

import dataservice.userdataservice.UserDataService;
import po.OrganizationPO;
import po.ResultMessage;
import po.UserPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.database.managerDB.OrganizationDB;
import data.database.userDB.UserDB;

public class UsersData extends UnicastRemoteObject implements UserDataService{

	public UsersData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage add(UserPO po) throws RemoteException {
		return UserDB.write(po);
	}

	@Override
	public ResultMessage delete(UserPO po) throws RemoteException {
		return UserDB.deletebyusername(po);
	}

	@Override
	public UserPO find(String username) throws RemoteException {
		return UserDB.find(username);
	}

	@Override
	public ResultMessage update(UserPO po) throws RemoteException {
		return UserDB.update(po);
	}

	@Override
	public OrganizationPO getOrganization(String organizationcode) throws RemoteException {
		// TODO Auto-generated method stub
		return OrganizationDB.search(organizationcode);
	}
}
