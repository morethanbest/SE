package businesslogic.accountbl.AccountPack;

import dataservice.accountdataservice.AccountDataService;
import init.RMIHelper;
import po.AccountPO;
import po.ResultMessage;

import java.rmi.RemoteException;

public class DelAccount {
    String accountname;
    public void setdelInfo(String accountname){
        this.accountname=accountname;
    }
    public ResultMessage delAccount() {
        // TODO Auto-generated method stub
        AccountDataService account= RMIHelper.getAccountdata();
        ResultMessage result;
        try {
            AccountPO po=account.findAccount(accountname);
            result=account.deleteAccount(po);
        } catch (Exception e) {
            result=ResultMessage.failure;
            System.out.println("deleteaccount fail");
        }

        return result;
    }
}
