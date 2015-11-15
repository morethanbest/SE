package businesslogic.transportbl.VehiclePack;

import po.VehiclesPO;
import vo.ResultMessage;

public class DelVehicleMock {

	String vehiclecode;
	String vehiclenum;
	long extendtime;
	public void setDelVehicle(String vehiclecode,String vehiclenum,long extendtime) {
		// TODO Auto-generated constructor stub
		this.vehiclecode=vehiclecode;
		this.vehiclenum=vehiclenum;
		this.extendtime=extendtime;
	}
	
	
	
	
	public ResultMessage passdel(){
		VehiclesPO po=new VehiclesPO(vehiclecode,vehiclenum,extendtime);
		ResultMessage result=ResultMessage.success;
		return result;
	}

}
