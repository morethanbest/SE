package businesslogic.commoditybl.SubregionPack;

import dataservice.commoditydataservice.CommodityDataService;
import init.RMIHelper;
import po.CommodityLocation;
import po.CommodityPO;
import po.ResultMessage;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/30.
 */
public class ChangeLocation {

    public ResultMessage resultLoc(String orgcode,CommodityLocation location1,CommodityLocation location2){
        CommodityDataService data= RMIHelper.getCommoditydata();
        CommodityPO po=null;
        try {
            po=data.getCommodityByLocation(orgcode,location1);
        } catch (RemoteException e) {
            System.out.println("subregion get commodtiy po by location faield!!!");
            e.printStackTrace();
        }
        po.setLocation(location2);
        ResultMessage result=null;
        try {
            result=data.updateCommodtiy(po);
        } catch (RemoteException e) {
            System.out.println("subregion update commmoditypo location failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
