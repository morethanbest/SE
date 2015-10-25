package vo;

public class VehicleVO {
	String vehiclecode;
	String vehiclenum;
	long extendtime;
	public VehicleVO(String vehiclecode, String vehiclenum, long extendtime) {
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