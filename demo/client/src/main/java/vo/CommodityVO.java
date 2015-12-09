package vo;

import po.CommodityLocation;

/**
 * Created by Administrator on 2015/12/8.
 */
public class CommodityVO {
    String id;
    String ordercode;
    long intime;
    long outtime;

    String destination;

    CommodityLocation location;

    public CommodityVO(String id, String ordercode, long intime,  long outtime,String destination,CommodityLocation location) {
        this.id = id;
        this.ordercode = ordercode;
        this.intime = intime;
        this.location = location;
        this.outtime = outtime;
        this.destination=destination;

    }
    public String getOrdercode() {
        return ordercode;
    }

    public long getIntime() {
        return intime;
    }

    public CommodityLocation getLocation() {
        return location;
    }





    public long getOuttime() {
        return outtime;
    }

    public String getId() {
        return id;
    }

    public String getDestination(){
        return destination;
    }



}
