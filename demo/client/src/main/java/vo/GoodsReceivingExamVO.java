package vo;

import po.Arrivalstate;
import po.Formstate;


public class GoodsReceivingExamVO {
	long arrivaltime;
	String transcode;
	String departure;
	Arrivalstate arrivalstate;
	Formstate documentstate;
	
	public GoodsReceivingExamVO(long arrivaltime,String transcode,String departure,Arrivalstate arrivalstate){
		this.arrivaltime=arrivaltime;
		this.transcode=transcode;
		this.departure=departure;
		this.arrivalstate=arrivalstate;
		this.documentstate=Formstate.waiting;
	}
	public void setDocumentstate(Formstate documentstate){
		this.documentstate=documentstate;
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

	public Formstate getDocumentstate(){
		return this.documentstate;
	}
	public long getArrivaltime(){
		return this.arrivaltime;
	}
	public String getTranscode(){
		return this.transcode;
	}
	public String getDeparture(){
		return this.departure;
	}
	public Arrivalstate getArrivalstate(){
		return this.arrivalstate;
	}
	
}