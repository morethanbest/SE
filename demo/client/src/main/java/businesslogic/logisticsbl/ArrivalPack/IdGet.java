package businesslogic.logisticsbl.ArrivalPack;

import dataservice.logisticsdataservice.ArrivalFormDataService;
import dataservice.orderdataservice.LogisticsDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/26.
 */
public class IdGet {
    public String getid(String centercode){
        ArrivalFormDataService dataserv= RMIHelper.getArrivalform();
        String result=null;
        try {
            long id=dataserv.findLastID(centercode)+1;
            result=Long.toString(id);
            int len=result.length();
            if(len>7) {
                result = "-1";
                return result;
            }
            for(int i=0;i<=7-len-1;i++){
                result="0"+result;
            }
        } catch (RemoteException e) {
            System.out.println("Get Arrival Id Failed!!!");
            result="-2";
            e.printStackTrace();
        }
        return result;
    }

}
