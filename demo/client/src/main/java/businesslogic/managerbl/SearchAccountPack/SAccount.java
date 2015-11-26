package businesslogic.managerbl.SearchAccountPack;

import vo.AccountVO;

public class SAccount {
	SearchAccount searchAccount;
	public SAccount(SearchAccount searchAccount){
		this.searchAccount=searchAccount;
	}
	public AccountVO getAccountbyName(String accountname){
		AccountVO vo;
		searchAccount.setGetInfo(accountname);
		vo=searchAccount.getAccountbyName();
		return vo;
	}

}
