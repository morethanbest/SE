package businesslogic.accountbl.AccountPack;

import dataservice.accountdataservice.AccountDataService;
import init.RMIHelper;
import po.AccountPO;
import po.ResultMessage;

import java.rmi.RemoteException;

public class DelAccount {
    long id;
    String accountname;
    double accountsum;
    public void setdelInfo(long id, String accountname,double accountsum){
        this.id=id;
        this.accountname=accountname;
        this.accountsum=accountsum;
    }
    public ResultMessage delAccount() {
        // TODO Auto-generated method stub
        AccountDataService account= RMIHelper.getAccountdata();
        ResultMessage result;
        try {
            AccountPO po=new AccountPO(id, accountname, accountsum);
            result=account.deleteAccount(po);
        } catch (Exception e) {
            result=ResultMessage.failure;
            System.out.println("deleteaccount fail");
        }

        return result;
    }
}
