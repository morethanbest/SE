package data.orderdata;

import dataservice.orderdataservice.LogisticsDataService;
import po.LogisticsPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LogisticsData extends UnicastRemoteObject implements LogisticsDataService{
	public LogisticsData() throws  RemoteException{
		super();
	}

	@Override
	public ResultMessage addLogistics(LogisticsPO po) throws RemoteException {
		return null;
	}

	@Override
	public LogisticsPO findLogistics(String orderNumber) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage update(LogisticsPO po) throws RemoteException {
		return null;
	}

	@Override
	public long findLastID() throws RemoteException {
		return 0;
	}
}
