package businesslogic.logisticsbl.stub;

import java.rmi.RemoteException;

import vo.GoodsReceivingVO;
import vo.ResultMessage;

public class GoodsRecevingBlService_Stub implements businesslogicservice.logisticsblservice.GoodsRecevingBlService {

	@Override
	public ResultMessage GoodsReceving(GoodsReceivingVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage update(GoodsReceivingVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
