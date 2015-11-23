package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.StockoutVO;

public interface StockoutBlService {
	public ResultMessage Stockout(StockoutVO vo)throws RemoteException;
}
