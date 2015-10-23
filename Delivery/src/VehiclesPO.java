import java.io.Serializable;

public class VehiclesPO  implements Serializable{
	long vehiclecode;
	long vehiclenum;
	long extendtime;
	public VehiclesPO(long vehiclecode, long vehiclenum, long extendtime) {
		this.vehiclecode = vehiclecode;
		this.vehiclenum = vehiclenum;
		this.extendtime = extendtime;
	}
	public long getVehiclecode() {
		return vehiclecode;
	}
	public long getVehiclenum() {
		return vehiclenum;
	}
	public long getExtendtime() {
		return extendtime;
	}
	public void setVehiclecode(long vehiclecode) {
		this.vehiclecode = vehiclecode;
	}
	public void setVehiclenum(long vehiclenum) {
		this.vehiclenum = vehiclenum;
	}
	public void setExtendtime(long extendtime) {
		this.extendtime = extendtime;
	}
	
}
