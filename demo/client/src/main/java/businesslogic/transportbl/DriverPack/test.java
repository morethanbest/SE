package businesslogic.transportbl.DriverPack;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.DriverVO;
import vo.ResultMessage;

public class test {

	@Test
	public void testAdd() throws RemoteException {
		DriverVO vo=new DriverVO("012002", "李旺", 19720123, "465646" ,"13115646","男", 3);
		AddDriver add=new AddDriver();
		Driver driver=new Driver(add);
		ResultMessage result=driver.addDriver(vo);
		assertEquals(result,ResultMessage.success);
	}
	@Test
	public void testDel() throws RemoteException {
		DriverVO vo=new DriverVO("012002", "李旺", 19720123, "465646" ,"13115646","男", 3);
		DelDriver del=new DelDriver();
		Driver driver=new Driver(del);
		ResultMessage result=driver.delDriver(vo);
		assertEquals(result,ResultMessage.success);
	}
	@Test
	public void testRev() throws RemoteException {
		DriverVO vo=new DriverVO("012002", "李旺", 19720123, "465646" ,"13115646","男", 3);
		RevDriver rev=new RevDriver();
		Driver driver=new Driver(rev);
		ResultMessage result=driver.revDriver(vo);
		assertEquals(result,ResultMessage.success);
	}
	@Test
	public void testGetByDN() throws RemoteException {
		String driverNumber="201463";
		DriverVO vo=new DriverVO(driverNumber,"abc",1,"321459193621","13214","32153",20150322);
		FindDriver fd=new FindDriver(vo);
		Driver driver=new Driver(fd);
		DriverVO vogot=driver.getDriverbyDN(driverNumber);
		assertEquals(vogot.getDrivercode(),driverNumber);
		
	}
	@Test
	public void testGetByName() throws RemoteException {
		String name="李旺";
		DriverVO vo=new DriverVO("1",name,1,"321459193621","13214","32153",20150322);
		FindDriver fd=new FindDriver(vo);
		Driver driver=new Driver(fd);
		DriverVO vogot=driver.getDriverbyName(name);
		assertEquals(vogot.getDrivername(),name);
	}

}
