package vo;





import po.CommodityLocation;

public class CommodityOutVO {
	String ordercode;
	long intime;
	long outTime;
	CommodityLocation location;
	String destination;
	public CommodityOutVO(String ordercode, long intime, long outTime,
			CommodityLocation location,String destination) {
		super();
		this.ordercode = ordercode;
		this.intime = intime;
		this.outTime = outTime;
		this.location = location;
		this.destination=destination;
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
	public String getDestination(){
		return destination;
	}

}
