package po;
import java.io.Serializable;

public class StockinPO  implements Serializable{
	long id;
	String ordercode;
	long intime;
	CommodityLocation Location;
	String destination;
	public StockinPO(long id, String ordercode, long intime, CommodityLocation location, String destination) {
		this.id = id;
		this.ordercode = ordercode;
		this.intime = intime;
		Location = location;
		this.destination = destination;
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
		return Location;
	}
	public void setLocation(CommodityLocation location) {
		Location = location;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public long getId() {
		return id;
	}
	
}
