package businesslogic.logisticsbl.DeliveryPack;

import dataservice.logisticsdataservice.DeliveryFormDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/26.
 */
public class IdGet {
    public long getid(){
        DeliveryFormDataService dataserv= RMIHelper.getDeliveryformdata();
        long id=-1;
        try {
            id=dataserv.findLastID()+1;
        } catch (RemoteException e) {
            System.out.println("Delivery Get Id Failed!!!");
            e.printStackTrace();
        }
        return id;
    }
}
