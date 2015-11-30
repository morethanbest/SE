package po;
import java.io.Serializable;
import java.text.Normalizer;

public class StockinPO  implements Serializable{
	String id;
	String ordercode;
	long intime;
	CommodityLocation Location;
	String destination;
	Formstate formstate;
	public StockinPO(String id, String ordercode, long intime, CommodityLocation location, String destination,Formstate formstate) {
		this.id = id;
		this.ordercode = ordercode;
		this.intime = intime;
		Location = location;
		this.destination = destination;
		this.formstate=formstate;
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
	public String getId() {
		return id;
	}
	public void setId(String id){this.id=id;}

	public void setFormstate(Formstate state){this.formstate=state;}
	public Formstate getFormstate(){
		return  formstate;
	}
	
}
