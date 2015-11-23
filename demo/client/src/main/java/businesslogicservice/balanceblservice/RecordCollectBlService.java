package businesslogicservice.balanceblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.RecordcollectVO;

public interface RecordCollectBlService {
	public ResultMessage Recordcollect(RecordcollectVO vo)throws RemoteException;
}
