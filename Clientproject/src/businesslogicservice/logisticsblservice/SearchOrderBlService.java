package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.OrderVO;
import vo.ResultMessage;

public interface SearchOrderBlService {
	public OrderVO getOrderbyOrderNumber(String orderNumber)throws RemoteException;

}
