package businesslogic.logisticsbl.HallLoadPack;

import dataservice.logisticsdataservice.HallLoadFormDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/28.
 */
public class Idget {
    public String idget(String orgcode,long date){
        HallLoadFormDataService data= RMIHelper.getHallloadform();
        long id=0;
        try {
            id=data.findLastmotorcode(orgcode,date)+1;
        } catch (RemoteException e) {
            System.out.println("get hall load id failed!!!");
            e.printStackTrace();
        }
        String result=Long.toString(id);
        int len=result.length();
        if(len>5){
            System.out.println("hall load id overflow");
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        for(int i=0;i<=5-len-1;i++)
            result="0"+result;

        result=orgcode+Long.toString(date)+result;
        return result;
    }

}
