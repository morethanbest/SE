package dataservice.transportdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ResultMessage;
import po.VehiclesPO;

public interface VehicleDataService extends Remote {
	public ResultMessage insertVehicle(VehiclesPO po)throws RemoteException;
	
	public ResultMessage deleteVehicle(VehiclesPO po)throws RemoteException;
	
	public ResultMessage updateVehicle(VehiclesPO po)throws RemoteException;
	
	public VehiclesPO findVehicleBycode(String identity)throws RemoteException;

	public VehiclesPO findVehicleByPlateNumber(String plateNumber) throws RemoteException;

	public long getCurrentID(String orgcode) throws RemoteException;
}
