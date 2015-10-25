package businesslogic.managerbl;

import java.rmi.RemoteException;

import businesslogicservice.managerblservice.SearchAccount;
import vo.AccountVO;

public class SearchAccount_Stub implements SearchAccount {

	@Override
	public AccountVO searchAccount(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return new AccountVO(1,"1",1);
	}

}
