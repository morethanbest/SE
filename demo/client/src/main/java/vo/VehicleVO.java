package vo;

public class VehicleVO {
	String vehiclecode;
	String platenum;
	long extendtime;
	public VehicleVO(String vehiclecode, String platenum, long extendtime) {
		this.vehiclecode = vehiclecode;
		this.platenum = platenum;
		this.extendtime = extendtime;
	}
	public String getVehiclecode() {
		return vehiclecode;
	}
	public String getVehiclenum() {
		return platenum;
	}
	public long getExtendtime() {
		return extendtime;
	}
}
