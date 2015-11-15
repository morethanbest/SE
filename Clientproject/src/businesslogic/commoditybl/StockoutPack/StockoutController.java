package businesslogic.commoditybl.StockoutPack;

import java.rmi.RemoteException;

import vo.ResultMessage;
import vo.StockoutVO;
import businesslogicservice.commodityblservice.StockoutBlService;

public class StockoutController implements StockoutBlService{



	@Override
	public ResultMessage Stockout(StockoutVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		StockoutFormMock form=new StockoutFormMock();
		IdInfoMock idgetter=new IdInfoMock(5);
		
		Stockout stockoutdo=new Stockout(form,idgetter);
		
		ResultMessage result=stockoutdo.StockoutOP(vo);
		return null;
	}

}
