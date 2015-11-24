package businesslogic.logisticsbl.test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.ResultMessage;
import businesslogic.logisticsbl.stub.HallLoadBlServiceImpl;
import businesslogicservice.logisticsblservice.HallLoadBlService;

public class HallLoadBlServiceImplTest {

	@Test
	public void testAddHallLoadForm() throws RemoteException {
		HallLoadBlService hallLoadBlService = new HallLoadBlServiceImpl();
		assertEquals(ResultMessage.success,hallLoadBlService.addHallLoadForm(null));
	}

	@Test
	public void testComputeHallLoadFare() throws RemoteException {
		HallLoadBlService hallLoadBlService = new HallLoadBlServiceImpl();
		assertEquals(0,hallLoadBlService.computeHallLoadFare(null),0.0001);
	}

	@Test
	public void testUpdate() throws RemoteException {
		HallLoadBlService hallLoadBlService = new HallLoadBlServiceImpl();
		assertEquals(ResultMessage.success,hallLoadBlService.update(null));
	}

}
