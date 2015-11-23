package data.commoditydata;

import dataservice.commoditydataservice.StockoutFormDataService;
import po.Formstate;
import po.ResultMessage;
import po.StockoutPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class StockoutFormData extends UnicastRemoteObject implements StockoutFormDataService{

	public StockoutFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage updateStockoutForm(StockoutPO po) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage addStockoutForm(StockoutPO po) throws RemoteException {
		return null;
	}

	@Override
	public List<StockoutPO> getStockoutForm(Formstate state) throws RemoteException {
		return null;
	}
}
