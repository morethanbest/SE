package dataservice.userdataservice;

import java.rmi.RemoteException;

import vo.ResultMessage;

public interface UserLoginDataService {

	public ResultMessage login(long id,String password)throws RemoteException;

}
