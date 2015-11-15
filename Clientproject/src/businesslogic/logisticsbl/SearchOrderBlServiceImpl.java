package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import po.Ordertype;
import vo.OrderVO;
import businesslogicservice.logisticsblservice.SearchOrderBlService;

public class SearchOrderBlServiceImpl implements SearchOrderBlService{

	@Override
	public OrderVO getOrderbyOrderNumber(String orderNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return new OrderVO("1","1","1","1","1","1","1","1","1","1",1,1,1,"1",1,1,"1",Ordertype.economical);
	}
	
}
