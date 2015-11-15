package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import vo.DeliveryVO;
import vo.ResultMessage;
import businesslogicservice.logisticsblservice.DeliveryBlService;

public class DeliveryBlServiceImpl implements DeliveryBlService{

	@Override
	public ResultMessage Delivery(DeliveryVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage update(DeliveryVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
