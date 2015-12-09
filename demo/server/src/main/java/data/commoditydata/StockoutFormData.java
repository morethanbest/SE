package data.commoditydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import po.StockoutPO;
import data.database.CommodityDB.StockoutDB;
import dataservice.commoditydataservice.StockoutFormDataService;

public class StockoutFormData extends UnicastRemoteObject implements StockoutFormDataService{

	public StockoutFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage updateStockoutForm(StockoutPO po) throws RemoteException {
		return StockoutDB.update(po);
	}

	@Override
	public ResultMessage addStockoutForm(StockoutPO po) throws RemoteException {
		return StockoutDB.write(po);
	}

	@Override
	public List<StockoutPO> getStockoutForm(Formstate state, String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return StockoutDB.fuzzySearch(state, orgcode);
	}

	@Override
	public long getid(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return StockoutDB.getLastId(orgcode);
	}

	
}
