package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import vo.CenterloadVO;
import vo.ResultMessage;

public class CenterloadBlService_Stub implements businesslogicservice.logisticsblservice.CenterloadBlService {

	@Override
	public ResultMessage addCenterLoadForm(CenterloadVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
