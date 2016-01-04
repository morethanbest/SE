package businesslogic.commoditybl.StockExaminationPack;

import dataservice.commoditydataservice.CommodityDataService;
import init.RMIHelper;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/30.
 */
public class getPara {
    public List<Long> getSomeNum(String orgcode,long intime,long outtime){
        CommodityDataService data= RMIHelper.getCommoditydata();
        List<Long> num=null;
        try {
            num=data.getCommodityNumber(orgcode,intime,outtime);
        } catch (RemoteException e) {
            System.out.println("stock examination get para failed!!!");
            e.printStackTrace();
        }
        return num;
    }
}
