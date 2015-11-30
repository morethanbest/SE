package businesslogic.commoditybl.GetRegionInfoPack;

import dataservice.commoditydataservice.CommodityDataService;
import init.RMIHelper;
import po.CommodityPO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/30.
 */
public class RegionGet {
    public List<CommodityPO> getcommodity(String orgcode,long blocknum){
        CommodityDataService data= RMIHelper.getCommoditydata();
        List<CommodityPO> pos=null;
        try {
            pos=data.getCommodtiyByBlock(orgcode,blocknum);
        } catch (RemoteException e) {
            System.out.println("Get region info get failed!!!");
            e.printStackTrace();
        }
        return pos;
    }
}
