package businesslogic.accountbl.AccountPack;

import dataservice.accountdataservice.AccountDataService;
import init.RMIHelper;
import po.AccountPO;
import po.ResultMessage;

import java.rmi.RemoteException;

public class AddAccount {
    long id;
    String accountname;
    double accountsum;
    public void setAddInfo(long id, String accountname,double accountsum){
        this.id=id;
        this.accountname=accountname;
        this.accountsum=accountsum;
    }
    public ResultMessage addAccount(){
        // TODO Auto-generated method stub
        AccountPO po=new AccountPO(id, accountname, accountsum);
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
