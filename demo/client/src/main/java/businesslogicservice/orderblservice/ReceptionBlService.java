package businesslogicservice.orderblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.ReceptionVO;

public interface ReceptionBlService {
	public ResultMessage addReception (ReceptionVO vo) throws RemoteException;
}
