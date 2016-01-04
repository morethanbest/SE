package vo;

import po.CommodityLocation;
import po.Formstate;

public class StockinVO {
	String id;
	String ordercode;
	long intime;
	CommodityLocation location;
	String destination;
	Formstate formstate;
	public StockinVO(String id,String ordercode, long intime, CommodityLocation location,
			String destination,Formstate formstate) {
		super();
		this.id=id;
		this.ordercode = ordercode;
		this.intime = intime;
		this.location = location;
		this.destination = destination;
		this.formstate=formstate;
	}
	public String getId(){return id;}
	public String getOrdercode() {
		return ordercode;
	}
	public long getIntime() {
		return intime;
	}
	public CommodityLocation getLocation() {
		return location;
	}
	public String getDestination() {
		return destination;
	}
	public Formstate getFormstate(){return  formstate;}
	public void setFormstate(Formstate formstate) {
		this.formstate = formstate;
	}
	
	
}
