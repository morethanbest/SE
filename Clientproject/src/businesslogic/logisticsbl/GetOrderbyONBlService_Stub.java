package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import po.Ordertype;

import businesslogicservice.logisticsblservice.GetOrderbyONBlService;
import vo.OrderVO;

public class GetOrderbyONBlService_Stub implements GetOrderbyONBlService {

	@Override
	public OrderVO getOrderbyON(String orderNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return new OrderVO("1","1","1","1","1","1","1","1","1","1",1,1,1,"1",1,1,"1",Ordertype.economical);
	}

}
