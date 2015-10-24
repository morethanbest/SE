package businesslogicservice.transportblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.VehicleVO;

public interface VehicleBlService {
	public ResultMessage addVehicle (VehicleVo vo)throws RemoteException;
	
	public ResultMessage delVehicle ()throws RemoteException;
	
	public ResultMessage revVehicle (VehicleVo vo)throws RemoteException;
	
	public ResultMessage getVehiclebyVN (long vehicleNumber)throws RemoteException;
	
	public ResultMessage getVehiclebyPN (long plateNumber)throws RemoteException;
	
	
}
