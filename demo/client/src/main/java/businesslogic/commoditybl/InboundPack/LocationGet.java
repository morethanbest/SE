package businesslogic.commoditybl.InboundPack;

import dataservice.commoditydataservice.CommodityDataService;
import init.RMIHelper;
import po.CommodityLocation;

import java.rmi.RemoteException;

/**格伦-莱斯
 * Created by Administrator on 2015/12/3.
 */
public class LocationGet {
    public CommodityLocation getLoc(String orgcode, long blocknum){
        CommodityDataService data= RMIHelper.getCommoditydata();
        CommodityLocation location=null;
        try {
            location=data.getLoc(orgcode,blocknum);
        } catch (RemoteException e) {
            System.out.println("stockin get free location failed!!!");
            e.printStackTrace();
        }
        return location;


    }
}
