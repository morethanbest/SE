package businesslogic.logisticsbl.test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.ResultMessage;
import businesslogic.logisticsbl.stub.StringLoadBlServiceImpl;
import businesslogicservice.logisticsblservice.StringLoadBlService;

public class StringLoadBlServiceImplTest {

	@Test
	public void testAddStringLoadForm() throws RemoteException {
		StringLoadBlService hallLoadBlService = new StringLoadBlServiceImpl();
		assertEquals(ResultMessage.success,hallLoadBlService.addStringLoadForm(null));
	}

	@Test
	public void testComputeStringLoadFare() throws RemoteException {
		StringLoadBlService hallLoadBlService = new StringLoadBlServiceImpl();
		assertEquals(0,hallLoadBlService.computeStringLoadFare(null),0.0001);
	}

	@Test
	public void testUpdate() throws RemoteException {
		StringLoadBlService hallLoadBlService = new StringLoadBlServiceImpl();
		assertEquals(ResultMessage.success,hallLoadBlService.update(null));
	}

}
