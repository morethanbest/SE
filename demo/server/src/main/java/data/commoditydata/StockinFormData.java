package data.commoditydata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.CommodityDB.StockinDB;
import dataservice.commoditydataservice.StockinFormDataService;
import po.CommodityLocation;
import po.Formstate;
import po.ResultMessage;
import po.StockinPO;

public class StockinFormData extends UnicastRemoteObject implements StockinFormDataService{

	public StockinFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage addStockinForm(StockinPO po) throws RemoteException {
		return StockinDB.write(po);
	}

	@Override
	public ResultMessage updateStockinForm(StockinPO po) throws RemoteException {
		return StockinDB.update(po);
	}

	@Override
	public List<StockinPO> getStockinForm(Formstate state, String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return StockinDB.fuzzySearch(state, orgcode);
	}

	@Override
	public long getid(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return StockinDB.getLastId(orgcode);
	}

	@Override
	public CommodityLocation getLocation(String orgcode) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
