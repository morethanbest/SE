package dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.HallLoadPO;
import vo.ResultMessage;

public interface HallLoadFormDataService {
	public ResultMessage addLoadForm (HallLoadPO po)throws RemoteException;
	
	public List<HallLoadPO> getLoadForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateLoadForm(HallLoadPO po)throws RemoteException;
	
	public long findLastID() throws RemoteException;
}
