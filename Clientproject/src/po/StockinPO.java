package po;
import java.io.Serializable;

public class StockinPO  implements Serializable{
	long id;
	long ordercode;
	long intime;
	CommodityLocation Location;
	Formstate documentstate;
	public StockinPO(long id, long ordercode, long intime, CommodityLocation location) {
		this.id = id;
		this.ordercode = ordercode;
		this.intime = intime;
		Location = location;
		this.documentstate=Formstate.waiting;
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
