package vo;

import java.util.List;

import po.Formstate;
import po.Hall;

public class CLFormsExamVO {
	long loadtime;
	String motorcode;
	Hall destination;
	String vehiclecode;
	String supervisor;
	String supercargo;
	List<String> allbarcode;
	double fee;
	Formstate documentstate;
	public CLFormsExamVO(long loadtime, String motorcode, Hall destination, String vehiclecode, String supervisor,
			String supercargo, List<String> allbarcode, double fee) {
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

	public void setLoadtime(long loadtime) {
		this.loadtime = loadtime;
	}
	public void setMotorcode(String motorcode) {
		this.motorcode = motorcode;
	}
	public void setDestination(Hall destination) {
		this.destination = destination;
	}
	public void setVehiclecode(String vehiclecode) {
		this.vehiclecode = vehiclecode;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public void setSupercargo(String supercargo) {
		this.supercargo = supercargo;
	}
	public void setAllbarcode(List<String> allbarcode) {
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
	public String getMotorcode() {
		return motorcode;
	}
	public Hall getDestination() {
		return destination;
	}
	public String getVehiclecode() {
		return vehiclecode;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public String getSupercargo() {
		return supercargo;
	}
	public List<String> getAllbarcode() {
		return allbarcode;
	}
	public double getFee() {
		return fee;
	}
	
}
