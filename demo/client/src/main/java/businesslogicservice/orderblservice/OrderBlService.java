package businesslogicservice.orderblservice;

import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.OrderFareVO;
import vo.OrderVO;

public interface OrderBlService {
	public ResultMessage addOrder(OrderVO vo,String orgcode);
	
	public double orderFare(OrderFareVO vo);
	
	public String getOrdercode(String orgcode);

	public List<OrderVO> findOrderByState(Formstate documentstate,String orgcode);
	
	public ResultMessage updateLogistics(OrderVO vo);
}
