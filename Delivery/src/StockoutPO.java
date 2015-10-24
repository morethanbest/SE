import java.io.Serializable;

public class StockoutPO  implements Serializable{
	long id;
	long ordercode;
	long outtime;
	Hall destination;
	Loadform loadform;
	long transcode;
	long motorcode;
	Formstate documentstate;
	public StockoutPO(long id,long ordercode, long outtime, Hall destination, Loadform loadform, long transcode, long motorcode) {
		this.id=id;
		this.ordercode = ordercode;
		this.outtime = outtime;
		this.destination = destination;
		this.loadform = loadform;
		this.transcode = transcode;
		this.motorcode = motorcode;
		this.documentstate=Formstate.waiting;
	}
	public long getId() {
		return id;
	}
	public Formstate getDocumentstate() {
		return documentstate;
	}
	public void setOrdercode(long ordercode) {
		this.ordercode = ordercode;
	}
	public void setOuttime(long outtime) {
		this.outtime = outtime;
	}
	public void setDestination(Hall destination) {
		this.destination = destination;
	}
	public void setLoadform(Loadform loadform) {
		this.loadform = loadform;
	}
	public void setTranscode(long transcode) {
		this.transcode = transcode;
	}
	public void setMotorcode(long motorcode) {
		this.motorcode = motorcode;
	}
	public void setDocumentstate(Formstate documentstate) {
		this.documentstate = documentstate;
	}
	public long getOrdercode() {
		return ordercode;
	}
	public long getOuttime() {
		return outtime;
	}
	public Hall getDestination() {
		return destination;
	}
	public Loadform getLoadform() {
		return loadform;
	}
	public long getTranscode() {
		return transcode;
	}
	public long getMotorcode() {
		return motorcode;
	}
	
	
}
