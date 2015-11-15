package businesslogic.logisticsbl.stub;

import java.rmi.RemoteException;

import vo.LogisticsVO;
import businesslogicservice.logisticsblservice.SearchOrderBlService;

public class GetOrderbyONBlService_Stub implements SearchOrderBlService {

	@Override
	public LogisticsVO getOrderbyOrderNumber(String orderNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return new LogisticsVO("1",null,"1");
	}

}
