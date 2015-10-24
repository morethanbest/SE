package vo;

import po.City;
import po.CommodityLocation;

public class StockinVO {
	String ordercode;
	long intime;
	CommodityLocation location;
	City destination;
	public StockinVO(String ordercode, long intime, CommodityLocation location,
			City destination) {
		super();
		this.ordercode = ordercode;
		this.intime = intime;
		this.location = location;
		this.destination = destination;
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
	public City getDestination() {
		return destination;
	}
}
