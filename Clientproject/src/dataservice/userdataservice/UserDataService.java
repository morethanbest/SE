package dataservice.userdataservice;

import java.rmi.RemoteException;

import po.UserPO;

public interface UserDataService {
	public void add(UserPO po)throws RemoteException;
	
	public void delete (UserPO po)throws RemoteException;
	
	public UserPO find(long id)throws RemoteException;
	
	public void update (UserPO po)throws RemoteException;
}
