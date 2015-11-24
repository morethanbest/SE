package businesslogic.logisticsbl.test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.ResultMessage;
import businesslogic.logisticsbl.stub.ArrivalBLServiceImpl;
import businesslogicservice.logisticsblservice.ArrivalBlService;

public class ArrivalBLServiceImplTest {

	@Test
	public void testAddArrival() throws RemoteException {
		ArrivalBlService arrivalBlService = new ArrivalBLServiceImpl();
		assertEquals(ResultMessage.success,arrivalBlService.addArrival(null));
	}

	@Test
	public void testUpdate() throws RemoteException {
		ArrivalBlService arrivalBlService = new ArrivalBLServiceImpl();
		assertEquals(ResultMessage.success,arrivalBlService.update(null));
	}
}
