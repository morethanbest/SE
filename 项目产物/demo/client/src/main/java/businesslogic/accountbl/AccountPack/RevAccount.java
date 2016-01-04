package businesslogic.accountbl.AccountPack;

import dataservice.accountdataservice.AccountDataService;
import init.RMIHelper;
import po.AccountPO;
import po.ResultMessage;

import java.rmi.RemoteException;

public class RevAccount {
    long id;
    String accountname;
    double accountsum;
    public void setRevInfo(long id, String accountname,double accountsum){
        this.id=id;
        this.accountname=accountname;
        this.accountsum=accountsum;
    }
    public ResultMessage revAccount(){
        // TODO Auto-generated method stub
        AccountPO po=new AccountPO(id, accountname, accountsum);
        AccountDataService account= RMIHelper.getAccountdata();
        ResultMessage result= null;
        try {
            result = account.updateAccount(po);
        } catch (RemoteException e) {
            result=ResultMessage.failure;
            System.out.println("revaccount fail");
        }
        return result;
    }
}
