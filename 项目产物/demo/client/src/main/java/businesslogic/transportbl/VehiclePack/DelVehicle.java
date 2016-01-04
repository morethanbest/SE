package businesslogic.transportbl.VehiclePack;

import dataservice.transportdataservice.VehicleDataService;
import init.RMIHelper;
import po.VehiclesPO;
import po.ResultMessage;

import java.rmi.RemoteException;

public class DelVehicle {

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
		VehicleDataService dataserv= RMIHelper.getVehicledata();
		ResultMessage result= null;
		try {
			result = dataserv.deleteVehicle(po);
		} catch (RemoteException e) {
			System.out.println("Delete Vehicle Failed!!!");
			result=ResultMessage.failure;
			e.printStackTrace();
		}
		return result;
	}

}
