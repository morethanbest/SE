package data.transportdata.driversAndStub;

import java.rmi.RemoteException;

import po.VehiclesPO;
import dataservice.transportdataservice.VehicleDataService;

public class VehicleDataService_Driver {
	public void drive(VehicleDataService VehicleDataService) throws RemoteException{
		VehicleDataService.insertVehicle(new VehiclesPO("00001","À’A 00000",3));
		VehicleDataService.deleteVehicle(new VehiclesPO("00001","À’A 00000",3));
		VehicleDataService.updateVehicle(new VehiclesPO("00001","À’A 00000",3));
		VehiclesPO po = VehicleDataService.findVehicle("00001");
		System.out.println("Got it!");
		System.out.println("Vehicle's platenumber is " + po.getVehiclenum());
	}
	public static void main(String[] args) throws RemoteException {
		VehicleDataService vehicleDataService = new VehicleDataService_Stub();
		VehicleDataService_Driver driver = new VehicleDataService_Driver();
		driver.drive(vehicleDataService);
	}

}
