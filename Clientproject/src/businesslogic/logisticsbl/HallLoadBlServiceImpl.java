package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import vo.HLFareVO;
import vo.HallLoadVO;
import vo.ResultMessage;
import businesslogicservice.logisticsblservice.HallLoadBlService;

public class HallLoadBlServiceImpl implements HallLoadBlService {

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
		return ResultMessage.success;
	}

}
