import java.io.Serializable;

public class ArrivalPO  implements Serializable{
	long centercode;
	long arrivaltime;
	long transcode;
	Hall departure;
	Arrivalstate arrivalstate;
	Formstate documentstate;
	long id;
	public ArrivalPO(long id,long centercode, long arrivaltime, long transcode, Hall departure, Arrivalstate arrivalstate) {
		this.id=id;
		this.centercode = centercode;
		this.arrivaltime = arrivaltime;
		this.transcode = transcode;
		this.departure = departure;
		this.arrivalstate = arrivalstate;
		this.documentstate=Formstate.waiting;
	}
	public long getId() {
		return id;
	}
	public void setCentercode(long centercode) {
		this.centercode = centercode;
	}
	public void setArrivaltime(long arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public void setTranscode(long transcode) {
		this.transcode = transcode;
	}
	public void setDeparture(Hall departure) {
		this.departure = departure;
	}
	public void setArrivalstate(Arrivalstate arrivalstate) {
		this.arrivalstate = arrivalstate;
	}
	public Formstate getDocumentstate() {
		return documentstate;
	}
	public void setDocumentstate(Formstate documentstate) {
		this.documentstate = documentstate;
	}
	public long getCentercode() {
		return centercode;
	}
	public long getArrivaltime() {
		return arrivaltime;
	}
	public long getTranscode() {
		return transcode;
	}
	public Hall getDeparture() {
		return departure;
	}
	public Arrivalstate getArrivalstate() {
		return arrivalstate;
	}
	
}
