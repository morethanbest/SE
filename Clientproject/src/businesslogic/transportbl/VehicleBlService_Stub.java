package businesslogic.transportbl;

import java.rmi.RemoteException;

import businesslogicservice.transportblservice.VehicleBlService;
import vo.ResultMessage;
import vo.VehicleVO;

public class VehicleBlService_Stub implements VehicleBlService {

	@Override
	public ResultMessage addVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage delVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage revVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public VehicleVO getVehiclebyVN(String vehicleNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return new VehicleVO("1","1",1);
	}

	@Override
	public VehicleVO getVehiclebyPN(String plateNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return new VehicleVO("1","1",1);
	}

}
