package businesslogic.commoditybl.SubregionPack;

import dataservice.commoditydataservice.StockinFormDataService;
import init.RMIHelper;
import po.CommodityLocation;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/12/7.
 */
public class IsEmpty {
    public boolean wheEmpty(String orgcode, CommodityLocation location){
        boolean result=false;
        StockinFormDataService data=RMIHelper.getStockinform();
        try {
            result=data.isEmpty(orgcode,location);
        } catch (RemoteException e) {
            System.out.println("sub region get whether location is empty failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
