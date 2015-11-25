package businesslogicservice.transportblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.VehicleVO;

public interface VehicleBlService {
	public ResultMessage addVehicle (VehicleVO vo)throws RemoteException;
	
	public ResultMessage delVehicle (VehicleVO vo)throws RemoteException;
	
	public ResultMessage revVehicle (VehicleVO vo)throws RemoteException;
	
	public VehicleVO getVehiclebyVN (String vehicleNumber,String orgcode)throws RemoteException;
	
	public VehicleVO getVehiclebyPN (String plateNumber,String orgcode)throws RemoteException;

	public String getid(String orgcode) throws  RemoteException;


	
	
}
