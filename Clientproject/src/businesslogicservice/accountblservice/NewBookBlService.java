package businesslogicservice.accountblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.NewbookVO;

public interface NewBookBlService {
	public ResultMessage NewBook (NewbookVO vo)throws RemoteException;

}
