package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import businesslogicservice.logisticsblservice.RecordtransBlService;
import vo.RecordtransVO;
import vo.ResultMessage;

public class RecordtranBlService_Stub implements RecordtransBlService {

	@Override
	public ResultMessage Recordtrans(RecordtransVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
