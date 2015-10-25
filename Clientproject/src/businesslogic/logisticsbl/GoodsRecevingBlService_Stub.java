package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import vo.GoodsRecevingVO;
import vo.ResultMessage;

public class GoodsRecevingBlService_Stub implements businesslogicservice.logisticsblservice.GoodsRecevingBlService {

	@Override
	public ResultMessage GoodsReceving(GoodsRecevingVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
