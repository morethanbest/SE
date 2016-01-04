package businesslogic.transportbl.DriverPack;

import dataservice.transportdataservice.DriversDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

import com.sun.glass.ui.TouchInputSupport;

/**
 * Created by Administrator on 2015/11/25.
 */
public class DriverId {


    public String getid(String orgcode){
        DriversDataService dataserv= RMIHelper.getDriverdata();
        long id= 0;

        String result=null;
        try {
            id = dataserv.getCurrentID(orgcode)+1;
            result=Long.toString(id);
            int len=result.length();
            if(len>3){
                result="-1";
                System.out.println(" driver id overflow~!!!");
                try {
                    throw  new Exception();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            for(int j=0;j<=3-len-1;j++){
                result="0"+result;
            }

            result=orgcode+result;
        } catch (RemoteException e) {
            e.printStackTrace();
            System.out.println("Get Latest DriverID Failed!!!");
            result="-2";
        }


        return result;
    }

}
