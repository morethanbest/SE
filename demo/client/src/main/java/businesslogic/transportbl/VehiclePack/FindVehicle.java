package businesslogic.transportbl.VehiclePack;

import dataservice.transportdataservice.VehicleDataService;
import init.RMIHelper;
import po.VehiclesPO;
import vo.VehicleVO;

import java.rmi.RemoteException;

public class FindVehicle {
	public boolean wheAt(String vehicleNumber, String orgcode) {
		try {

			long orgcodelen = orgcode.length();
			boolean whe = true;
			for (int i = 0; i <= orgcodelen - 1; i++) {
				if (!vehicleNumber.substring(i, i + 1).equals(orgcode.substring(i, i + 1))) {
					whe = false;
					break;
				}
			}
			return whe;

		} catch (Exception e) {
			return false;
		}
	}


	
	
	public VehicleVO getvehiclebyvn(String vehicleNumber,String orgcode){
		if(wheAt(vehicleNumber,orgcode)==false){
			return null;
		}
		VehicleDataService dataserv= RMIHelper.getVehicledata();
		VehicleVO vo=null;
		try {
			VehiclesPO po=dataserv.findVehicleBycode(vehicleNumber);
			String vehiclecode=po.getVehiclecode();
			String vehiclenum=po.getVehiclenum();
			long extendtime=po.getExtendtime();
			vo=new VehicleVO(vehiclecode,vehiclenum,extendtime);

			} catch (Exception e) {
			System.out.println("Find Vehicle By VehicleNumber Failed!!!");
			e.printStackTrace();
		}
		return vo;
	}
	
	public VehicleVO getvehiclebypn(String plateNumber,String orgcode){
		VehicleDataService dataserv=RMIHelper.getVehicledata();
		VehicleVO vo=null;
		try {
			VehiclesPO po=dataserv.findVehicleByPlateNumber(plateNumber);
			String vehiclecode=po.getVehiclecode();
			String vehiclenum=po.getVehiclenum();
			long extendtime=po.getExtendtime();

			if(wheAt(vehiclecode,orgcode)==true) {
				vo = new VehicleVO(vehiclecode, vehiclenum, extendtime);
			}
		} catch (Exception e) {
			System.out.println("Find Vehicle By PlateNumber Failed!!!");
			e.printStackTrace();
		}
		return vo;
	}

}
