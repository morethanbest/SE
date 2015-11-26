package businesslogic.accountbl.AccountPack;

import dataservice.accountdataservice.AccountDataService;
import init.RMIHelper;
import po.AccountPO;
import vo.AccountVO;

import java.rmi.RemoteException;

/**
 * Created by ³¬ on 2015/11/25.
 */
public class GetAccountbyName {
    String accountname;
    public void setGetInfo(String accountname){
        this.accountname=accountname;
    }
    public AccountVO getAccountbyName(){
        // TODO Auto-generated method stub
        AccountDataService account= RMIHelper.getAccountdata();
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
