package dataservice.logisticsdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.LogisticsPO;
import po.ResultMessage;

public interface LogisticsInfoService extends Remote {
	public LogisticsPO findLogisticsInfo (String ordernum)throws RemoteException;
	
	public ResultMessage update(LogisticsPO po) throws RemoteException;
	
	public ResultMessage addnew(LogisticsPO po)throws RemoteException;
}
