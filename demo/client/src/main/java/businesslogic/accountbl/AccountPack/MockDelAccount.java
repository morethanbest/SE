package businesslogic.accountbl.AccountPack;

import po.AccountPO;
import vo.ResultMessage;

public class MockDelAccount extends DelAccount{
	String accountname;
	public void setdelInfo(String accountname){
		this.accountname=accountname;
	}
	public ResultMessage delAccount() {
		// TODO Auto-generated method stub
		AccountPO po=new AccountPO(1, accountname, 0);
		//Œ¥ µœ÷
		return ResultMessage.success;
	}

}
