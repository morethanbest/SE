package dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.LoadPO;

public interface LoadFormDataService {
	public void addLoadForm (LoadPO po)throws RemoteException;
	
	public List<LoadPO> getLoadForm (Formstate state)throws RemoteException;
	
	public void updateLoadForm(LoadPO po)throws RemoteException;
	
	
}
