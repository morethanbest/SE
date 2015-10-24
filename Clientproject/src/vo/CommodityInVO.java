package vo;

import po.CommodityLocation;

public class CommodityInVO {
	String ordercode;
	long intime;
	CommodityLocation location;
	public CommodityInVO(String ordercode, long intime, CommodityLocation location) {
		this.ordercode = ordercode;
		this.intime = intime;
		this.location = location;
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
	
}
