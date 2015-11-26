package vo;

import po.Loadform;

public class StockoutVO {
	String ordercode;
	long outtime;
	String destination;
	Loadform loadform;
	String transcode;
	String motorcode;
	public StockoutVO(String ordercode, long outtime, String destination, Loadform loadform, String transcode,
			String motorcode) {
		this.ordercode = ordercode;
		this.outtime = outtime;
		this.destination = destination;
		this.loadform = loadform;
		this.transcode = transcode;
		this.motorcode = motorcode;
	}
	public String getOrdercode() {
		return ordercode;
	}
	public long getOuttime() {
		return outtime;
	}
	public String getDestination() {
		return destination;
	}
	public Loadform getLoadform() {
		return loadform;
	}
	public String getTranscode() {
		return transcode;
	}
	public String getMotorcode() {
		return motorcode;
	}
	
	
}
