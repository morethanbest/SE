package data.transportdata;

import dataservice.transportdataservice.DriversDataService;
import po.DriversPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Driver;

public class DriversData extends UnicastRemoteObject implements DriversDataService{

	public DriversData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage insertDriver(DriversPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage deleteDriver(DriversPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateDriver(DriversPO po) throws RemoteException {
		return null;
	}

	@Override
	public DriversPO findDriver(String identity) throws RemoteException {
		return null;
	}
}
