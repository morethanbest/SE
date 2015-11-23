package businesslogicservice.orderblservice;

import po.ResultMessage;
import vo.OrderFareVO;
import vo.OrderVO;

public interface OrderBlService {
	public ResultMessage addOrder(OrderVO vo);
	
	public double orderFare(OrderFareVO vo);
	
	public String getOrdercode();

}
