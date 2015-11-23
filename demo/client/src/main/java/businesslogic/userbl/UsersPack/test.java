package businesslogic.userbl.UsersPack;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.ResultMessage;
import vo.UserVO;

public class test {

	@Test
	public void testAdd() throws RemoteException {
		UserVO vo=new UserVO(102,"0120","52086","营业厅业务员");
		IdInfoMock idgetter=new IdInfoMock(666);
		AddUserMock add=new AddUserMock();
		User user=new User(add,idgetter);
		ResultMessage result=user.addUser(vo);
		assertEquals(result,ResultMessage.success);
		
	}
	
	@Test
	public void testDel() throws RemoteException {
		long id=100;
		UserVO vo=new UserVO(id,"0120","52086","营业厅业务员");
		DelUserMock del=new DelUserMock();
		User user=new User(del);
		ResultMessage result=user.delUser(vo, id);
		assertEquals(result,ResultMessage.success);
	}
	
	@Test
	public void test() throws RemoteException {
		long id=100;
		UserVO vo=new UserVO(id,"0120","52086","营业厅业务员");
		RevUserMock rev=new RevUserMock();
		User user=new User(rev);
		ResultMessage result=user.revUser(vo, id);
		assertEquals(result,ResultMessage.success);
	}
	
	@Test
	public void testGetById() throws RemoteException {
		long id=101;
		UserVO vo=new UserVO(id,"1","1","1");
		FindUserMock find=new FindUserMock(vo);
		User user=new User(find);
		UserVO gotvo=user.getUserbyID(id);
		assertEquals(gotvo.getID(),id);
		
	}
	


}
