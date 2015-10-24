package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;

import vo.ResultMessage;

import vo.InboundVO;

public interface InboundBlService {
	public ResultMessage Inbound(InboundVO vo)throws RemoteException;
}
