package dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;
import po.Formstate;

public interface ArrivalFormDataService {
	public List<ArrivalPO> getArrivalForm (Formstate state)throws RemoteException;
	
	public void updateArrivalForm (ArrivalPO po)throws RemoteException;
	
	public void addArrivalForm (ArrivalPO po)throws RemoteException;
}