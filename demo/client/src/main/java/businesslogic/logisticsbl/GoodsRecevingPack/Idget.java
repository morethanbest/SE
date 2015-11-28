package businesslogic.logisticsbl.GoodsRecevingPack;

import dataservice.logisticsdataservice.GoodsReceivingFormDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/27.
 */
public class Idget {

    public String getid(String orgcode){
        GoodsReceivingFormDataService dataserv= RMIHelper.getGoodsreceiving();
        String result=null;
        try {
            long id=dataserv.findLastID(orgcode)+1;
            result=Long.toString(id);
            int len=result.length();
            if(len>7){
                System.out.println("goodsreceving id out of bound!!!");
                return null;
            }
            for(int i=0;i<=len-1;i++)
                result="0"+result;
        } catch (RemoteException e) {
            e.printStackTrace();
        }


        result=orgcode+result;
        return result;
    }
}
