package dataservice.transportdataservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import po.VehiclesPO;

public interface VehicleDataService {
	public ResultMessage insertVehicle(VehiclesPO po)throws RemoteException;
	
	public ResultMessage deleteVehicle(VehiclesPO po)throws RemoteException;
	
	public ResultMessage updateVehicle(VehiclesPO po)throws RemoteException;
	
	public VehiclesPO findVehicle(String identity)throws RemoteException;
}
