package businesslogic.transportbl.DriverPack;

import dataservice.transportdataservice.DriversDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/25.
 */
public class DriverId {

    public long getid(){
        DriversDataService dataserv= RMIHelper.getDriverdata();
        long id= 0;
        try {
            id = dataserv.getCurrentID();
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("Get Latest DriverID Failed!!!");
            id=-1;
        }
        return id;
    }
}
