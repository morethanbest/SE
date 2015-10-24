package businesslogicservice.balanceblservice;

import java.rmi.RemoteException;

import vo.ResultMessage;

import vo.RecordcollectVO;

public interface RecordCollectBlService {
	public ResultMessage Recordcollect(RecordcollectVO vo)throws RemoteException;
}
