package businesslogic.logisticsbl.ArrivalPack;

import java.rmi.RemoteException;

import dataservice.logisticsdataservice.ArrivalFormDataService;
import init.RMIHelper;

/**
 * Created by Administrator on 2015/11/26.
 */
public class IdGet {
    public long getid(){
        ArrivalFormDataService dataserv= RMIHelper.getArrivalform();
       long id=-1;
        try {
             id=dataserv.findLastID()+1;

        } catch (RemoteException e) {
            System.out.println("Get Arrival Id Failed!!!");
            id=-2;
            e.printStackTrace();
        }
        return id;
    }

}
