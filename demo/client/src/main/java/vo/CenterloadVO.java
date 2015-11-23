package vo;

import java.util.List;

import po.Hall;

public class CenterloadVO {
	long loadtime;
	String motorcode;
	Hall destination;
	String vehiclecode;
	String supervisor;
	String supercargo;
	List<String> allbarcode;
	public CenterloadVO(long loadtime, String motorcode, Hall destination, String vehiclecode, String supervisor,
			String supercargo, List<String> allbarcode) {
		this.loadtime = loadtime;
		this.motorcode = motorcode;
		this.destination = destination;
		this.vehiclecode = vehiclecode;
		this.supervisor = supervisor;
		this.supercargo = supercargo;
		this.allbarcode = allbarcode;
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
	
}
