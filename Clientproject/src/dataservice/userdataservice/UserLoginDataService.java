package dataservice.userdataservice;

import java.rmi.RemoteException;

import po.Job;

public interface UserLoginDataService {

	public Job login(long id,String password)throws RemoteException;

}
