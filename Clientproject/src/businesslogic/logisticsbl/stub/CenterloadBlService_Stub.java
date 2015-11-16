package businesslogic.logisticsbl.stub;

import java.rmi.RemoteException;

import vo.CLFareVO;
import vo.CenterloadVO;
import vo.ResultMessage;

public class CenterloadBlService_Stub implements businesslogicservice.logisticsblservice.CenterloadBlService {

	@Override
	public ResultMessage addCenterLoadForm(CenterloadVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public double computeCenterLoadFare(CLFareVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage update(CenterloadVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
