package businesslogicservice.orderblservice;

import java.rmi.RemoteException;

import vo.ReceptionVO;
import vo.ResultMessage;

public interface ReceptionBlService {
	public ResultMessage addReception (ReceptionVO vo) throws RemoteException;
}
