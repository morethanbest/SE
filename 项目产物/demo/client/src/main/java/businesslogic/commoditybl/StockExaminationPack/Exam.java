package businesslogic.commoditybl.StockExaminationPack;

import dataservice.commoditydataservice.CommodityDataService;
import init.RMIHelper;
import po.CommodityPO;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2015/11/30.
 */
public class Exam {

    public List<CommodityPO> getlist(String orgcode,long intime,long outtime){
        CommodityDataService data= RMIHelper.getCommoditydata();
        List<CommodityPO> pos=null;
        try {
            pos=data.getCommodityBetween(orgcode,intime,outtime);
        } catch (RemoteException e) {
            System.out.println("Stock Examination get list between two clock time faeiled!!!");
            e.printStackTrace();
        }
        return pos;
    }
}
