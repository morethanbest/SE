package businesslogic.accountbl.AccountPack;

import po.AccountPO;
import vo.ResultMessage;

public class MockRevAccount extends RevAccount{
	String accountname;
	double accountsum;
	public void setRevInfo(String accountname,double accountsum){
		this.accountname=accountname;
		this.accountsum=accountsum;
	}
	public ResultMessage revAccount(){
		// TODO Auto-generated method stub
		AccountPO po=new AccountPO(1, accountname, accountsum);
		long id=po.getId();
		AccountPO newpo=new AccountPO(id, accountname, accountsum);
		ResultMessage result=ResultMessage.success;
		return result;
	}
}
