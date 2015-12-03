package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.*;

public interface StockinFormDataService extends Remote {
	public ResultMessage addStockinForm (StockinPO po)throws RemoteException;
	
	public List<StockinPO> getStockinForm (Formstate state,String orgcode)throws RemoteException;
	
	public ResultMessage updateStockinForm (StockinPO po)throws RemoteException;



	public long getid(String orgcode)throws  RemoteException;

}
