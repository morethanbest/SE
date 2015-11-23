package businesslogic.accountbl.AccountPack;

import java.rmi.RemoteException;

import vo.AccountVO;
import vo.ResultMessage;
import businesslogicservice.accountblservice.AccountBlService;

public class AccountController implements AccountBlService {
	@Override
	public ResultMessage addAccount(AccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage delAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage revAccount(AccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public AccountVO getAccountbyID(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return new AccountVO(1,"abc",100);
	}

}
