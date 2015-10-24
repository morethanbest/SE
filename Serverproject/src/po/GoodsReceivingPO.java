package po;

import java.io.Serializable;

public class GoodsReceivingPO  implements Serializable{
	long id;
	long arrivaltime;
	long transcode;
	Hall departure;
	Arrivalstate arrivalstate;
	Formstate documentstate;
	
	public GoodsReceivingPO(long id,long arrivaltime,long transcode,Hall departure,Arrivalstate arrivalstate){
		this.id=id;
		this.arrivaltime=arrivaltime;
		this.transcode=transcode;
		this.departure=departure;
		this.arrivalstate=arrivalstate;
		this.documentstate=Formstate.waiting;
	}
	public long getId() {
		return id;
	}
	public void setDocumentstate(Formstate documentstate){
		this.documentstate=documentstate;
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

	public Formstate getDocumentstate(){
		return this.documentstate;
	}
	public long getArrivaltime(){
		return this.arrivaltime;
	}
	public long getTranscode(){
		return this.transcode;
	}
	public Hall getDeparture(){
		return this.departure;
	}
	public Arrivalstate getArrivalstate(){
		return this.arrivalstate;
	}
	
}
