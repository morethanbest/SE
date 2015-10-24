package vo;

import po.Arrivalstate;
import po.Hall;

public class ArrivalVO {
	String centercode;
	long arrivaltime;
	String transcode;
	Hall departure;
	Arrivalstate arrivalstate;
	public ArrivalVO(String centercode, long arrivaltime, String transcode, Hall departure, Arrivalstate arrivalstate) {
		this.centercode = centercode;
		this.arrivaltime = arrivaltime;
		this.transcode = transcode;
		this.departure = departure;
		this.arrivalstate = arrivalstate;
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