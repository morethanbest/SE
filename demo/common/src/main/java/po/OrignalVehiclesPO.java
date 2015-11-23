package po;

import java.io.Serializable;

public class OrignalVehiclesPO implements Serializable {
	String vehiclecode;
	String vehiclenum;
	long extendtime;
	public OrignalVehiclesPO(String vehiclecode, String vehiclenum, long extendtime) {
		this.vehiclecode = vehiclecode;
		this.vehiclenum = vehiclenum;
		this.extendtime = extendtime;
	}
	public String getVehiclecode() {
		return vehiclecode;
	}
	public String getVehiclenum() {
		return vehiclenum;
	}
	public long getExtendtime() {
		return extendtime;
	}
}