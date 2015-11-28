package businesslogic.logisticsbl.DeliveryPack;

import dataservice.logisticsdataservice.DeliveryFormDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/26.
 */
public class IdGet {
    public String getid(String orgcode)
    {
        DeliveryFormDataService dataserv= RMIHelper.getDeliveryformdata();
        String result=null;
        long id=-1;
        try {
            id=dataserv.findLastID(orgcode)+1;
            result=Long.toString(id);
            int len=result.length();
            for(int i=0;i<=7-len-1;i++){
                System.out.println("delivery id out  of bound!!!");
                result="0"+result;
            }
        } catch (RemoteException e) {
            System.out.println("Delivery Get Id Failed!!!");
            e.printStackTrace();
        }
        result=orgcode+result;
        return result;
    }
}
