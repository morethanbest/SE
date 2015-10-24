package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.StockinPO;
import po.StockoutPO;

public interface StockoutFormDataService {
	public void updateStockinForm (StockinPO po)throws RemoteException;
	
	public void addStockoutForm (StockoutPO po)throws RemoteException;
	
	public List<StockoutPO> getStockoutForm (Formstate state)throws RemoteException;
}
