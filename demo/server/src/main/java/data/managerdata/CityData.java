package data.managerdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.managerDB.CityDB;
import dataservice.managerdataservice.CityDataService;
import po.CityPO;
import po.ResultMessage;

public class CityData extends UnicastRemoteObject implements CityDataService{
	public CityData() throws  RemoteException{
		super();
	}

	@Override
	public ResultMessage addCity(CityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return CityDB.write(po);
		else
			return ResultMessage.failure;
		
	}

	@Override
	public ResultMessage deleteCity(CityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return CityDB.delete(po);
		else
			return ResultMessage.failure;
		
	}

	@Override
	public ResultMessage updateCity(CityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return CityDB.update(po);
		else
			return ResultMessage.failure;
		
	}

	@Override
	public List<CityPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return CityDB.getAll();
	}

	@Override
	public CityPO findCity(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return CityDB.search(name);
	}
	
}
