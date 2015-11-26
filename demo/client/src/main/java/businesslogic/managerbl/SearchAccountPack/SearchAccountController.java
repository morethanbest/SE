package businesslogic.managerbl.SearchAccountPack;

import businesslogicservice.managerblservice.SearchAccountBlService;
import vo.AccountVO;

public class SearchAccountController implements SearchAccountBlService {

	@Override
	public AccountVO searchAccount(String accountname) {
		SearchAccount searchAccount=new SearchAccount();
		SAccount account=new SAccount(searchAccount);
		AccountVO vo=account.getAccountbyName(accountname);
		return vo;
	}

}
