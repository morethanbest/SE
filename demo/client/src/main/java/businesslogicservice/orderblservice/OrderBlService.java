package businesslogicservice.orderblservice;

import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.OrderFareVO;
import vo.OrderVO;

public interface OrderBlService {
	public ResultMessage addOrder(OrderVO vo);
	
	public double orderFare(OrderFareVO vo);
	
	public String getOrdercode();

	public List<OrderVO> findOrderByState(Formstate documentstate);
	
	public ResultMessage updateLogistics(OrderVO vo);
}
