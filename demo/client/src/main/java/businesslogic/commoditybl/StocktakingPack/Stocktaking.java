package businesslogic.commoditybl.StocktakingPack;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.CommodityLocation;
import vo.CommodityOutVO;
import vo.StocktakingVO;

public class Stocktaking {
	FormGetMock formgetter;
	public Stocktaking(FormGetMock formgetter) {
		// TODO Auto-generated constructor stub
		this.formgetter=formgetter;
	
	}
	
	
	public StocktakingVO StockFormget() throws RemoteException {
		// TODO Auto-generated method stub
		List<CommodityOutVO> list=formgetter.getForm();
		StocktakingVO vo=new StocktakingVO(list);
		return vo;
		
		
	}


}
