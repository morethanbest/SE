package businesslogic.commoditybl.InboundPack;

import dataservice.commoditydataservice.CommodityDataService;
import init.RMIHelper;
import po.CommodityLocation;
import vo.StockinVO;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2015/11/30.
 */
public class Alarm {

    public   boolean getwhe(StockinVO vo){
        String id=vo.getId();
        String orgcode=id.substring(0,id.length()-7);
        CommodityLocation loca=vo.getLocation();
        long blocknum=loca.getBlocknum();
        boolean result=false;
        CommodityDataService data= RMIHelper.getCommoditydata();
        try {
            result=data.wheOverLoad(orgcode,blocknum);
        } catch (RemoteException e) {
            System.out.println("whe judge whether alarm failed!!!");
            e.printStackTrace();
        }
        return result;
    }
}
