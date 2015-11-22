package businesslogicservice.orderblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 
import vo.OrderVO;
import vo.OrderFareVO;
import vo.ReceptionVO;

public interface OrderBlService {
	public ResultMessage addOrder(OrderVO vo);
	
	public double orderFare(OrderFareVO vo);
	
	public String getOrdercode();

}
