package dataservice.managerdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.RecordcollectPO;
import po.RecordpayPO;

public interface StatisticsDataService extends  Remote{
public List<RecordpayPO> getallRecordpay (long starttime,long endtime)throws RemoteException;
	
	public List<RecordcollectPO> getallRecordcollect (long starttime,long endtime)throws RemoteException;
}
