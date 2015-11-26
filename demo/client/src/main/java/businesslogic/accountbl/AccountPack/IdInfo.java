package businesslogic.accountbl.AccountPack;

import dataservice.accountdataservice.AccountDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by ³¬ on 2015/11/26.
 */
public class IdInfo {
    public long getId(){
        AccountDataService account= RMIHelper.getAccountdata();
        long id;
        try {
            id=account.getLastId()+1;
        } catch (Exception e) {
            id=0;
            System.out.println("getid fail");
        }
        return id;
    }
}
