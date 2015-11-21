package businesslogic.managerbl.ConstantsPack;
import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.ConstantsVO;
import vo.ResultMessage;
public class test {
@Test
public void testadd() throws RemoteException{
	ConstantsVO vo=new ConstantsVO("as",1);
	MockAddConstants addc=new MockAddConstants();
	MockIdInfo id=new MockIdInfo(5);
	Constants c=new Constants(addc,id);
	ResultMessage result=c.addConstants(vo);
	
	assertEquals(ResultMessage.success,result);
}
@Test
public void testDel() throws RemoteException{
	ConstantsVO vo=new ConstantsVO("as",1);
	MockDelConstants delc=new MockDelConstants();
	Constants c=new Constants(delc); 
	ResultMessage result=c.delConstants(vo);
	assertEquals(ResultMessage.success,result);
}
@Test
public void testRev() throws RemoteException{
	ConstantsVO vo=new ConstantsVO("as",1);
	MockRevConstants revc=new MockRevConstants();
	Constants c= new Constants(revc);
	ResultMessage result=c.revConstants("s",vo);
	assertEquals(ResultMessage.success,result);
}
@Test
public void testFind() throws RemoteException{
	String name="a";
	MockFindConstants findc=new MockFindConstants();
	Constants c=new Constants(findc);
	//ConstantsVO vo=c.findConstants(name);
	//assertEquals(name,vo.getName());
}
}