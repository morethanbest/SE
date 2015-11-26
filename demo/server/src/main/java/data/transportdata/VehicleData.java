package data.transportdata;

import dataservice.transportdataservice.VehicleDataService;
import po.ResultMessage;
import po.VehiclesPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.database.transportDB.VehicleDB;

public class VehicleData extends UnicastRemoteObject implements VehicleDataService{

	public VehicleData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage insertVehicle(VehiclesPO po) throws RemoteException {
		return VehicleDB.write(po);
	}

	@Override
	public ResultMessage deleteVehicle(VehiclesPO po) throws RemoteException {
		return VehicleDB.delete(po);
	}

	@Override
	public ResultMessage updateVehicle(VehiclesPO po) throws RemoteException {
		return VehicleDB.update(po);
	}

	@Override
	public VehiclesPO findVehicleBycode(String identity) throws RemoteException {
		return VehicleDB.searchbycode(identity);
	}

	@Override
	public VehiclesPO findVehicleByPlateNumber(String plateNumber) throws RemoteException {
		return VehicleDB.searchbynum(plateNumber);
	}

	@Override
	public long getCurrentID(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return Long.parseLong(VehicleDB.getlastcode(orgcode));
	}



}
