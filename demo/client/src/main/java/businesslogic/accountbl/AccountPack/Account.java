package businesslogic.accountbl.AccountPack;

import vo.AccountVO;
import vo.ResultMessage;

public class Account {
	MockIdInfo idInfo;
	MockAddAccount addAccount;
	MockDelAccount delAccount;
	MockRevAccount revAccount;
	MockGetAccountbyID getAccountbyID;
	public Account(MockAddAccount addAccount,MockIdInfo idInfo){
		this.addAccount=addAccount;
		this.idInfo=idInfo;
	}
	
	public Account(MockDelAccount delAccount){
		this.delAccount=delAccount;
	}
	
	public Account(MockRevAccount revAccount){
		this.revAccount=revAccount;
	}
	
	public Account(MockGetAccountbyID getAccountbyID){
		this.getAccountbyID=getAccountbyID;
	}
	
	public ResultMessage addAccount(AccountVO vo){
		String accountname=vo.getAccountname();
		double accountsum=vo.getAccountsum();
		long id=this.idInfo.getid();
		addAccount.setAddInfo(id,accountname, accountsum);
		ResultMessage result=addAccount.addAccount();
		return result;
	}
	
	public AccountVO getAccountbyID(long id){
		AccountVO vo;
		getAccountbyID.setGetInfo(id);
		vo=getAccountbyID.getAccountbyID();
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
