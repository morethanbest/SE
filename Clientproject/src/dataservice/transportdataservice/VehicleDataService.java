package dataservice.transportdataservice;

import java.rmi.RemoteException;

import po.VehiclesPO;

public interface VehicleDataService {
	public void insertVehicle(VehiclesPO po)throws RemoteException;
	
	public void deleteVehicle(VehiclesPO po)throws RemoteException;
	
	public void updateVehicle(VehiclesPO po)throws RemoteException;
	
	public VehiclesPO findVehicle(long identity)throws RemoteException;
}
