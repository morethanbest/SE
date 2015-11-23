package businesslogic.commoditybl.StocktakingPack;

import java.rmi.RemoteException;

import vo.StocktakingVO;
import businesslogicservice.commodityblservice.StocktakingBlService;

public class StocktakingController implements StocktakingBlService{



	@Override
	public StocktakingVO Stocktaking() throws RemoteException {
		// TODO Auto-generated method stub
		FormGetMock formgetter=new FormGetMock(null);
		Stocktaking newcheck=new Stocktaking(formgetter);
		StocktakingVO vo=newcheck.StockFormget();
		return vo;
	}

}
