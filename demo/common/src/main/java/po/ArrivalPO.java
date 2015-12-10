package po;

import java.io.Serializable;

public class ArrivalPO  implements Serializable{
	String id;
	String centercode;
	long arrivaltime;

	boolean whefromhall;
	String transcode;
	String departure;
	Arrivalstate arrivalstate;
	Formstate documentstate;

	public ArrivalPO(String id,String centercode, long arrivaltime,boolean whefromhall, String transcode, String departure, Arrivalstate arrivalstate,Formstate documentstate) {
		this.id=id;
		this.centercode = centercode;
		this.arrivaltime = arrivaltime;

		this.whefromhall=whefromhall;
		this.transcode = transcode;
		this.departure = departure;
		this.arrivalstate = arrivalstate;
		this.documentstate=documentstate;
	}
	public void setId(String id){this.id=id;}
	public void setCentercode(String centercode) {
		this.centercode = centercode;
	}
	public void setArrivaltime(long arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}
	public void setDeparture(String departure) {
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
	public String getCentercode() {
		return centercode;
	}
	public long getArrivaltime() {
		return arrivaltime;
	}
	public String getTranscode() {
		return transcode;
	}
	public String getDeparture() {
		return departure;
	}
	public Arrivalstate getArrivalstate() {
		return arrivalstate;
	}
	public String getId(){return this.id;}

	public boolean isWhefromhall() {
		return whefromhall;
	}

	public void setWhefromhall(boolean whefromhall) {
		this.whefromhall = whefromhall;
	}
}
