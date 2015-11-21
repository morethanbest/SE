package dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;
import po.Formstate;
import po.ResultMessage;

public interface ArrivalFormDataService {
	public List<ArrivalPO> getArrivalForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateArrivalForm (ArrivalPO po)throws RemoteException;
	
	public ResultMessage addArrivalForm (ArrivalPO po) throws RemoteException;
	
	public long findLastID() throws RemoteException;
}
