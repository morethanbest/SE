package businesslogic.balancebl.DebitnotePack;

import java.rmi.RemoteException;

import businesslogicservice.balanceblservice.DebitnoteBlService;
import vo.DebitnoteVO;
import vo.ResultMessage;


public class DebitnoteController implements DebitnoteBlService {

	@Override
	public ResultMessage Debitnote(DebitnoteVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
