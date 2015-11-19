package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.StockoutPO;
import vo.ResultMessage;

public interface StockoutFormDataService {
	public ResultMessage updateStockoutForm (StockoutPO po)throws RemoteException;
	
	public ResultMessage addStockoutForm (StockoutPO po)throws RemoteException;
	
	public List<StockoutPO> getStockoutForm (Formstate state)throws RemoteException;
}
