package businesslogic.transportbl.VehiclePack;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.VehicleVO;
import businesslogicservice.transportblservice.VehicleBlService;

public class VehicleController implements VehicleBlService{

	

	@Override
	public ResultMessage addVehicle(VehicleVO vo)  {
		// TODO Auto-generated method stub
		AddVehicle add=new AddVehicle();
		Vehicle ve=new Vehicle(add);
		ResultMessage result=ve.addVehicle(vo);
		return result;
	}

	@Override
	public ResultMessage delVehicle(VehicleVO vo)  {
		// TODO Auto-generated method stub
		DelVehicle del=new DelVehicle();
		Vehicle ve=new Vehicle(del);
		ResultMessage result=ve.delVehicle(vo);
		return result;
	}

	@Override
	public ResultMessage revVehicle(VehicleVO vo) {
		// TODO Auto-generated method stub
		RevVehicle rev=new RevVehicle();
		Vehicle ve=new Vehicle(rev);
		ResultMessage result=ve.revVehicle(vo);
		return result;
	}

	@Override
	public VehicleVO getVehiclebyVN(String vehicleCode,String orgcode)
			 {
		// TODO Auto-generated method stub

		FindVehicle find=new FindVehicle();
		Vehicle ve=new Vehicle(find);
		VehicleVO vogot=ve.getVehiclebyVN(vehicleCode,orgcode);
		return vogot;
	}

	@Override
	public VehicleVO getVehiclebyPN(String plateNumber,String orgcode)  {
		// TODO Auto-generated method stub

		FindVehicle find=new FindVehicle();
		Vehicle ve=new Vehicle(find);

		VehicleVO  vogot=ve.getVehiclebyPN(plateNumber,orgcode);
		return vogot;
	}

	@Override
	public String getid(String orgcode)  {
		IdGet idgetter=new IdGet();
		String  id=idgetter.getid(orgcode);
		return id;
	}

}
