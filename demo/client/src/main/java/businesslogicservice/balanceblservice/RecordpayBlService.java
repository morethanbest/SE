package businesslogicservice.balanceblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.RecordpayVO;

public interface RecordpayBlService {
	public ResultMessage AddRecordpay(RecordpayVO vo)throws RemoteException;

	public ResultMessage updateRecordpay(RecordpayVO vo)throws  RemoteException;

	public List<RecordpayVO> findforms(Formstate formstate)throws  RemoteException;

	public String getid()throws  RemoteException;
}
