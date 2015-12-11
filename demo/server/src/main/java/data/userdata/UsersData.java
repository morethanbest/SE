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
		if(po!=null)
			return UserDB.write(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public ResultMessage delete(UserPO po) throws RemoteException {
		if(po!=null)
			return UserDB.deletebyusername(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public UserPO find(String username) throws RemoteException {
		return UserDB.find(username);
	}

	@Override
	public ResultMessage update(UserPO po) throws RemoteException {
		if(po!=null)
			return UserDB.update(po);
		else 
			return ResultMessage.failure;
		
	}

	@Override
	public OrganizationPO getOrganization(String organizationcode) throws RemoteException {
		// TODO Auto-generated method stub
		return OrganizationDB.search(organizationcode);
	}
}
