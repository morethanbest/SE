package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.LogisticsPO;
import vo.ResultMessage;

public interface LogisticsInfoService {
	public LogisticsPO findLogisticsInfo (String ordernum)throws RemoteException;
	
	public ResultMessage update(LogisticsPO po) throws RemoteException;
	
	public ResultMessage addnew(LogisticsPO po)throws RemoteException;
}
