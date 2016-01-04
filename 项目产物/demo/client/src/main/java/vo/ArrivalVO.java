package vo;

import po.Arrivalstate;
import po.Formstate;

public class ArrivalVO {

	String  id;//为中转中心的编号加上id
	String centercode;
	long arrivaltime;

	boolean whefromhall;
	String transcode;

	String departure;
	Arrivalstate arrivalstate;
	Formstate documentstate;
	public ArrivalVO(String id,String centercode, long arrivaltime,boolean whefromhall, String transcode, String departure, Arrivalstate arrivalstate, Formstate documentstate) {
		this.id=id;
		this.centercode = centercode;
		this.arrivaltime = arrivaltime;

		this.whefromhall=whefromhall;
		this.transcode = transcode;
		this.departure = departure;
		this.arrivalstate = arrivalstate;
		this.documentstate=documentstate;
	}


	
	public String getId(){return this.id;}
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

	public boolean getwhefromhall(){return this.whefromhall;}



	public void setDocumentstate(Formstate documentstate) {
		this.documentstate = documentstate;
	}
	
	

}