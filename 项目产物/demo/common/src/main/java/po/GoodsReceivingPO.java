package po;

import java.io.Serializable;

public class GoodsReceivingPO  implements Serializable{
	String id;
	long arrivaltime;

	boolean whefromhall;
	String transcode;
	String departure;
	Arrivalstate arrivalstate;
	Formstate documentstate;
	
	public GoodsReceivingPO(String id,long arrivaltime,boolean whefromhall,String transcode,String departure,Arrivalstate arrivalstate,Formstate state){
		this.id=id;
		this.arrivaltime=arrivaltime;

		this.whefromhall=whefromhall;
		this.transcode=transcode;
		this.departure=departure;
		this.arrivalstate=arrivalstate;
		this.documentstate=state;
	}

	public boolean isWhefromhall() {
		return whefromhall;
	}

	public void setWhefromhall(boolean whefromhall) {
		this.whefromhall = whefromhall;
	}

	public void setid(String id){
		this.id=id;
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

	public String getId() {
		return id;
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
