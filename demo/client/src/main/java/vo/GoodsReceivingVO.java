package vo;

import po.Arrivalstate;

public class GoodsReceivingVO {
	long arrivaltime;
	String transcode;
	String departure;
	Arrivalstate arrivalstate;
	
	public GoodsReceivingVO(long arrivaltime,String transcode,String departure,Arrivalstate arrivalstate){
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
	public String getDeparture(){
		return this.departure;
	}
	public Arrivalstate getArrivalstate(){
		return this.arrivalstate;
	}
	
}
