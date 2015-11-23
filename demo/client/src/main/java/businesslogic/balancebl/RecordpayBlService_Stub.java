package businesslogic.balancebl;

import java.rmi.RemoteException;

import businesslogicservice.balanceblservice.RecordpayBlService;
import vo.RecordpayVO;
import vo.ResultMessage;

public class RecordpayBlService_Stub implements RecordpayBlService {

	@Override
	public ResultMessage Recordpay(RecordpayVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
