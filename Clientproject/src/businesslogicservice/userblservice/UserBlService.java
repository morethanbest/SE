package businesslogicservice.userblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.UserVO;

public interface UserBlService {
	
	
	public ResultMessage addUser(UserVO vo)throws RemoteException;
	
	public ResultMessage delUser(UserVO vo,long id)throws RemoteException;
	
	public ResultMessage revUser(UserVO vo,long id)throws RemoteException;
	
	public UserVO getUserbyID(long id)throws RemoteException;

}
