package po;
import java.io.Serializable;

public class RecordtransPO  implements Serializable{
	long id;
	long loadtime;
	long arrivaltime;
	long transcode;
	long flightcode;
	Hall departrue;
	Hall destination;
	long countercode;
	String supervisor;
	long[] allcode;
	double fee;
	Formstate documentstate;
	public RecordtransPO(long id,long loadtime, long arrivaltime, long transcode, long flightcode, Hall departrue,
			Hall destination, long countercode, String supervisor, long[] allcode, double fee) {
		this.id=id;
		this.loadtime = loadtime;
		this.arrivaltime = arrivaltime;
		this.transcode = transcode;
		this.flightcode = flightcode;
		this.departrue = departrue;
		this.destination = destination;
		this.countercode = countercode;
		this.supervisor = supervisor;
		this.allcode = allcode;
		this.fee = fee;
		this.documentstate=Formstate.waiting;
	}
	public long getId() {
		return id;
	}
	public Formstate getDocumentstate() {
		return documentstate;
	}
	public void setDocumentstate(Formstate documentstate) {
		this.documentstate = documentstate;
	}
	public long getLoadtime() {
		return loadtime;
	}
	public void setLoadtime(long loadtime) {
		this.loadtime = loadtime;
	}
	public void setArrivaltime(long arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
	public void setTranscode(long transcode) {
		this.transcode = transcode;
	}
	public void setFlightcode(long flightcode) {
		this.flightcode = flightcode;
	}
	public void setDepartrue(Hall departrue) {
		this.departrue = departrue;
	}
	public void setDestination(Hall destination) {
		this.destination = destination;
	}
	public void setCountercode(long countercode) {
		this.countercode = countercode;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public void setAllcode(long[] allcode) {
		this.allcode = allcode;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public long getArrivaltime() {
		return arrivaltime;
	}
	public long getTranscode() {
		return transcode;
	}
	public long getFlightcode() {
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
	public long[] getAllcode() {
		return allcode;
	}
	public double getFee() {
		return fee;
	}
	
	
}
