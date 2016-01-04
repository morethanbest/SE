package data.orderdata;

import dataservice.orderdataservice.LogisticsDataService;
import po.LogisticsPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.database.logisticsDB.LogisticsDB;

public class LogisticsData extends UnicastRemoteObject implements LogisticsDataService{
	public LogisticsData() throws  RemoteException{
		super();
	}

	@Override
	public ResultMessage addLogistics(LogisticsPO po) throws RemoteException {
		if(po!=null)
			return LogisticsDB.write(po);
		else 
			return ResultMessage.failure;
	}

}
