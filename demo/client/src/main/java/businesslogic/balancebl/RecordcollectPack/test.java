package businesslogic.balancebl.RecordcollectPack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vo.RecordcollectVO;
import vo.ResultMessage;

public class test {
	@Test
	public void testRecordpay(){
		RecordcollectVO vo=new RecordcollectVO(1, 20150101, "sc", null);
		MockIdInfo idInfo=new MockIdInfo(1);
		MockRecord record=new MockRecord();
		Recordcollect recordcollect=new Recordcollect(idInfo, record);
		ResultMessage result=recordcollect.Recordcollect(vo);
		assertEquals(ResultMessage.success, result);
	}

}
