package vo;

import po.Arrivalstate;
import po.Hall;

public class GoodsReceivingVO {
	long arrivaltime;
	String transcode;
	Hall departure;
	Arrivalstate arrivalstate;
	
	public GoodsReceivingVO(long arrivaltime,String transcode,Hall departure,Arrivalstate arrivalstate){
		this.arrivaltime=arrivaltime;
		this.transcode=transcode;
		this.departure=departure;
		this.arrivalstate=arrivalstate;
	}


	public long getArrivaltime(){
		return this.arrivaltime;
	}
	public String getTranscode(){
		return this.transcode;
	}
	public Hall getDeparture(){
		return this.departure;
	}
	public Arrivalstate getArrivalstate(){
		return this.arrivalstate;
	}
	
}
