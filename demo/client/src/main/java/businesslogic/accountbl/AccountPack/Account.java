package businesslogic.accountbl.AccountPack;

import po.ResultMessage;
import vo.AccountVO;

public class Account {
	AddAccount addAccount;
	DelAccount delAccount;
	RevAccount revAccount;
	GetAccountbyName getAccountbyName;
	public Account(AddAccount addAccount){
		this.addAccount=addAccount;
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
		String accountname=vo.getAccountname();
		double accountsum=vo.getAccountsum();
		addAccount.setAddInfo(accountname, accountsum);
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
		String accountname=vo.getAccountname();
		delAccount.setdelInfo(accountname);
		ResultMessage result=delAccount.delAccount();
		return result;
	}
	
	public ResultMessage revAccount(AccountVO vo){
		String accountname=vo.getAccountname();
		double accountsum=vo.getAccountsum();
		revAccount.setRevInfo(accountname, accountsum);
		ResultMessage result=revAccount.revAccount();
		return result;
	}
}
