package businesslogic.logisticsbl.stub;

import java.rmi.RemoteException;

import businesslogicservice.logisticsblservice.StringLoadBlService;
import vo.HLFareVO;
import vo.StringLoadVO;
import vo.ResultMessage;

public class StringLoadBlService_Stub implements StringLoadBlService {

	@Override
	public ResultMessage addStringLoadForm(StringLoadVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public double computeStringLoadFare(HLFareVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage update(StringLoadVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
