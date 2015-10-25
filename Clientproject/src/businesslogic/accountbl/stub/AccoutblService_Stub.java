package businesslogic.accountbl.stub;

import java.rmi.RemoteException;

import businesslogicservice.accountblservice.AccountBlService;
import vo.AccountVO;
import vo.ResultMessage;

public class AccoutblService_Stub implements AccountBlService {
	
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
	public AccountVO getAccountbyID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return new AccountVO("abc",100);
	}

}
