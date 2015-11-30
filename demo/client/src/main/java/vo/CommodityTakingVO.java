package vo;





import po.CommodityLocation;

public class CommodityTakingVO {
	String ordercode;
	long intime;

	CommodityLocation location;
	String destination;
	public CommodityTakingVO(String ordercode, long intime,  String destination,CommodityLocation location) {
		super();
		this.ordercode = ordercode;
		this.intime = intime;

		this.location = location;
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
	public String getDestination(){
		return destination;
	}

}
