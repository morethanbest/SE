package dataservice.balancedataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.RecordpayPO;

public interface RecordpayFormDataService {
	public List<RecordpayPO> getRecordpayForm (Formstate state)throws RemoteException;
	
	public void updateRecordpayForm (RecordpayPO po)throws RemoteException;
	
	public void addRecordpayForm (RecordpayPO po)throws RemoteException;
	
	public List<RecordpayPO> getallRecordpayForm ()throws RemoteException;
	
}
