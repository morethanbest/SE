package businesslogic.logisticsbl.ArrivalPack;

import java.rmi.RemoteException;

import dataservice.logisticsdataservice.ArrivalFormDataService;
import init.RMIHelper;

/**
 * Created by Administrator on 2015/11/26.
 */
public class IdGet {
    public String getid(String orgcode){
        ArrivalFormDataService dataserv= RMIHelper.getArrivalform();
       long id=-1;
        String result=null;
        try {
             id=dataserv.findLastID(orgcode)+1;
             result=Long.toString(id);
             int len=result.length();
            if(len>7){
                System.out.println("arrival id out of bound!!!");
                return "-1";
            }
            for(int i=0;i<=7-len-1;i++)
                result="0"+result;
        } catch (RemoteException e) {
            System.out.println("Get Arrival Id Failed!!!");
            result="-2";
            e.printStackTrace();
        }
        result=orgcode+result;
        return result;
    }

}
