package data.transportdata;

import java.rmi.RemoteException;

import po.DriversPO;
import dataservice.transportdataservice.DriversDataService;

public class DriversDataService_Stub implements DriversDataService{

	@Override
	public void insertDriver(DriversPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
	}

	@Override
	public void deleteDriver(DriversPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
	}

	@Override
	public void updateDriver(DriversPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
	}

	@Override
	public DriversPO findDriver(long identity) throws RemoteException {
		// TODO Auto-generated method stub
		DriversPO po=new DriversPO("025000001", "ÀîÍú", 19821024, "320682198201240572", "15205300460", "ÄÐ", 6);
		return po;
	}

	

}
