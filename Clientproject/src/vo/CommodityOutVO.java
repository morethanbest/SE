package vo;

import po.CommodityLocation;

public class CommodityOutVO {
	String ordercode;
	long intime;
	long outTime;
	CommodityLocation location;
	public CommodityOutVO(String ordercode, long intime, long outTime,
			CommodityLocation location) {
		super();
		this.ordercode = ordercode;
		this.intime = intime;
		this.outTime = outTime;
		this.location = location;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public long getIntime() {
		return intime;
	}
	public long getOutTime() {
		return outTime;
	}
	public CommodityLocation getLocation() {
		return location;
	}

}
