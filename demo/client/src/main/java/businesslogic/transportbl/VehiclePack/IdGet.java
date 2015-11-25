package businesslogic.transportbl.VehiclePack;

import dataservice.transportdataservice.VehicleDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/25.
 */
public class IdGet {
    public long getid(){
        VehicleDataService dataserv= RMIHelper.getVehicledata();
        long id;
        try {
             id=dataserv.getCurrentID();
        } catch (RemoteException e) {
            System.out.println("Get Latest VehicleID Failed!!!");
            id=-1;
            e.printStackTrace();
        }
        return  id;
    }

}
