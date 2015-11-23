package businesslogic.transportbl.VehiclePack;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.VehicleVO;
import businesslogicservice.transportblservice.VehicleBlService;

public class VehicleController implements VehicleBlService{

	

	@Override
	public ResultMessage addVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		AddVehicleMock add=new AddVehicleMock();
		Vehicle ve=new Vehicle(add);
		ResultMessage result=ve.addVehicle(vo);
		return result;
	}

	@Override
	public ResultMessage delVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		DelVehicleMock del=new DelVehicleMock();
		Vehicle ve=new Vehicle(del);
		ResultMessage result=ve.delVehicle(vo);
		return result;
	}

	@Override
	public ResultMessage revVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		RevVehicleMock rev=new RevVehicleMock();
		Vehicle ve=new Vehicle(rev);
		ResultMessage result=ve.revVehicle(vo);
		return result;
	}

	@Override
	public VehicleVO getVehiclebyVN(String vehicleCode)
			throws RemoteException {
		// TODO Auto-generated method stub
		VehicleVO vo=new VehicleVO(vehicleCode,"1",1);
		FindVehicleMock find=new FindVehicleMock(vo);
		Vehicle ve=new Vehicle(find);
		VehicleVO vogot=ve.getVehiclebyVN(vehicleCode);
		return vogot;
	}

	@Override
	public VehicleVO getVehiclebyPN(String plateNumber) throws RemoteException {
		// TODO Auto-generated method stub
		VehicleVO vo=new VehicleVO("1",plateNumber,1);
		FindVehicleMock find=new FindVehicleMock(vo);
		Vehicle ve=new Vehicle(find);
		VehicleVO  vogot=ve.getVehiclebyPN(plateNumber);
		return vogot;
	}

}
