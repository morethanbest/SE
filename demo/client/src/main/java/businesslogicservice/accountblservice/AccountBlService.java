package businesslogicservice.accountblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.AccountVO;

public interface AccountBlService {
	public ResultMessage addAccount(AccountVO vo)throws RemoteException;
	
	public ResultMessage delAccount()throws RemoteException;
	
	public ResultMessage revAccount(AccountVO vo)throws RemoteException;
	
	public AccountVO getAccountbyID(long id)throws RemoteException;
	

}
