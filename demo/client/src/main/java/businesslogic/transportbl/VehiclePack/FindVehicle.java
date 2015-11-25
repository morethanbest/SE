package businesslogic.transportbl.VehiclePack;

import dataservice.transportdataservice.VehicleDataService;
import init.RMIHelper;
import po.VehiclesPO;
import vo.VehicleVO;

import java.rmi.RemoteException;

public class FindVehicle {



	
	
	public VehicleVO getvehiclebyvn(String vehicleNumber){
		VehicleDataService dataserv= RMIHelper.getVehicledata();
		VehicleVO vo=null;
		try {
			VehiclesPO po=dataserv.findVehicleBycode(vehicleNumber);
			String vehiclecode=po.getVehiclecode();
			String vehiclenum=po.getVehiclenum();
			long extendtime=po.getExtendtime();
			vo=new VehicleVO(vehiclecode,vehiclenum,extendtime);

			} catch (RemoteException e) {
			System.out.println("Find Vehicle By VehicleNumber Failed!!!");
			e.printStackTrace();
		}
		return vo;
	}
	
	public VehicleVO getvehiclebypn(String plateNumber){
		VehicleDataService dataserv=RMIHelper.getVehicledata();
		VehicleVO vo=null;
		try {
			VehiclesPO po=dataserv.findVehicleByPlateNumber(plateNumber);
			String vehiclecode=po.getVehiclecode();
			String vehiclenum=po.getVehiclenum();
			long extendtime=po.getExtendtime();
			vo=new VehicleVO(vehiclecode,vehiclenum,extendtime);
		} catch (RemoteException e) {
			System.out.println("Find Vehicle By PlateNumber Failed!!!");
			e.printStackTrace();
		}
		return vo;
	}

}
