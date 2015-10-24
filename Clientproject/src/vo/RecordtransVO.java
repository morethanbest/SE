package vo;

import java.util.List;

import po.Hall;

public class RecordtransVO {
	long loadtime;
	long arrivaltime;
	String transcode;
	String flightcode;
	Hall departrue;
	Hall destination;
	long countercode;
	String supervisor;
	List<String> allcode;
	public RecordtransVO(long loadtime, long arrivaltime, String transcode, String flightcode, Hall departrue,
			Hall destination, long countercode, String supervisor, List<String> allcode) {
		this.loadtime = loadtime;
		this.arrivaltime = arrivaltime;
		this.transcode = transcode;
		this.flightcode = flightcode;
		this.departrue = departrue;
		this.destination = destination;
		this.countercode = countercode;
		this.supervisor = supervisor;
		this.allcode = allcode;
	}

	public long getLoadtime() {
		return loadtime;
	}
	public long getArrivaltime() {
		return arrivaltime;
	}
	public String getTranscode() {
		return transcode;
	}
	public String getFlightcode() {
		return flightcode;
	}
	public Hall getDepartrue() {
		return departrue;
	}
	public Hall getDestination() {
		return destination;
	}
	public long getCountercode() {
		return countercode;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public List<String> getAllcode() {
		return allcode;
	}
	
}