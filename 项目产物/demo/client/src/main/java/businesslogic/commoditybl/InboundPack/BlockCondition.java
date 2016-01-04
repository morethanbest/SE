package businesslogic.commoditybl.InboundPack;

import dataservice.commoditydataservice.StockinFormDataService;
import init.RMIHelper;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/12/7.
 */
public class BlockCondition {
    public List<Long> getlimit(long blocknum,String orgcode){
        List<Long> result=null;
        StockinFormDataService data= RMIHelper.getStockinform();
        try {
            result=data.getStockNumbyblocknum(blocknum,orgcode);
        } catch (RemoteException e) {
            System.out.println("stockin form get block condition by block num failed!!!");
            e.printStackTrace();
        }
        return result;

    }
}
