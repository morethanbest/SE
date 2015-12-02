package businesslogic.commoditybl.StocktakingPack;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.CommodityLocation;
import po.CommodityPO;
import vo.CommodityTakingVO;
import vo.StocktakingVO;

public class Stocktaking {
	Formget getter;
	public Stocktaking(Formget getter) {
		// TODO Auto-generated constructor stub
		this.getter=getter;
	
	}
	
	
	public StocktakingVO StockFormget(String orgcode,long date,long blocknum) {
		// TODO Auto-generated method stub
		List<CommodityPO> pos=getter.getcom(orgcode,date,blocknum);
		List<CommodityTakingVO> list=new ArrayList<CommodityTakingVO>();
		for(int i=0;i<=pos.size()-1;i++){
			CommodityPO po=pos.get(i);
			String ordercode=po.getOrdercode();
			long intime=po.getIntime();
			CommodityLocation location=po.getLocation();
			String destination=po.getDestination();

			CommodityTakingVO newvo=new CommodityTakingVO(ordercode,intime,destination,location);
			list.add(newvo);
		}

		StocktakingVO result=new StocktakingVO(list);
		return result;
		
		
	}


}
