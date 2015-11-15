package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import vo.CLFareVO;
import vo.CenterloadVO;
import vo.ResultMessage;
import businesslogicservice.logisticsblservice.CenterloadBlService;

public class CenterloadBlServiceImpl implements CenterloadBlService{

	@Override
	public ResultMessage addCenterLoadForm(CenterloadVO vo)
			throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public double ComputeCenterLoadFare(CLFareVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage update(CenterloadVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
