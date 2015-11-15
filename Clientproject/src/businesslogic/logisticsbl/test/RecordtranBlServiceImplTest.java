package businesslogic.logisticsbl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.ResultMessage;
import businesslogic.logisticsbl.RecordtransBlServiceImpl;
import businesslogicservice.logisticsblservice.RecordtransBlService;

public class RecordtranBlServiceImplTest {

	@Test
	public void testRecordtrans() throws RemoteException {
		RecordtransBlService recordtransBlService = new RecordtransBlServiceImpl();
		assertEquals(ResultMessage.success,recordtransBlService.Recordtrans(null));
	}

	@Test
	public void testUpdate() throws RemoteException {
		RecordtransBlService recordtransBlService = new RecordtransBlServiceImpl();
		assertEquals(ResultMessage.success,recordtransBlService.update(null));
	}

}
