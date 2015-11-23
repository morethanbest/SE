package businesslogic.balancebl;

import java.rmi.RemoteException;

import businesslogicservice.balanceblservice.DebitnoteBlService;
import vo.DebitnoteVO;
import vo.ResultMessage;

public class DebitnoteBlService_Stub implements DebitnoteBlService {

	@Override
	public ResultMessage Debitnote(DebitnoteVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
