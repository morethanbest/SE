package po;

import java.io.Serializable;

public class OrignalCommodityPO implements Serializable {
	long id;
	String ordercode;
	long intime;
	CommodityLocation location;
	long outtime;
	public OrignalCommodityPO(long id, String ordercode, long intime, CommodityLocation location) {
		this.id = id;
		this.ordercode = ordercode;
		this.intime = intime;
		this.outtime = 0;
	}
	public long getId() {
		return id;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public long getIntime() {
		return intime;
	}
	public long getOuttime() {
		return outtime;
	}
	public CommodityLocation getLocation() {
		return location;
	}
	
}
