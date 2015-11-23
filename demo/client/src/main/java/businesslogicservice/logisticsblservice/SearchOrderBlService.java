package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.LogisticsVO;

public interface SearchOrderBlService {
	public LogisticsVO getOrderbyOrderNumber(String orderNumber)throws RemoteException;

}
