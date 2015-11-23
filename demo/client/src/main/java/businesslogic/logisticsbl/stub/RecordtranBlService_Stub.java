package businesslogic.logisticsbl.stub;

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

	@Override
	public ResultMessage update(RecordtransVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
