package businesslogicservice.logisticsblservice;

import java.rmi.RemoteException;

import vo.ResultMessage; 

import vo.RecordtransVO;

public interface RecordtransBlService {
	public ResultMessage Recordtrans (RecordtransVO vo)throws RemoteException;
	public ResultMessage update(RecordtransVO vo)throws RemoteException;
}
