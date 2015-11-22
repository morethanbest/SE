package data.logisticsdata;

import java.rmi.RemoteException;

import data.database.LogisticsDB;
import dataservice.logisticsdataservice.LogisticsInfoService;
import po.LogisticsPO;
import vo.ResultMessage;

public class LogisticsInfo implements LogisticsInfoService {

	@Override
	public LogisticsPO findLogisticsInfo(String ordernum) throws RemoteException {
		// TODO Auto-generated method stub
		return LogisticsDB.find(ordernum);
	}

	@Override
	public ResultMessage update(LogisticsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return LogisticsDB.update(po);
	}

	@Override
	public ResultMessage addnew(LogisticsPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return LogisticsDB.write(po);
	}

}
