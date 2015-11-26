package businesslogic.logisticsbl.ArrivalPack;

import dataservice.logisticsdataservice.ArrivalFormDataService;
import dataservice.orderdataservice.LogisticsDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/26.
 */
public class IdGet {
    public long getid(String centercode){
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
