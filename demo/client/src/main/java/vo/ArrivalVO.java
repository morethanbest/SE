package vo;

import po.Arrivalstate;
import po.Formstate;

public class ArrivalVO {

	long id;
	String centercode;
	long arrivaltime;
	String transcode;

	String departure;
	Arrivalstate arrivalstate;
	Formstate documentstate;
	public ArrivalVO(long id,String centercode, long arrivaltime, String transcode, String departure, Arrivalstate arrivalstate, Formstate documentstate) {
		this.id=id;
		this.centercode = centercode;
		this.arrivaltime = arrivaltime;
		this.transcode = transcode;
		this.departure = departure;
		this.arrivalstate = arrivalstate;
		this.documentstate=documentstate;
	}


	
	public long getId(){return this.id;}
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

	public Formstate getFormstate(){
		return this.documentstate;
	}

}