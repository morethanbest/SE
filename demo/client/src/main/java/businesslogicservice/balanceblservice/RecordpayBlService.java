package businesslogicservice.balanceblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.RecordpayVO;

public interface RecordpayBlService {
	public ResultMessage AddRecordpay(RecordpayVO vo);

	public ResultMessage updateRecordpay(RecordpayVO vo);

	public List<RecordpayVO> findforms(Formstate formstate);

	public String getid();
}
