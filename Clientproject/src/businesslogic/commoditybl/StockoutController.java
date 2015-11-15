package businesslogic.commoditybl;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.StockoutVO;
import businesslogicservice.commodityblservice.StockoutBlService;

public class StockoutController implements StockoutBlService{



	@Override
	public ResultMessage Stockout(StockoutVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
