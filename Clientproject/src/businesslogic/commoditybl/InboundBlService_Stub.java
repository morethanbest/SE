package businesslogic.commoditybl;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.StockinVO;

public class InboundBlService_Stub implements businesslogicservice.commodityblservice.InboundBlService {

	@Override
	public ResultMessage Inbound(StockinVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
