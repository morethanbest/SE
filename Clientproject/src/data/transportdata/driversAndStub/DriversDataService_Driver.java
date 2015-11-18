package data.transportdata.driversAndStub;

import java.rmi.RemoteException;

import po.DriversPO;
import dataservice.transportdataservice.DriversDataService;

public class DriversDataService_Driver {
	public void drive(DriversDataService driversDataService) throws RemoteException{
		driversDataService.insertDriver(new DriversPO("000001", "ÀîÍú", 19821024, "320682198201240572", "15205300460", "ÄÐ", 6));
		driversDataService.deleteDriver(new DriversPO("000001", "ÀîÍú", 19821024, "320682198201240572", "15205300460", "ÄÐ", 6));
		driversDataService.updateDriver(new DriversPO("000001", "ÀîÍú", 19821024, "320682198201240572", "15205300460", "ÄÐ", 6));
		DriversPO po = driversDataService.findDriver("000001");
		System.out.println("Got it!");
		System.out.println("Driver's name is" + po.getDrivername());
	}
	public static void main(String[] args) throws RemoteException {
		DriversDataService driversDataService = new DriversDataService_Stub();
		DriversDataService_Driver driver = new DriversDataService_Driver();
		driver.drive(driversDataService);
	}

}
