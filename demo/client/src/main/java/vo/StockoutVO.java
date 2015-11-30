package vo;

import po.Formstate;
import po.Loadform;

public class StockoutVO {
	String id;
	String ordercode;
	long outtime;
	String destination;
	String transporttype;
	String transcode;

	Formstate formstate;
	public StockoutVO(String id,String ordercode, long outtime, String destination, String transporttype, String transcode,
			Formstate formstate) {
		this.id=id;
		this.ordercode = ordercode;
		this.outtime = outtime;
		this.destination = destination;
		this.transporttype=transporttype;
		this.transcode = transcode;
		this.formstate=formstate;
	}
	public String getId(){return id;}
	public String getOrdercode() {
		return ordercode;
	}
	public long getOuttime() {
		return outtime;
	}
	public String getDestination() {
		return destination;
	}
	public String getTransportType() {
		return transporttype;
	}
	public String getTranscode() {
		return transcode;
	}
	public Formstate getFormstate() {
		return formstate;
	}
	
	
}
