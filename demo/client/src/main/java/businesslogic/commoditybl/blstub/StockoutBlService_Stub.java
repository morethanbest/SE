package businesslogic.commoditybl.blstub;

import java.rmi.RemoteException;

import businesslogicservice.commodityblservice.StockoutBlService;
import vo.ResultMessage;
import vo.StockoutVO;

public class StockoutBlService_Stub implements StockoutBlService {

	@Override
	public ResultMessage Stockout(StockoutVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
