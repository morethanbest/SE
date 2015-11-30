package businesslogic.commoditybl.StockoutPack;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import po.ResultMessage;
import vo.StockoutVO;
import businesslogicservice.commodityblservice.StockoutBlService;

public class StockoutController implements StockoutBlService{


	@Override
	public ResultMessage Stockout(StockoutVO vo) throws RemoteException {
		AddStockout add=new AddStockout();
		Stockout out=new Stockout(add);
		ResultMessage result=out.addform(vo);
		return result;
	}

	@Override
	public ResultMessage update(StockoutVO vo) throws RemoteException {
		UpdateStockout update=new UpdateStockout();
		Stockout out=new Stockout(update);
		ResultMessage result=out.updateform(vo);
		return result;
	}

	@Override
	public List<StockoutVO> findforms(Formstate state,String orgcode) throws RemoteException {
		FindStockout find=new FindStockout();
		Stockout out=new Stockout(find);
		List<StockoutVO> list=out.findforms(state,orgcode);
		return list;
	}

	@Override
	public String getid(String orgcode) throws RemoteException {
		StockoutId idgetter=new StockoutId();
		String id=idgetter.getid(orgcode);
		return id;
	}
}
