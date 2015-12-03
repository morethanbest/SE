package data.balancedata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.balanceDB.RecordcollectDB;
import dataservice.balancedataservice.StatisticsDataService;
import po.Formstate;
import po.RecordcollectPO;
import po.RecordpayPO;

public class StatisticsData extends UnicastRemoteObject implements StatisticsDataService {

	public StatisticsData() throws RemoteException {
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
		return RecordcollectDB.getbetween(Formstate.checked, starttime, endtime);		//获得已被确认过的这段时间中的收款单
	}

}
