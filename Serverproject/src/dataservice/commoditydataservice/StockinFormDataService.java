package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import po.StockinPO;

public interface StockinFormDataService {
	public ResultMessage addStockinForm (StockinPO po)throws RemoteException;
	
	public List<StockinPO> getStockinForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateStockinForm (StockinPO po)throws RemoteException;
}
