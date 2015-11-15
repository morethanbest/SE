package Bldriver;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.VehicleVO;
import businesslogic.transportbl.blstub.VehicleBlService_Stub;
//import businesslogic.transportbl.VehicleBlService_Stub;
import businesslogicservice.transportblservice.VehicleBlService;

public class Vehicles_Driver {
    public void drive(VehicleBlService vehicleBlService) throws RemoteException{
    	VehicleVO vo=new VehicleVO(null, null, 0);
    	ResultMessage result =vehicleBlService.addVehicle(vo);
    	if(result==ResultMessage.success){
    		System.out.println("addVehicle succeeds");
    	}
    	else{
    		System.out.println("addVehicle fails");
    	}
    	
    	ResultMessage result1 =vehicleBlService.delVehicle(vo);
    	if(result1==ResultMessage.success){
    		System.out.println("delVehicle succeeds");
    	}
    	else{
    		System.out.println("delVehicle fails");
    	}
    	
    	ResultMessage result2 =vehicleBlService.revVehicle(vo);
    	if(result2==ResultMessage.success){
    		System.out.println("revVehicle succeeds");
    	}
    	else{
    		System.out.println("revVehicle fails");
    	}
    	
    	VehicleVO vo1=vehicleBlService.getVehiclebyVN("1");
    	if(vo1!=null){
    		System.out.println("getVehiclebyVN succeeds");
    	}
    	else{
    		System.out.println("getVehiclebyVN fails");
    	}
    	
    	VehicleVO vo2=vehicleBlService.getVehiclebyPN("1");
    	if(vo2!=null){
    		System.out.println("getVehiclebyPN succeeds");
    	}
    	else{
    		System.out.println("getVehiclebyPN fails");
    	}
    }
	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		VehicleBlService vehicleBlService=new VehicleBlService_Stub();
		Vehicles_Driver driver=new Vehicles_Driver();
		driver.drive(vehicleBlService);
	}

}
