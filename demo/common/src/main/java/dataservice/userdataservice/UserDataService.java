package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ResultMessage;
import po.UserPO;

public interface UserDataService extends Remote {
	public ResultMessage add(UserPO po)throws RemoteException;
	
	public ResultMessage delete (UserPO po)throws RemoteException;
	
	public UserPO find(long id)throws RemoteException;
	
	public ResultMessage update (UserPO po)throws RemoteException;
}