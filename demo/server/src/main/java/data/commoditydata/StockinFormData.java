package data.commoditydata;

import dataservice.commoditydataservice.StockinFormDataService;
import po.Formstate;
import po.ResultMessage;
import po.StockinPO;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class StockinFormData extends UnicastRemoteObject implements StockinFormDataService{

	public StockinFormData() throws  RemoteException{
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public ResultMessage addStockinForm(StockinPO po) throws RemoteException {
		return null;
	}

	@Override
	public List<StockinPO> getStockinForm(Formstate state) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateStockinForm(StockinPO po) throws RemoteException {
		return null;
	}
}
