package businesslogic.balancebl.RecordpayPack;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vo.RecordpayVO;
import vo.ResultMessage;

public class test {
	@Test
	public void testRecordpay(){
		RecordpayVO vo=new RecordpayVO(20150101, 100, "sc", "0", 0, 0, 0, 0, " ");
		MockIdInfo idInfo=new MockIdInfo(1);
		MockRecord record=new MockRecord();
		Recordpay recordpay=new Recordpay(idInfo, record);
		ResultMessage result=recordpay.Recordpay(vo);
		assertEquals(ResultMessage.success, result);
	}

}
