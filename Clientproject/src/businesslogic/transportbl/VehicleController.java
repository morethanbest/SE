package businesslogic.transportbl;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.VehicleVO;
import businesslogicservice.transportblservice.VehicleBlService;

public class VehicleController implements VehicleBlService{

	public VehicleController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage addVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage revVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleVO getVehiclebyVN(String vehicleNumber)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VehicleVO getVehiclebyPN(String plateNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
