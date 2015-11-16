package dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.HallLoadPO;

public interface HallLoadFormDataService {
	public void addLoadForm (HallLoadPO po)throws RemoteException;
	
	public List<HallLoadPO> getLoadForm (Formstate state)throws RemoteException;
	
	public void updateLoadForm(HallLoadPO po)throws RemoteException;
	
	public long findLastID() throws RemoteException;
}
