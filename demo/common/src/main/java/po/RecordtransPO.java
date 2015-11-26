package po;
import java.io.Serializable;
import java.util.List;

public class RecordtransPO  implements Serializable{
	long id;
	long loadtime;
	long arrivaltime;
	String transcode;
	String flightcode;
	String departrue;
	String destination;
	String countercode;
	String supervisor;
	List<String> allcode;
	double fee;
	Formstate documentstate;
	public RecordtransPO(long id,long loadtime, long arrivaltime, String transcode, String flightcode, String departrue,
			String destination, String countercode, String supervisor, List<String> allcode, double fee) {
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
	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}
	public void setFlightcode(String flightcode) {
		this.flightcode = flightcode;
	}
	public void setDepartrue(String departrue) {
		this.departrue = departrue;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setCountercode(String countercode) {
		this.countercode = countercode;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public void setAllcode(List<String> allcode) {
		this.allcode = allcode;
	}
	public void setFee(double fee) {
		this.fee = fee;
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
	public double getFee() {
		return fee;
	}
	
	
}