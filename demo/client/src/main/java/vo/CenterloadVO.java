package vo;

import java.util.List;

import po.Formstate;

public class CenterloadVO {
	long id;
	long loadtime;
	String motorcode;
	String destination;
	String vehiclecode;
	String supervisor;
	String supercargo;
	List<String> allbarcode;
	Formstate documentstate;
	public CenterloadVO(long loadtime, String motorcode, String destination, String vehiclecode, String supervisor,
			String supercargo, List<String> allbarcode,Formstate documentstate) {
		this.loadtime = loadtime;
		this.motorcode = motorcode;
		this.destination = destination;
		this.vehiclecode = vehiclecode;
		this.supervisor = supervisor;
		this.supercargo = supercargo;
		this.allbarcode = allbarcode;
		this.documentstate=documentstate;
	}


	public long getLoadtime() {
		return loadtime;
	}
	public String getMotorcode() {
		return motorcode;
	}
	public String getDestination() {
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
	public Formstate GETFormstate(){
		return documentstate;
	}
}
