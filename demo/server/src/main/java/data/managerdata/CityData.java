package data.managerdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

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
		return null;
	}

	@Override
	public ResultMessage deleteCity(CityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateCity(CityPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityPO> getAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityPO findCity(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
