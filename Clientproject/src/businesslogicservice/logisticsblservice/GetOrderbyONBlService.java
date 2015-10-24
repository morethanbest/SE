package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.OrderVO;

public interface GetOrderbyONBlService {
	public OrderVO getOrderbyON(long orderNumber)throws RemoteException;

}
