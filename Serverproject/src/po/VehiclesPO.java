package po;
import java.io.Serializable;

public class VehiclesPO  implements Serializable{
	String vehiclecode;
	String vehiclenum;
	long extendtime;
	public VehiclesPO(String vehiclecode, String vehiclenum, long extendtime) {
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
	public void setVehiclecode(String vehiclecode) {
		this.vehiclecode = vehiclecode;
	}
	public void setVehiclenum(String vehiclenum) {
		this.vehiclenum = vehiclenum;
	}
	public void setExtendtime(long extendtime) {
		this.extendtime = extendtime;
	}
	
}
