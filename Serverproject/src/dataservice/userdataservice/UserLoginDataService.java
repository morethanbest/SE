package dataservice.userdataservice;

import java.rmi.RemoteException;

import po.LoginPO;

public interface UserLoginDataService {

	public LoginPO login(long id,String password)throws RemoteException;

}
