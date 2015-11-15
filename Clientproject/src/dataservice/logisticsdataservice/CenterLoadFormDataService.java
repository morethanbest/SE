package dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.CenterloadPO;
import po.Formstate;

public interface CenterLoadFormDataService {
	public List<CenterloadPO> getCenterLoadForm (Formstate state)throws RemoteException;
	
	public void updateCenterLoadForm (CenterloadPO po)throws RemoteException;
	
	public void addCenterLoadForm (CenterloadPO po)throws RemoteException;
	
	public long findLastID() throws RemoteException;
}
