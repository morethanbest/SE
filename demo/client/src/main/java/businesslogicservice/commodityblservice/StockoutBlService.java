package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.StockoutVO;

public interface StockoutBlService {
	public ResultMessage Stockout(StockoutVO vo)throws RemoteException;

	public ResultMessage update(StockoutVO vo) throws  RemoteException;

	public List<StockoutVO> findforms(Formstate state) throws  RemoteException;

	public String getid(String orgcode) throws  RemoteException;
}
