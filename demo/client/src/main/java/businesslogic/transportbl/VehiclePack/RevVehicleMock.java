package businesslogic.transportbl.VehiclePack;

import po.VehiclesPO;
import vo.ResultMessage;

public class RevVehicleMock {

	String vehiclecode;
	String vehiclenum;
	long extendtime;
	public void setRevVehicle(String vehiclecode,String vehiclenum,long extendtime) {
		// TODO Auto-generated constructor stub
		this.vehiclecode=vehiclecode;
		this.vehiclenum=vehiclenum;
		this.extendtime=extendtime;
	}
	
	
	
	
	public ResultMessage passrev(){
		VehiclesPO po=new VehiclesPO(vehiclecode,vehiclenum,extendtime);
		ResultMessage result=ResultMessage.success;
		return result;
	}





	
	
}
