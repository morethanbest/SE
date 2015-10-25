package businesslogic.managerbl;

import java.rmi.RemoteException;

import businesslogicservice.managerblservice.ConstantsBlService;
import vo.ConstantsVO;
import vo.ResultMessage;

public class ConstantsBlService_Stub implements ConstantsBlService {

	@Override
	public ResultMessage addContants(ConstantsVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage delContants() throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage revContants(ConstantsVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
