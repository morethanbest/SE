package businesslogic.commoditybl.blstub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businesslogicservice.commodityblservice.StocktakingBlService;
import po.City;
import po.CommodityLocation;
import vo.CommodityTakingVO;
import vo.StocktakingVO;

public class StocktakingBlService_Stub implements StocktakingBlService {

	@Override
	public StocktakingVO Stocktaking() throws RemoteException {
		// TODO Auto-generated method stub
		List<CommodityTakingVO> l=new ArrayList<CommodityTakingVO>();
		l.add(new CommodityTakingVO("1",1,1,new CommodityLocation(1,1,1,1),City.Guangzhou));
		
		return new StocktakingVO(l);
	}

}
