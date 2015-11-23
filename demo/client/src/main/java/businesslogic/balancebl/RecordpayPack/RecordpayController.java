package businesslogic.balancebl.RecordpayPack;

import java.rmi.RemoteException;

import vo.RecordpayVO;
import vo.ResultMessage;
import businesslogicservice.balanceblservice.RecordpayBlService;

public class RecordpayController implements RecordpayBlService{

	@Override
	public ResultMessage Recordpay(RecordpayVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
