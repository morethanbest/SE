package po;
import java.io.Serializable;

public class StockoutPO  implements Serializable{
	String id;
	String ordercode;
	long outtime;
	String destination;
	String transporttype;
	String transcode;

	Formstate formstate;
	public StockoutPO(String id,String ordercode, long outtime, String destination, String transporttype, String transcode,
					  Formstate formstate) {
		this.id=id;
		this.ordercode = ordercode;
		this.outtime = outtime;
		this.destination = destination;
		this.transporttype=transporttype;
		this.transcode = transcode;
		this.formstate=formstate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrdercode() {
		return ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public long getOuttime() {
		return outtime;
	}

	public void setOuttime(long outtime) {
		this.outtime = outtime;
	}

	public String getDestination() {
		return destination;
	}

	public String getTransporttype() {
		return transporttype;
	}

	public void setTransporttype(String transporttype) {
		this.transporttype = transporttype;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTranscode() {
		return transcode;
	}

	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}

	public Formstate getFormstate() {
		return formstate;
	}

	public void setFormstate(Formstate formstate) {
		this.formstate = formstate;
	}
}
