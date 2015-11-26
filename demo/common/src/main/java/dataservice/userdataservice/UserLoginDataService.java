package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.UserPO;

public interface UserLoginDataService extends Remote {

	public UserPO login(String username,String password)throws RemoteException;

}
