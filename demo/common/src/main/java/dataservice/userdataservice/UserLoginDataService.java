package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.LoginPO;

public interface UserLoginDataService extends Remote {

	public LoginPO login(long id,String password)throws RemoteException;

}
