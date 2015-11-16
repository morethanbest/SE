package vo;


import po.Arrivalstate;
import po.Formstate;
import po.Hall;

public class ArrivalExamVO {
	long id;
	String centercode;
	long arrivaltime;
	String transcode;
	Hall departure;
	Arrivalstate arrivalstate;
	Formstate documentstate;
	public ArrivalExamVO(long id,String centercode, long arrivaltime, String transcode, Hall departure, Arrivalstate arrivalstate,
			Formstate documentstate) {
		this.id=id;
		this.centercode = centercode;
		this.arrivaltime = arrivaltime;
		this.transcode = transcode;
		this.departure = departure;
		this.arrivalstate = arrivalstate;
		this.documentstate=documentstate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCentercode(String centercode) {
		this.centercode = centercode;
	}
	public void setArrivaltime(long arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public void setTranscode(String transcode) {
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
	public String getCentercode() {
		return centercode;
	}
	public long getArrivaltime() {
		return arrivaltime;
	}
	public String getTranscode() {
		return transcode;
	}
	public Hall getDeparture() {
		return departure;
	}
	public Arrivalstate getArrivalstate() {
		return arrivalstate;
	}
	
}
