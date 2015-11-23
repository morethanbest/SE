package businesslogic.balancebl.BalancePack;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vo.BalanceviewVO;
public class test {
	@Test
	public void testbalanceview(){
		BalanceviewVO vo=new BalanceviewVO(100, 1, 99);
		MockIdInfo id=new MockIdInfo(1);
		Balance balance=new Balance(id);
        assertEquals(100, balance.getBalanceview().getIn(),0.001);
        assertEquals(1, balance.getBalanceview().getOut(),0.001);
        assertEquals(99, balance.getBalanceview().getInterest(),0.001);
	}

}
