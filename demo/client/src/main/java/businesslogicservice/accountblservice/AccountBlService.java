package businesslogicservice.accountblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.AccountVO;

public interface AccountBlService {
	public ResultMessage addAccount(AccountVO vo);
	
	public ResultMessage delAccount(AccountVO vo);
	
	public ResultMessage revAccount(AccountVO vo);

	public AccountVO getAccountbyName(String accountname);
	

}
