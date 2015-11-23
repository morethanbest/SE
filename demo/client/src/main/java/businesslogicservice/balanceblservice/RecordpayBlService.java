package businesslogicservice.balanceblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.RecordpayVO;

public interface RecordpayBlService {
	public ResultMessage Recordpay(RecordpayVO vo)throws RemoteException;
}
