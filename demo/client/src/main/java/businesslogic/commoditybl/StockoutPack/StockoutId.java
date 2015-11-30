package businesslogic.commoditybl.StockoutPack;

import dataservice.commoditydataservice.StockoutFormDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/30.
 */
public class StockoutId {
    public String getid(String orgcode){
        StockoutFormDataService data= RMIHelper.getStockouform();
        long id=0;
        try {
            id=data.getid(orgcode)+1;
        } catch (RemoteException e) {
            System.out.println("get stockout id failed!!!");
            e.printStackTrace();
        }
        String result=Long.toString(id);
        int len=result.length();
        if(len>7){
            System.out.println("stockout id overflow!!!");
            try {
                throw  new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for(int i=0;i<=7-len-1;i++)
            result="0"+result;

        result=orgcode+result;
        return result;
    }
}
