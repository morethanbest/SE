package vo;

import po.CommodityLocation;
import po.Formstate;


public class StockinExamVO {
	String ordercode;
	long intime;
	CommodityLocation Location;
	String destination;
	Formstate documentstate;
	public StockinExamVO(String ordercode, long intime, CommodityLocation location,String destination) {
		this.ordercode = ordercode;
		this.intime = intime;
		Location = location;
		this.destination = destination;
		this.documentstate=Formstate.waiting;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public long getIntime() {
		return intime;
	}
	public void setIntime(long intime) {
		this.intime = intime;
	}
	public CommodityLocation getLocation() {
		return Location;
	}
	public void setLocation(CommodityLocation location) {
		Location = location;
	}
	public Formstate getDocumentstate() {
		return documentstate;
	}
	public void setDocumentstate(Formstate documentstate) {
		this.documentstate = documentstate;
	}

	
}
