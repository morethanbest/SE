package businesslogic.logisticsbl.ArrivalPack;

import dataservice.logisticsdataservice.ArrivalFormDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/26.
 */
public class DepartGet {
    public String getDepartureByTrans(String transcode){
        ArrivalFormDataService  dataserv= RMIHelper.getArrivalform();
        String departure=null;
        try {
             departure=dataserv.getDepartureByTrans(transcode);
        } catch (RemoteException e) {
            System.out.println("Get Departure Failed(at--arrivalpack--deparget!!!");
            e.printStackTrace();
        }
        return departure;
    }

    public String getDepartureByLoad(String loadcode){
        ArrivalFormDataService dataserv=RMIHelper.getArrivalform();
        String departure=null;
        try {
            departure=dataserv.getDepartureByLoad(loadcode);
        } catch (RemoteException e) {
            System.out.println("Get Departure Failed(at--arrivalpack--deparget!!!");
            e.printStackTrace();
        }
        return departure;
    }
}
