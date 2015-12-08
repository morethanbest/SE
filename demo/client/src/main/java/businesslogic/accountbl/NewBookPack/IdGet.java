package businesslogic.accountbl.NewBookPack;

import dataservice.accountdataservice.NewBookDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/12/8.
 */
public class IdGet {
    public long getid(){
        NewBookDataService data= RMIHelper.getNewbook();
        long id=0;
        try {
            id=data.getid()+1;
        } catch (RemoteException e) {
            System.out.println("new book get id failed!!!");
            e.printStackTrace();
        }
        return id;

    }
}
