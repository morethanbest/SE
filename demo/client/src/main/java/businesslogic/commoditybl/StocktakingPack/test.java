package businesslogic.commoditybl.StocktakingPack;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import po.City;
import po.CommodityLocation;
import vo.CommodityTakingVO;
import vo.StocktakingVO;

public class test {

	@Test
	public void test() throws RemoteException {
		List<CommodityTakingVO> list=new ArrayList<CommodityTakingVO>();
		CommodityLocation loca=new CommodityLocation(1,1,1,1);
		CommodityTakingVO infovo=new CommodityTakingVO("0122005",20140211,-1,loca,City.Guangzhou);
		list.add(infovo);
		
		
		FormGetMock formgetter=new FormGetMock(list);
		Stocktaking newcheck=new Stocktaking(formgetter);
		StocktakingVO vo=newcheck.StockFormget();
		List<CommodityTakingVO> anolist=vo.getList();
		for(int i=0;i<=anolist.size()-1;i++){
			assertEquals(anolist.get(i).getOutTime(),-1);
		}
		
/*		String ordercode;
		long intime;
		long outTime;
		CommodityLocation location;*/

	}

}
