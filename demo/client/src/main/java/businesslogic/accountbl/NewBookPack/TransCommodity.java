package businesslogic.accountbl.NewBookPack;

import po.CommodityLocation;
import po.CommodityPO;
import vo.CommodityVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class TransCommodity {
    public List<CommodityPO> trans(List<CommodityVO> vo){
        List<CommodityPO> list=new ArrayList<CommodityPO>();
        for(int i=0;i<=vo.size()-1;i++){
            CommodityVO newvo=vo.get(i);
            String id=newvo.getId();
            String ordercode=newvo.getOrdercode();
            long intime=newvo.getIntime();
            long outtime=newvo.getOuttime();
            String destination=newvo.getDestination();
            CommodityLocation location=newvo.getLocation();

            CommodityPO po=new CommodityPO(id,ordercode,intime,outtime,destination,location);
            list.add(po);
        }
        return list;
    }

    public List<CommodityVO> trans2(List<CommodityPO> po){
        List<CommodityVO> list=new ArrayList<CommodityVO>();
        for(int i=0;i<=po.size()-1;i++){
            CommodityPO newpo=po.get(i);
            String id=newpo.getId();
            String ordercode=newpo.getOrdercode();
            long intime=newpo.getIntime();
            long outtime=newpo.getOuttime();
            String destination=newpo.getDestination();
            CommodityLocation location=newpo.getLocation();

            CommodityVO vo=new CommodityVO(id,ordercode,intime,outtime,destination,location);
            list.add(vo);
        }
        return list;
    }
}
