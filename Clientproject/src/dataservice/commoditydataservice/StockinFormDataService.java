package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.StockinPO;

public interface StockinFormDataService {
	public void addStockinForm (StockinPO po)throws RemoteException;
	
	public List<StockinPO> getStockinForm (Formstate state)throws RemoteException;
	
	public void updateStockinForm (StockinPO po)throws RemoteException;
}
