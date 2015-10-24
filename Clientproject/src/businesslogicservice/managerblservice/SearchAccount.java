package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import vo.AccountVO;

public interface searchAccount {
	public AccountVO searchAccount(long id, long password)throws RemoteException;

}
