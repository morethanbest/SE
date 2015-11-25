package businesslogic.orderbl.DrvierAndStub;

import java.rmi.RemoteException;

import businesslogicservice.orderblservice.OrderBlService;
import vo.OrderFareVO;
import vo.OrderVO;
import vo.ReceptionVO;
import po.ResultMessage;

public class OrderBlService_Stub implements OrderBlService {

	@Override
	public ResultMessage addOrder(OrderVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public double orderFare(OrderFareVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getOrdercode() {
		return null;
	}


}
