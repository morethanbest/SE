package businesslogic.balancebl.DebitnotePack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vo.DebitnoteVO;
import vo.ResultMessage;

public class test {
	@Test
	public void testDebitnote(){
		DebitnoteVO vo=new DebitnoteVO(20150101, "s", "sc", "", 100, "s");
		MockIdInfo idInfo=new MockIdInfo(1);
		MockRecord record=new MockRecord();
		Debitnote debitnote=new Debitnote(idInfo, record);
		ResultMessage result=debitnote.RecordDebitnote(vo);
		assertEquals(ResultMessage.success, result);
	}

}
