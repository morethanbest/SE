package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import vo.RecordtransVO;
import vo.ResultMessage;
import businesslogicservice.logisticsblservice.RecordtransBlService;

public class RecordtransBlServiceImpl implements RecordtransBlService {

	@Override
	public ResultMessage Recordtrans(RecordtransVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage update(RecordtransVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
