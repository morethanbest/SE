package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.LogisticsPO;

public interface LogisticsInfoService {
	public LogisticsPO findLogisticsInfo (long ordernum)throws RemoteException;
}
