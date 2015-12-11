package data.logisticsdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.database.logisticsDB.LogisticsDB;
import dataservice.logisticsdataservice.LogisticsInfoService;
import po.LogisticsPO;
import po.ResultMessage;

public class LogisticsInfo extends UnicastRemoteObject implements LogisticsInfoService {

	public LogisticsInfo() throws  RemoteException{
		super();
	}
	@Override
	public LogisticsPO findLogisticsInfo(String ordernum) throws RemoteException {
		// TODO Auto-generated method stub
		return LogisticsDB.find(ordernum);
	}

	@Override
	public ResultMessage update(LogisticsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return LogisticsDB.update(po);
		else
			return ResultMessage.failure;
	}


}
