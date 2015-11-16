package businesslogic.accountbl.AccountPack;

import java.rmi.RemoteException;

import po.AccountPO;
import vo.ResultMessage;

public class MockAddAccount extends AddAccount{
	String accountname;
	double accountsum;
	long id;
	public void setAddInfo(long id,String accountname,double accountsum){
		this.id=id;
		this.accountname=accountname;
		this.accountsum=accountsum;
	}
	public ResultMessage addAccount(){
		// TODO Auto-generated method stub
		AccountPO po=new AccountPO(id, accountname, accountsum);
		ResultMessage result=ResultMessage.success;
		return result;
	}
}
