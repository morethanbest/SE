package businesslogic.logisticsbl.stub;

import java.rmi.RemoteException;

import vo.DeliveryVO;
import vo.ResultMessage;

public class DeliveryBlService_Stub implements businesslogicservice.logisticsblservice.DeliveryBlService {

	@Override
	public ResultMessage Delivery(DeliveryVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage update(DeliveryVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
