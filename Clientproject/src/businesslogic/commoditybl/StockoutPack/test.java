package businesslogic.commoditybl.StockoutPack;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import po.City;
import po.CommodityLocation;
import po.Hall;
import po.Loadform;
import vo.ResultMessage;
import vo.StockinVO;
import vo.StockoutVO;

public class test {

	@Test
	public void test() throws RemoteException {
		CommodityLocation loca=new CommodityLocation(1,1,1,1);
		StockoutVO vo=new StockoutVO("002400400", 20130412,Hall.Nanjing,Loadform.train,"20563323","8522233");
		StockoutFormMock form=new StockoutFormMock();
		IdInfoMock idgetter=new IdInfoMock(5);
		
		Stockout stockoutdo=new Stockout(form,idgetter);
		
		ResultMessage result=stockoutdo.StockoutOP(vo);
		assertEquals(result,ResultMessage.success);
	}

}
