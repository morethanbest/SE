package businesslogicservice.commodityblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.StockoutVO;

public interface StockoutBlService {
	public ResultMessage Stockout(StockoutVO vo);

	public ResultMessage update(StockoutVO vo) ;

	public List<StockoutVO> findforms(Formstate state,String orgcode) ;

	public String getid(String orgcode) ;
}
