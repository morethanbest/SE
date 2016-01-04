package po;
import java.io.Serializable;
import java.util.List;

public class RecordtransPO  implements Serializable{

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
	Formstate documentstate;
	public RecordtransPO(long loadtime,  String transcode,  String transport,String transportcode, String departrue,
			String destination, String countercode, String supervisor, List<String> allcode, double fee,Formstate state) {

		this.loadtime = loadtime;

		this.transcode = transcode;
		this.transport=transport;
		this.transportcode=transportcode;
		this.departrue = departrue;
		this.destination = destination;
		this.countercode = countercode;
		this.supervisor = supervisor;
		this.allcode = allcode;
		this.fee = fee;
		this.documentstate=state;
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

	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}
	public void setTransport(String transport){this.transport=transport;}
	public void setTransportCode(String transportcode){this.transportcode=transportcode;}
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
	public void setformstate(Formstate state){this.documentstate=state;}

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
	public double getFee() {
		return fee;
	}
	
	
}