package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import vo.GoodsRecevingVO;
import vo.ResultMessage;
import businesslogicservice.logisticsblservice.GoodsRecevingBlService;

public class GoodsRecevingBlServiceImpl implements GoodsRecevingBlService {

	@Override
	public ResultMessage GoodsReceving(GoodsRecevingVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage update(GoodsRecevingVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
