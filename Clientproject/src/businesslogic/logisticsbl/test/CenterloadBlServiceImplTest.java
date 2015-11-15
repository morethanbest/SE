package businesslogic.logisticsbl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.ResultMessage;
import businesslogic.logisticsbl.CenterloadBlServiceImpl;
import businesslogicservice.logisticsblservice.CenterloadBlService;

public class CenterloadBlServiceImplTest {

	@Test
	public void testAddCenterLoadForm() throws RemoteException {
		CenterloadBlService centerloadBlService = new CenterloadBlServiceImpl();
		assertEquals(ResultMessage.success,centerloadBlService.addCenterLoadForm(null));
	}

	@Test
	public void testComputeCenterLoadFare() throws RemoteException {
		CenterloadBlService centerloadBlService = new CenterloadBlServiceImpl();
		assertEquals(0,centerloadBlService.computeCenterLoadFare(null),0.0001);
	}

	@Test
	public void testUpdate() throws RemoteException {
		CenterloadBlService centerloadBlService = new CenterloadBlServiceImpl();
		assertEquals(ResultMessage.success,centerloadBlService.update(null));
	}

}
