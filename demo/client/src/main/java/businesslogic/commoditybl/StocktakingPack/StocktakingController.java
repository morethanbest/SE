package businesslogic.commoditybl.StocktakingPack;

import java.rmi.RemoteException;
import java.util.List;

import vo.StocktakingVO;
import businesslogicservice.commodityblservice.StocktakingBlService;

public class StocktakingController implements StocktakingBlService{




	@Override
	public StocktakingVO Stocktaking(String orgcode,long date, long blocknum)  {
		Formget getter=new Formget();
		Stocktaking take=new Stocktaking(getter);
		StocktakingVO vo=take.StockFormget(orgcode,date ,blocknum);
		return vo;
	}



	@Override
	public long getId(String orgcode, long date) {
		IdGet idgetter=new IdGet();
		long id=idgetter.getid(orgcode,date);
		return id;
	}


}
