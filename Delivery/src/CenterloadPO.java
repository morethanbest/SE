import java.io.Serializable;

public class CenterloadPO  implements Serializable{
	long id;
	long loadtime;
	long motorcode;
	Hall destination;
	long vehiclecode;
	String supervisor;
	String supercargo;
	long[] allbarcode;
	double fee;
	Formstate documentstate;
	public CenterloadPO(long id,long loadtime, long motorcode, Hall destination, long vehiclecode, String supervisor,
			String supercargo, long[] allbarcode, double fee) {
		this.loadtime = loadtime;
		this.motorcode = motorcode;
		this.destination = destination;
		this.vehiclecode = vehiclecode;
		this.supervisor = supervisor;
		this.supercargo = supercargo;
		this.allbarcode = allbarcode;
		this.fee = fee;
		this.documentstate=Formstate.waiting;
	}
	public long getId() {
		return id;
	}
	public void setLoadtime(long loadtime) {
		this.loadtime = loadtime;
	}
	public void setMotorcode(long motorcode) {
		this.motorcode = motorcode;
	}
	public void setDestination(Hall destination) {
		this.destination = destination;
	}
	public void setVehiclecode(long vehiclecode) {
		this.vehiclecode = vehiclecode;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public void setSupercargo(String supercargo) {
		this.supercargo = supercargo;
	}
	public void setAllbarcode(long[] allbarcode) {
		this.allbarcode = allbarcode;
	}
	public void setFee(double fee) {
		this.fee = fee;
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
	public long getMotorcode() {
		return motorcode;
	}
	public Hall getDestination() {
		return destination;
	}
	public long getVehiclecode() {
		return vehiclecode;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public String getSupercargo() {
		return supercargo;
	}
	public long[] getAllbarcode() {
		return allbarcode;
	}
	public double getFee() {
		return fee;
	}
	
}
