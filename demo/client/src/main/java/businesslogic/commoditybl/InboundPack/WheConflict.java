package businesslogic.commoditybl.InboundPack;

import dataservice.commoditydataservice.StockinFormDataService;
import init.RMIHelper;
import po.CommodityLocation;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/12/7.
 */
public class WheConflict {
    public boolean getres(String orgcode, CommodityLocation location){
        boolean result=false;
        StockinFormDataService data= RMIHelper.getStockinform();
        try {
            result=data.isEmpty(orgcode,location);
        } catch (RemoteException e) {
            System.out.println("stock in form whether locatin conflcit judge failed!!!");
            e.printStackTrace();
        }

        return result;

    }
}
