package businesslogicservice.balanceblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.DebitnoteVO;

public interface DebitnoteBlService {
	public ResultMessage Debitnote(DebitnoteVO vo)throws RemoteException;
}