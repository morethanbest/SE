package businesslogic.commoditybl.StocktakingPack;

import dataservice.commoditydataservice.CommodityDataService;
import init.RMIHelper;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/30.
 */
public class IdGet {
    public long getid(String orgcode,String date){
        CommodityDataService data= RMIHelper.getCommoditydata();
        long id=0;
        try {
            id=data.getStopPoint(orgcode,date);
        } catch (RemoteException e) {
            System.out.println("stock taking get stop point failed!!!");
            e.printStackTrace();
        }
        return id;

    }
}
