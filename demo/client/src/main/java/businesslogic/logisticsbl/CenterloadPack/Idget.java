package businesslogic.logisticsbl.CenterloadPack;

import dataservice.logisticsdataservice.CenterLoadFormDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/28.
 */
public class Idget {
    public String getid(String orgcode,String date){
        CenterLoadFormDataService dataserv= RMIHelper.getCenterloaddata();
        String result;
        long id=0;
        try {
            id=dataserv.findLastmotorcode(orgcode,date)+1;
        } catch (RemoteException e) {
            System.out.println("Get centerload transcode id failed!!!");
            e.printStackTrace();
        }
        result=Long.toString(id);
        int len=result.length();
        if(len>7){

            System.out.println("the id is overflow!!!");
            try {
                throw new Exception();
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        for(int i=0;i<=7-len-1;i++){
            result="0"+result;
        }
        result=orgcode+date+result;
        return result;
    }
}
