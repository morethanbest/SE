package po;

import java.io.Serializable;

public class CommodityPO  implements Serializable{
	long id;
	long ordercode;
	long intime;
	CommodityLocation location;
	long outtime;
	public CommodityPO(long id, long ordercode, long intime, CommodityLocation location, long outtime) {
		this.id = id;
		this.ordercode = ordercode;
		this.intime = intime;
		this.location = location;
		this.outtime = outtime;
	}
	public long getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(long ordercode) {
		this.ordercode = ordercode;
	}
	public long getIntime() {
		return intime;
	}
	public void setIntime(long intime) {
		this.intime = intime;
	}
	public CommodityLocation getLocation() {
		return location;
	}
	public void setLocation(CommodityLocation location) {
		this.location = location;
	}
	public long getOuttime() {
		return outtime;
	}
	public void setOuttime(long outtime) {
		this.outtime = outtime;
	}
	public long getId() {
		return id;
	}
	
	
}
