package businesslogic.transportbl.VehiclePack;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.VehicleVO;

public class Vehicle {
	AddVehicleMock add;
	DelVehicleMock del;
	RevVehicleMock rev;
	FindVehicleMock find;
	public Vehicle(AddVehicleMock add){
		this.add=add;
	}
	public Vehicle(DelVehicleMock del){
		this.del=del;
	}
	public Vehicle(RevVehicleMock rev){
		this.rev=rev;
	}
	public Vehicle(FindVehicleMock find){
		this.find=find;
	}

	
	
	public ResultMessage addVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		String vehiclecode=vo.getVehiclecode();
		String vehiclenum=vo.getVehiclenum();
		long extendtime=vo.getExtendtime();
		add.setAddVehicle(vehiclecode, vehiclenum, extendtime);
		ResultMessage result=add.passadd();
		return result;
	}


	public ResultMessage delVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		String vehiclecode=vo.getVehiclecode();
		String vehiclenum=vo.getVehiclenum();
		long extendtime=vo.getExtendtime();
		del.setDelVehicle(vehiclecode, vehiclenum, extendtime);
		ResultMessage result=del.passdel();
		return result;
	}

	public ResultMessage revVehicle(VehicleVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		String vehiclecode=vo.getVehiclecode();
		String vehiclenum=vo.getVehiclenum();
		long extendtime=vo.getExtendtime();
		rev.setRevVehicle(vehiclecode, vehiclenum, extendtime);
		ResultMessage result=rev.passrev();
		return result;
	}

	
	public VehicleVO getVehiclebyVN(String vehicleNumber) throws RemoteException {
		// TODO Auto-generated method stub
		VehicleVO vo=find.getvehiclebyvn(vehicleNumber);
		return vo;
	}

	
	public VehicleVO getVehiclebyPN(String plateNumber) throws RemoteException {
		// TODO Auto-generated method stub
		VehicleVO vo=find.getvehiclebypn(plateNumber);
		return vo;
	}

}
