package businesslogicservice.balanceblservice;

import java.rmi.RemoteException;

import vo.ResultMessage;

import vo.RecordpayVO;

public interface RecordpayBlService {
	public ResultMessage Recordpay(RecordpayVO vo)throws RemoteException;
}
