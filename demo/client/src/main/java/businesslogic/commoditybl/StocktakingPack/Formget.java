package businesslogic.commoditybl.StocktakingPack;

import dataservice.commoditydataservice.CommodityDataService;
import init.RMIHelper;
import po.CommodityPO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/30.
 */
public class Formget {
    public List<CommodityPO> getcom(String orgcode,String date,long blocknum){
        List<CommodityPO> pos=null;
        CommodityDataService data= RMIHelper.getCommoditydata();
        try {
            pos=data.stockTaking(orgcode,date,blocknum);
        } catch (RemoteException e) {
            System.out.println("stock taking get commmodity pos failed!!!");
            e.printStackTrace();
        }
        return pos;
    }

}
