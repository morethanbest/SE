package vo;

import po.CommodityLocation;

public class CommodityGetRegionVO {
	String ordercode;
	long intime;

	CommodityLocation location;
	public CommodityGetRegionVO(String ordercode, long intime, CommodityLocation location) {
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
