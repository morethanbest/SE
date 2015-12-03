package businesslogic.balancebl.RecordpayPack;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.RecordpayVO;
import po.ResultMessage;
import businesslogicservice.balanceblservice.RecordpayBlService;

public class RecordpayController implements RecordpayBlService{



	@Override
	public ResultMessage AddRecordpay(RecordpayVO vo) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage updateRecordpay(RecordpayVO vo) throws RemoteException {
		return null;
	}

	@Override
	public List<RecordpayVO> findforms(Formstate formstate) throws RemoteException {
		return null;
	}

	@Override
	public String getid() throws RemoteException {
		return null;
	}
}
