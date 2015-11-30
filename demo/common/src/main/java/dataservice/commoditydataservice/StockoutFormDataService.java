package dataservice.commoditydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import po.StockoutPO;

public interface StockoutFormDataService extends Remote {
	public ResultMessage updateStockoutForm (StockoutPO po)throws RemoteException;
	
	public ResultMessage addStockoutForm (StockoutPO po)throws RemoteException;
	
	public List<StockoutPO> getStockoutForm (Formstate state,String orgcode)throws RemoteException;

	public long getid(String orgcode) throws  RemoteException;
}
