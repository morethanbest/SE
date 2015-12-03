package data.balancedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataservice.balancedataservice.StatisticsDataService;
import po.RecordcollectPO;
import po.RecordpayPO;

public class StaisticsData extends UnicastRemoteObject implements StatisticsDataService {

	public StaisticsData() throws RemoteException {
		// TODO Auto-generated constructor stub
		super();
	}

	@Override
	public List<RecordpayPO> getallRecordpay(long starttime, long endtime) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RecordcollectPO> getallRecordcollect(long starttime, long endtime) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
