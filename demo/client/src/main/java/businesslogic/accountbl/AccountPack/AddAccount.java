package businesslogic.accountbl.AccountPack;

import dataservice.accountdataservice.AccountDataService;
import init.RMIHelper;
import po.AccountPO;
import po.ResultMessage;

import java.rmi.RemoteException;

public class AddAccount {
    String accountname;
    double accountsum;
    public void setAddInfo(String accountname,double accountsum){
        this.accountname=accountname;
        this.accountsum=accountsum;
    }
    public ResultMessage addAccount(){
        // TODO Auto-generated method stub
        AccountPO po=new AccountPO(accountname, accountsum);
        AccountDataService account= RMIHelper.getAccountdata();
        ResultMessage result;
        try {
            result = account.addAccount(po);
        } catch (Exception e) {
            result=ResultMessage.failure;
            System.out.println("addaccount fail");
        }
        return result;
    }
}
