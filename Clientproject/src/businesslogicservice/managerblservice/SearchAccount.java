package businesslogicservice.managerblservice;

import java.rmi.RemoteException;

import vo.AccountVO;

public interface SearchAccount {
	public AccountVO searchAccount(long id)throws RemoteException;

}
