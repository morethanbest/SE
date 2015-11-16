package businesslogic.accountbl.AccountPack;

import vo.AccountVO;
import vo.ResultMessage;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class test {
	@Test
	public void testAddAccount(){
		AccountVO vo=new AccountVO(1, "sunchao", 0);
		MockAddAccount addAccount=new MockAddAccount();
		MockIdInfo id=new MockIdInfo(1);
		Account account=new Account(addAccount, id);
		ResultMessage result=account.addAccount(vo);
		assertEquals(ResultMessage.success,result);
	}
	@Test
	public void testdelAccount(){
		AccountVO vo=new AccountVO(1, "sunchao", 0);
		MockDelAccount delAccount=new MockDelAccount();
		Account account=new Account(delAccount);
		ResultMessage result=account.delAccount(vo);
		assertEquals(ResultMessage.success,result);
	}
	@Test
	public void testrevAccount(){
		AccountVO vo=new AccountVO(1, "sunchao", 0);
		MockRevAccount revAccount=new MockRevAccount();
		Account account=new Account(revAccount);
		ResultMessage result=account.revAccount(vo);
		assertEquals(ResultMessage.success,result);
	}
	@Test
	public void testgetAccountbyID(){
	    long id =1;
		MockGetAccountbyID getAccountbyID=new MockGetAccountbyID();
		Account account=new Account(getAccountbyID);
		AccountVO result=account.getAccountbyID(id);
		assertEquals(1,result.getId());
	}
}
