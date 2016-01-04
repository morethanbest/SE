package vo;

import po.CommodityLocation;

/**
 * Created by Administrator on 2015/11/30.
 */
public class CommodityExamVO {

    String ordercode;
    CommodityLocation location;
    public CommodityExamVO(String ordercode,CommodityLocation location){
        this.ordercode=ordercode;
        this.location=location;
    }

    public String getOrdercode(){return this.ordercode;}
    public CommodityLocation getLocation(){return this.location;}

}
