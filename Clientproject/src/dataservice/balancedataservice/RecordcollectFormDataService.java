package dataservice.balancedataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.RecordcollectPO;

public interface RecordcollectFormDataService {
	public void addRecordcollectForm (RecordcollectPO po)throws RemoteException;
	
	public List<RecordcollectPO> getRecordcollectForm (Formstate state)throws RemoteException;
	
	public void updateRecordcollectForm (RecordcollectPO po)throws RemoteException;
	
	public List<RecordcollectPO> getallRecordcollectForm ()throws RemoteException;
}
