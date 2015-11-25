package businesslogic.transportbl.VehiclePack;

import dataservice.transportdataservice.VehicleDataService;
import init.RMIHelper;
import po.VehiclesPO;
import po.ResultMessage;

import java.rmi.RemoteException;

public class AddVehicle {
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
		VehicleDataService dataserv= RMIHelper.getVehicledata();

		ResultMessage result= null;
		try {
			result = dataserv.insertVehicle(po);
		} catch (RemoteException e) {
			System.out.println("Add Vehicle Failed!!!");
			result=ResultMessage.failure;
			e.printStackTrace();
		}
		return result;
	}

	
	
	
	
	
}
