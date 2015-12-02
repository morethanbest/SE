package businesslogic.orderbl.OrderPack;

import java.util.List;

import businesslogicservice.orderblservice.OrderBlService;
import po.Formstate;
import po.ResultMessage;
import vo.OrderFareVO;
import vo.OrderVO;

public class OrderController implements OrderBlService{

	@Override
	public ResultMessage addOrder(OrderVO vo){
		// TODO Auto-generated method stub
		AddOrder addOrder=new AddOrder();
		IdInfo idInfo=new IdInfo();
		Order order=new Order(addOrder, idInfo);
		ResultMessage result=order.addOrder(vo);
		return result;
	}

	@Override
	public double orderFare(OrderFareVO vo){
		// TODO Auto-generated method stub
		GetPrice getPrice=new GetPrice();
		Order order=new Order(getPrice);
		double price=order.getPrice(vo);
		return price;
	}
	@Override
	public String getOrdercode(){
		GetOrderCode getcode=new GetOrderCode();
		Order order=new Order(getcode);
		String code=order.getOrdercode();
		return code;
	}
	@Override
	public List<OrderVO> findOrderByState(Formstate documentstate){
		FindOrder findOrder=new FindOrder();
		Order order=new Order(findOrder);
		List<OrderVO> listvo=order.findOrderByState(documentstate);
		return listvo;
	}
	@Override
	public ResultMessage updateLogistics(OrderVO vo){
		UpdateLogistics updateLogistics=new UpdateLogistics();
		ResultMessage resultMessage=updateLogistics.updatebyorder(vo);
		return resultMessage;
	}
}
