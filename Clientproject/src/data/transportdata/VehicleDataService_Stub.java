package data.transportdata;

import java.rmi.RemoteException;

import po.VehiclesPO;
import dataservice.transportdataservice.VehicleDataService;

public class VehicleDataService_Stub implements VehicleDataService{

	@Override
	public void insertVehicle(VehiclesPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
	}

	@Override
	public void deleteVehicle(VehiclesPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
	}

	@Override
	public void updateVehicle(VehiclesPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
	}

	@Override
	public VehiclesPO findVehicle(String identity) throws RemoteException {
		// TODO Auto-generated method stub
		VehiclesPO po=new VehiclesPO(identity,"À’A 00000",3);
		return po;
	}

	

}
