package dataservice.balancedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.RecordcollectPO;
import po.ResultMessage;

public interface RecordcollectFormDataService extends Remote {
	public ResultMessage addRecordcollectForm (RecordcollectPO po)throws RemoteException;
	
	public List<RecordcollectPO> getRecordcollectForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateRecordcollectForm (RecordcollectPO po)throws RemoteException;
	
	public List<RecordcollectPO> getallRecordcollectForm ()throws RemoteException;
}
