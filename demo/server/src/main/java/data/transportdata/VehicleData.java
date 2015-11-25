package data.transportdata;

import dataservice.transportdataservice.VehicleDataService;
import po.ResultMessage;
import po.VehiclesPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class VehicleData extends UnicastRemoteObject implements VehicleDataService{

	public VehicleData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage insertVehicle(VehiclesPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deleteVehicle(VehiclesPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateVehicle(VehiclesPO po) throws RemoteException {
		return null;
	}

	@Override
	public VehiclesPO findVehicleBycode(String identity) throws RemoteException {
		return null;
	}

	@Override
	public VehiclesPO findVehicleByPlateNumber(String plateNumber) throws RemoteException {
		return null;
	}

	@Override
	public long getCurrentID() throws RemoteException {
		return 0;
	}


}
