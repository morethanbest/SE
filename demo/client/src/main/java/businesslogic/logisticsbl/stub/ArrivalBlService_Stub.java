package businesslogic.logisticsbl.stub;

import java.rmi.RemoteException;

import businesslogicservice.logisticsblservice.ArrivalBlService;
import vo.ArrivalVO;
import vo.ResultMessage;

public class ArrivalBlService_Stub implements ArrivalBlService {

	@Override
	public ResultMessage addArrival(ArrivalVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage update(ArrivalVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



}
