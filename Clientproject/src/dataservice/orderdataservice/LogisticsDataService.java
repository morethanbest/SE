package dataservice.orderdataservice;

import java.rmi.RemoteException;

import po.LogisticsPO;
import vo.ResultMessage;

public interface LogisticsDataService {
	public ResultMessage addLogistics(LogisticsPO po) throws RemoteException;
	
	public LogisticsPO findLogistics(String orderNumber) throws RemoteException;
	
	public ResultMessage update(LogisticsPO po) throws RemoteException;
	
	public long findLastID() throws RemoteException;
}
