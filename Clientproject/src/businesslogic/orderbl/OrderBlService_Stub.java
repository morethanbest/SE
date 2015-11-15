package businesslogic.orderbl;

import java.rmi.RemoteException;

import businesslogicservice.orderblservice.OrderBlService;
import vo.OrderFareVO;
import vo.OrderVO;
import vo.ReceptionVO;
import vo.ResultMessage;

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
	public ResultMessage reception(ReceptionVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
