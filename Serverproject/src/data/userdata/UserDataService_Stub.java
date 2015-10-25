package data.userdata;

import java.rmi.RemoteException;

import po.UserPO;
import dataservice.userdataservice.UserDataService;

public class UserDataService_Stub implements UserDataService{

	@Override
	public void add(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
	}

	@Override
	public void delete(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
	}

	@Override
	public UserPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO po=new UserPO(01532, "ÕÅÏþ", 552530, Level.High);
		return null;
	}

	@Override
	public void update(UserPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
	}


}
