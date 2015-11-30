package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.StockinVO;

public interface InboundBlService {
	public ResultMessage Inbound(StockinVO vo)throws RemoteException;

	public ResultMessage update(StockinVO vo )throws  RemoteException;

	public List<StockinVO> findInboundForm(Formstate state)throws  RemoteException;

	public String getid(String orgcode)throws  RemoteException;
}
