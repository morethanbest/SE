package businesslogic.commoditybl.StockoutPack;

import dataservice.commoditydataservice.StockoutFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.StockoutPO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/30.
 */
public class FindStockout {
    public List<StockoutPO> findforms(Formstate state,String orgcode){
        StockoutFormDataService data= RMIHelper.getStockouform();
        List<StockoutPO> list=null;
        try {
            list=data.getStockoutForm(state,orgcode);
        } catch (RemoteException e) {
            System.out.println("stock out find forms by state failed!!!");
            e.printStackTrace();
        }
        return  list;

    }
}
