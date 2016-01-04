package po;

import java.io.Serializable;

public class CommodityPO  implements Serializable{
	String id;
	String ordercode;
	long intime;
	long outtime;

	String destination;

	CommodityLocation location;

	public CommodityPO(String id, String ordercode, long intime,  long outtime,String destination,CommodityLocation location) {
		this.id = id;
		this.ordercode = ordercode;
		this.intime = intime;
		this.location = location;
		this.outtime = outtime;
		this.destination=destination;

	}
	public String getOrdercode() {
		return ordercode;
	}
	public void setOrdercode(String ordercode) {
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
	public String getId() {
		return id;
	}
	public void setid(String id){ this.id=id;}
	public String getDestination(){
		return destination;
	}
	public void setDestination(String destination){this.destination=destination;}

	
}
