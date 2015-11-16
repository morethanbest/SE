package businesslogic.managerbl.SearchAccountPack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vo.AccountVO;

public class test {
	
	@Test
	public void testSearchAccount(){
	    long id =1;
		MockSearchAccount searchAccount=new MockSearchAccount();
		searchAccount.setGetInfo(id);
		AccountVO result=searchAccount.getAccountbyID();
		assertEquals(1,result.getId());
	}
}
