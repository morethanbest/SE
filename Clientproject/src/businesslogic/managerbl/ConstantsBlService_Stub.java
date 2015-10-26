package businesslogic.managerbl;

import java.rmi.RemoteException;

import businesslogicservice.managerblservice.ConstantsBlService;
import vo.ConstantsVO;
import vo.ResultMessage;

public class ConstantsBlService_Stub implements ConstantsBlService {

	@Override
	public ResultMessage addConstants(ConstantsVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage delConstants(ConstantsVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage revConstants(ConstantsVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
