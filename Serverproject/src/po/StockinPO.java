package po;
import java.io.Serializable;

public class StockinPO  implements Serializable{
	long id;
	String ordercode;
	long intime;
	CommodityLocation Location;
	City destination;
	Formstate documentstate;
	public StockinPO(long id, String ordercode, long intime, CommodityLocation location,City destination) {
		this.id = id;
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
	public City getDestination() {
		return destination;
	}
	public void setDestination(City destination) {
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
	public long getId() {
		return id;
	}

	
}
