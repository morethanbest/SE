package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.DeliveryVO;

public interface DeliveryBlService {
	public ResultMessage Delivery(DeliveryVO vo)throws RemoteException;

}
