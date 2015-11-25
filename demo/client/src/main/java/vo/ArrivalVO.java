package vo;

import po.Arrivalstate;
import po.Formstate;
import po.Hall;

import java.text.Normalizer;

public class ArrivalVO {
	String centercode;
	long arrivaltime;
	String transcode;
	Hall departure;
	Arrivalstate arrivalstate;
	Formstate documentstate;
	public ArrivalVO(String centercode, long arrivaltime, String transcode, Hall departure, Arrivalstate arrivalstate, Formstate documentstate) {
		this.centercode = centercode;
		this.arrivaltime = arrivaltime;
		this.transcode = transcode;
		this.departure = departure;
		this.arrivalstate = arrivalstate;
		this.documentstate=documentstate;
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

	public Formstate getFormstate(){
		return this.documentstate;
	}

}