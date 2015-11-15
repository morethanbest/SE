package businesslogic.transportbl.VehiclePack;

import po.VehiclesPO;
import vo.ResultMessage;

public class AddVehicleMock {
	String vehiclecode;
	String vehiclenum;
	long extendtime;
	public void setAddVehicle(String vehiclecode,String vehiclenum,long extendtime) {
		
		this.vehiclecode=vehiclecode;
		this.vehiclenum=vehiclenum;
		this.extendtime=extendtime;
	}
	
	
	
	
	public ResultMessage passadd(){
		VehiclesPO po=new VehiclesPO(vehiclecode,vehiclenum,extendtime);
		ResultMessage result=ResultMessage.success;
		return result;
	}

	
	
	
	
	
}
