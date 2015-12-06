package vo;

import po.Formstate;

import java.util.List;

public class RecordtransVO {
	long loadtime;

	String transcode;
	String transport;//交通方式
	String transportcode;//班次号
	String departrue;
	String destination;
	String countercode;
	String supervisor;
	List<String> allcode;
	double fee;
	Formstate formstate;

	public RecordtransVO(long loadtime,  String transcode, String transport,String transportcode, String departrue,
			String destination, String countercode, String supervisor, List<String> allcode,double fee,Formstate state) {
		this.loadtime = loadtime;

		this.transcode = transcode;
		this.transport=transport;
		this.transportcode=transportcode;
		this.departrue = departrue;
		this.destination = destination;
		this.countercode = countercode;
		this.supervisor = supervisor;
		this.allcode = allcode;
		this.fee=fee;
		this.formstate=state;
	}

	public long getLoadtime() {
		return loadtime;
	}

	public String getTranscode() {
		return transcode;
	}
	public String getTransportType(){return transport;}

	public String getTransportCode() {
		return transportcode;
	}
	public String getDepartrue() {
		return departrue;
	}
	public String getDestination() {
		return destination;
	}
	public String getCountercode() {
		return countercode;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public List<String> getAllcode() {
		return allcode;
	}
	public double getfee(){return fee;}
	public Formstate getFormstate(){return formstate;}
}