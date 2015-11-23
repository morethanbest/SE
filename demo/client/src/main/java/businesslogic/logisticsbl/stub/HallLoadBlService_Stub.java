package businesslogic.logisticsbl.stub;

import java.rmi.RemoteException;

import businesslogicservice.logisticsblservice.HallLoadBlService;
import vo.HLFareVO;
import vo.HallLoadVO;
import vo.ResultMessage;

public class HallLoadBlService_Stub implements HallLoadBlService {

	@Override
	public ResultMessage addHallLoadForm(HallLoadVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public double computeHallLoadFare(HLFareVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage update(HallLoadVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
