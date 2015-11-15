package businesslogic.transportbl.VehiclePack;

import vo.VehicleVO;

public class FindVehicleMock {

	VehicleVO vo;
	public FindVehicleMock(VehicleVO vo){
		this.vo=vo;
	}
	
	
	public VehicleVO getvehiclebyvn(String vehicleNumber){
		return vo;
	}
	
	public VehicleVO getvehiclebypn(String plateNumber){
		return vo;
	}

}
