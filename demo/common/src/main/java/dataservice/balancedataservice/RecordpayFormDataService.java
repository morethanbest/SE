package dataservice.balancedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.RecordpayPO;
import po.ResultMessage;

public interface RecordpayFormDataService extends Remote {
	public List<RecordpayPO> getRecordpayForm (Formstate state)throws RemoteException;
	
	public ResultMessage updateRecordpayForm (RecordpayPO po)throws RemoteException;
	
	public ResultMessage addRecordpayForm (RecordpayPO po)throws RemoteException;
	
	public  ResultMessage removeTheCost(String accountname,double fee)throws RemoteException;

	public long getlastid() throws  RemoteException;
	
}
