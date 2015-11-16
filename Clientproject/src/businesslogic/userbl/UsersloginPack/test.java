package businesslogic.userbl.UsersloginPack;

import static org.junit.Assert.*;

import org.junit.Test;

import vo.ResultMessage;

public class test {

	@Test
	public void test() {
		long id=20115;
		String password="52222";
		LoginConfirmMock con=new LoginConfirmMock();
		Userlogin login=new Userlogin(con);
		ResultMessage result=login.login(id,password);
		assertEquals(result,ResultMessage.success);
	}

}
