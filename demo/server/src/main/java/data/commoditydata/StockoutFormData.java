package data.commoditydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.commodityDB.StockoutDB;
import dataservice.commoditydataservice.StockoutFormDataService;
import po.Formstate;
import po.ResultMessage;
import po.StockoutPO;

public class StockoutFormData extends UnicastRemoteObject implements StockoutFormDataService{

	public StockoutFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage updateStockoutForm(StockoutPO po) throws RemoteException {
		if(po!=null)
			return StockoutDB.update(po);
		else
			return ResultMessage.failure;
	}

	@Override
	public ResultMessage addStockoutForm(StockoutPO po) throws RemoteException {
		if(po!=null)
			return StockoutDB.write(po);
		else
			return ResultMessage.failure;
		
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
