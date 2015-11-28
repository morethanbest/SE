package vo;

import po.Arrivalstate;
import po.Formstate;

public class GoodsReceivingVO {
	String id;
	long arrivaltime;
	String transcode;
	String departure;
	Arrivalstate arrivalstate;
	Formstate documentstate;
	public GoodsReceivingVO(String id,long arrivaltime,String transcode,String departure,Arrivalstate arrivalstate,Formstate state){
		this.id=id;
		this.arrivaltime=arrivaltime;
		this.transcode=transcode;
		this.departure=departure;
		this.arrivalstate=arrivalstate;
		this.documentstate=state;
	}

	public String getid(){ return this.id;}
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
	public Formstate getFormstate(){return this.documentstate;}
}
