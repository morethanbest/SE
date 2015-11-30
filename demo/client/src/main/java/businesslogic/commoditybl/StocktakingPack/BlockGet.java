package businesslogic.commoditybl.StocktakingPack;

import dataservice.commoditydataservice.CommodityDataService;
import init.RMIHelper;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/30.
 */
public class BlockGet {
    public List<Long> getBlock(String orgcode){
        CommodityDataService data= RMIHelper.getCommoditydata();
        List<Long> blocks=null;
        try {
            blocks=data.getAllBlock(orgcode);
        } catch (RemoteException e) {
            System.out.println("stock taking get block nums failed@@@");
            e.printStackTrace();
        }
        return blocks;
    }
}
