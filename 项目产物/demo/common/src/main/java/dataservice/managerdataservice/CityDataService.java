package dataservice.managerdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CityPO;
import po.ResultMessage;

public interface CityDataService extends Remote{
	
	public ResultMessage addCity (CityPO po)throws RemoteException;
	
	public ResultMessage deleteCity (CityPO po)throws RemoteException;

	public ResultMessage updateCity (CityPO po)throws RemoteException;
	
	public List<CityPO>  getAll()throws RemoteException;
	
	public CityPO findCity(String name)throws RemoteException;
}
