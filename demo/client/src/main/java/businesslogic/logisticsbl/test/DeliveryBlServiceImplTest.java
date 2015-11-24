package businesslogic.logisticsbl.test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.ResultMessage;
import businesslogic.logisticsbl.stub.DeliveryBlServiceImpl;
import businesslogicservice.logisticsblservice.DeliveryBlService;

public class DeliveryBlServiceImplTest {

	@Test
	public void testDelivery() throws RemoteException {
		DeliveryBlService deliveryBlService = new DeliveryBlServiceImpl();
		assertEquals(ResultMessage.success, deliveryBlService.Delivery(null));
	}

	@Test
	public void testUpdate() throws RemoteException {
		DeliveryBlService deliveryBlService = new DeliveryBlServiceImpl();
		assertEquals(ResultMessage.success, deliveryBlService.update(null));
	}

}
