package businesslogic.commoditybl.StocktakingPack;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import po.City;
import po.CommodityLocation;
import vo.CommodityOutVO;
import vo.StocktakingVO;

public class test {

	@Test
	public void test() throws RemoteException {
		List<CommodityOutVO> list=new ArrayList<CommodityOutVO>();
		CommodityLocation loca=new CommodityLocation(1,1,1,1);
		CommodityOutVO infovo=new CommodityOutVO("0122005",20140211,-1,loca,City.Guangzhou);
		list.add(infovo);
		
		
		FormGetMock formgetter=new FormGetMock(list);
		Stocktaking newcheck=new Stocktaking(formgetter);
		StocktakingVO vo=newcheck.StockFormget();
		List<CommodityOutVO> anolist=vo.getList();
		for(int i=0;i<=anolist.size()-1;i++){
			assertEquals(anolist.get(i).getOutTime(),-1);
		}
		
/*		String ordercode;
		long intime;
		long outTime;
		CommodityLocation location;*/

	}

}
