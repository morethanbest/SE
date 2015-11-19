package dataservice.userdataservice;

import java.rmi.RemoteException;

import vo.ResultMessage;

public interface UserLoginDataService {

	public ResultMessage login(String username,String password)throws RemoteException;

}
