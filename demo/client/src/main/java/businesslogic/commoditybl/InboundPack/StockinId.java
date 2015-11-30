package businesslogic.commoditybl.InboundPack;

import dataservice.commoditydataservice.StockinFormDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/29.
 */
public class StockinId {
    public String getid(String orgcode){
        StockinFormDataService data= RMIHelper.getStockinform();
        long id=0;
        try {
            id=data.getid(orgcode);
        } catch (RemoteException e) {
            System.out.println("get stockin id failed!!!");
            e.printStackTrace();
        }
        String result=Long.toString(id);
        int len=result.length();
        if(len>7){
            System.out.println("stockin id overflow");
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for(int i=0;i<=len-1;i++)
            result="0"+result;
        result=orgcode=result;
        return result;

    }
}
