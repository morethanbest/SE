package data.transportdata;

import dataservice.transportdataservice.DriversDataService;
import po.DriversPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Driver;
import java.util.List;

import data.database.transportDB.DriverDB;

public class DriversData extends UnicastRemoteObject implements DriversDataService{

	public DriversData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage insertDriver(DriversPO po) throws RemoteException {
		return DriverDB.write(po);
	}

	@Override
	public ResultMessage deleteDriver(DriversPO po) throws RemoteException {
		return  DriverDB.delete(po);
	}

	@Override
	public ResultMessage updateDriver(DriversPO po) throws RemoteException {
		return DriverDB.update(po);
	}

	@Override
	public DriversPO findDriverBynum(String identity) throws RemoteException {
		return DriverDB.search(identity);
	}

	@Override
	public List<DriversPO> findDriverByname(String identity) throws RemoteException {
		return DriverDB.fuzzysearch(identity);
	}

	@Override
	public long getCurrentID(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return Long.parseLong(DriverDB.getlastcode(orgcode));
	}



}
