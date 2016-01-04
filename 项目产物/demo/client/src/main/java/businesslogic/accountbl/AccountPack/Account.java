package businesslogic.accountbl.AccountPack;

import po.ResultMessage;
import vo.AccountVO;

public class Account {
	AddAccount addAccount;
	DelAccount delAccount;
	RevAccount revAccount;
	GetAccountbyName getAccountbyName;
	IdInfo Id;
	public Account(AddAccount addAccount, IdInfo Id){
		this.addAccount=addAccount;
		this.Id=Id;
	}
	
	public Account(DelAccount delAccount){
		this.delAccount=delAccount;
	}
	
	public Account(RevAccount revAccount){
		this.revAccount=revAccount;
	}
	
	public Account(GetAccountbyName getAccountbyName){
		this.getAccountbyName=getAccountbyName;
	}
	
	public ResultMessage addAccount(AccountVO vo){
		long id=Id.getId();
		String accountname=vo.getAccountname();
		double accountsum=vo.getAccountsum();
		addAccount.setAddInfo(id, accountname, accountsum);
		ResultMessage result=addAccount.addAccount();
		return result;
	}
	
	public AccountVO getAccountbyName(String accountname){
		AccountVO vo;
		getAccountbyName.setGetInfo(accountname);
		vo=getAccountbyName.getAccountbyName();
		return vo;
	}
	
	public ResultMessage delAccount(AccountVO vo){
		long id=vo.getId();
		String accountname=vo.getAccountname();
		double accountsum=vo.getAccountsum();
		delAccount.setdelInfo(id, accountname, accountsum);
		ResultMessage result=delAccount.delAccount();
		return result;
	}
	
	public ResultMessage revAccount(AccountVO vo){
		long id=vo.getId();
		String accountname=vo.getAccountname();
		double accountsum=vo.getAccountsum();
		revAccount.setRevInfo(id, accountname, accountsum);
		ResultMessage result=revAccount.revAccount();
		return result;
	}
}
