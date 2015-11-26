package businesslogic.managerbl.SearchAccountPack;

import java.rmi.RemoteException;

import dataservice.accountdataservice.AccountDataService;
import init.RMIHelper;
import po.AccountPO;
import vo.AccountVO;

public class SearchAccount {
	String accountname;
	public void setGetInfo(String accountname){
		this.accountname=accountname;
	}
	public AccountVO getAccountbyName(){
		// TODO Auto-generated method stub
		AccountDataService account=RMIHelper.getAccountdata();
		AccountPO po;
		AccountVO vo;
		 try {
	            po = account.findAccount(accountname);
	            long id=po.getId();
	            String name=po.getAccountname();
	            double sum=po.getAccountsum();
	            vo=new AccountVO(id, name, sum);
	        } catch (Exception e) {
	            vo=null;
	            System.out.println("getaccount fail");
	        }
		
		return vo;
	}
}
