package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import po.Ordertype;

import businesslogicservice.logisticsblservice.SearchOrderBlService;
import vo.OrderVO;

public class GetOrderbyONBlService_Stub implements SearchOrderBlService {

	@Override
	public OrderVO getOrderbyOrderNumber(String orderNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return new OrderVO("1","1","1","1","1","1","1","1","1","1",1,1,1,"1",1,1,"1",Ordertype.economical);
	}

}
