package businesslogic.commoditybl.InboundPack;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import po.City;
import po.CommodityLocation;
import vo.ResultMessage;
import vo.StockinVO;

public class test {

	@Test
	public void test() throws RemoteException {
		CommodityLocation loca=new CommodityLocation(1,1,1,1);
		StockinVO vo=new StockinVO("002400400", 20130412, loca, City.Beijing);
		
		
		AddInbound newform=new AddInbound();
		
		IdInfoMock idgetter=new IdInfoMock(5);
		Inbound newinbound=new Inbound(newform,idgetter);
		
	
			ResultMessage result=newinbound.InboundForm(vo);
			
			assertEquals(result,ResultMessage.success);
	}

}
