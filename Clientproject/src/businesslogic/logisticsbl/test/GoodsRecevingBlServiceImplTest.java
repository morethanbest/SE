package businesslogic.logisticsbl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.ResultMessage;
import businesslogic.logisticsbl.GoodsRecevingBlServiceImpl;
import businesslogicservice.logisticsblservice.GoodsRecevingBlService;

public class GoodsRecevingBlServiceImplTest {

	@Test
	public void testGoodsReceving() throws RemoteException {
		GoodsRecevingBlService goodsRecevingBlService = new GoodsRecevingBlServiceImpl();
		assertEquals(ResultMessage.success, goodsRecevingBlService.GoodsReceving(null));
	}

	@Test
	public void testUpdate() throws RemoteException {
		GoodsRecevingBlService goodsRecevingBlService = new GoodsRecevingBlServiceImpl();
		assertEquals(ResultMessage.success, goodsRecevingBlService.update(null));
	}

}
