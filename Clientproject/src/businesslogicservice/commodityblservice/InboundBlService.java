package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;

import vo.ResultMessage;

import vo.StockinVO;

public interface InboundBlService {
	public ResultMessage Inbound(StockinVO vo)throws RemoteException;
}
