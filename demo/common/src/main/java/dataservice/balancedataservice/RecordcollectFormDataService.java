package dataservice.balancedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.RecordcollectPO;
import po.ResultMessage;

public interface RecordcollectFormDataService extends Remote {
	public ResultMessage addRecordcollectForm (RecordcollectPO po)throws RemoteException;
	
	public List<RecordcollectPO> getRecordcollectForm (Formstate state,String orgcode)throws RemoteException;
	
	public ResultMessage updateRecordcollectForm (RecordcollectPO po)throws RemoteException;
	
	public long getlastid (String orgcode)throws RemoteException;
	
	public ResultMessage addmoney(String accountname,double fee)throws RemoteException;
}
