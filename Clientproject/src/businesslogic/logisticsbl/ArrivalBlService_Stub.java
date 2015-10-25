package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import businesslogicservice.logisticsblservice.ArrivalBlService;
import vo.ArrivalVO;
import vo.ResultMessage;

public class ArrivalBlService_Stub implements ArrivalBlService {

	@Override
	public ResultMessage Arrival(ArrivalVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
