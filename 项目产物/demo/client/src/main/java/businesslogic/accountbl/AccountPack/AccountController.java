package businesslogic.accountbl.AccountPack;

import java.rmi.RemoteException;


import vo.AccountVO;
import po.ResultMessage;
import businesslogicservice.accountblservice.AccountBlService;

public class AccountController implements AccountBlService {
	@Override
	public ResultMessage addAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		AddAccount addAccount=new AddAccount();
		IdInfo Id=new IdInfo();
		Account account=new Account(addAccount, Id);
		ResultMessage result=account.addAccount(vo);
		return result;
	}

	@Override
	public ResultMessage delAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		DelAccount delAccount=new DelAccount();
		Account account = new Account(delAccount);
		ResultMessage result=account.delAccount(vo);
		return result;
	}

	@Override
	public ResultMessage revAccount(AccountVO vo) {
		// TODO Auto-generated method stub
		RevAccount revAccount=new RevAccount();
		Account account=new Account(revAccount);
		ResultMessage result=account.revAccount(vo);
		return result;
	}

	@Override
	public AccountVO getAccountbyName(String accountname) {
		// TODO Auto-generated method stub
		GetAccountbyName getAccountbyName=new GetAccountbyName();
		Account account=new Account(getAccountbyName);
		AccountVO vo=account.getAccountbyName(accountname);
		return vo;
	}

}
