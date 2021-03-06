package data.managerdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.database.balanceDB.RecordcollectDB;
import data.database.balanceDB.RecordpayDB;
import dataservice.managerdataservice.ManagerStatisticsDataService;
import po.Formstate;
import po.RecordcollectPO;
import po.RecordpayPO;

public class ManagerStatisticsData extends UnicastRemoteObject implements ManagerStatisticsDataService {

	public ManagerStatisticsData() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<RecordpayPO> getallRecordpay(long starttime, long endtime) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordpayDB.getbetween(Formstate.checked, starttime, endtime);
	}

	@Override
	public List<RecordcollectPO> getallRecordcollect(long starttime, long endtime) throws RemoteException {
		// TODO Auto-generated method stub
		return RecordcollectDB.getbetween(Formstate.checked, starttime, endtime);		//获得已被确认过的这段时间中的收款单
	}

}
