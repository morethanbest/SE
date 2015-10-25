package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import businesslogicservice.logisticsblservice.HallLoadBlService;
import vo.HallLoadVO;
import vo.ResultMessage;

public class HallLoadBlService_Stub implements HallLoadBlService {

	@Override
	public ResultMessage addHallLoadForm(HallLoadVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
