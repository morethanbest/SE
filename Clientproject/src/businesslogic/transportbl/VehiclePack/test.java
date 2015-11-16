package businesslogic.transportbl.VehiclePack;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.DriverVO;
import vo.ResultMessage;
import vo.VehicleVO;
import businesslogic.transportbl.DriverPack.DelDriverMock;
import businesslogic.transportbl.DriverPack.Driver;
import businesslogic.transportbl.DriverPack.FindDriverMock;
import businesslogic.transportbl.DriverPack.RevDriverMock;

public class test {

	@Test
	public void testAdd() throws RemoteException {
		VehicleVO vo=new VehicleVO("464655","4452203",3);
		AddVehicleMock add=new AddVehicleMock();
		Vehicle ve=new Vehicle(add);
		ResultMessage result=ve.addVehicle(vo);
		
		assertEquals(result,ResultMessage.success);
	}
	@Test
	public void testDel() throws RemoteException {
		VehicleVO vo=new VehicleVO("464655","4452203",3);
		DelVehicleMock del=new DelVehicleMock();
		Vehicle ve=new Vehicle(del);
		ResultMessage result=ve.delVehicle(vo);
		assertEquals(result,ResultMessage.success);
	}
	@Test
	public void testRev() throws RemoteException {
		VehicleVO vo=new VehicleVO("464655","4452203",3);
		RevVehicleMock rev=new RevVehicleMock();
		Vehicle ve=new Vehicle(rev);
		ResultMessage result=ve.revVehicle(vo);
		assertEquals(result,ResultMessage.success);
	}
	@Test
	public void testGetByVN() throws RemoteException {
		String code="1320065";
		VehicleVO vo=new VehicleVO(code,"1",1);
		FindVehicleMock find=new FindVehicleMock(vo);
		Vehicle ve=new Vehicle(find);
		VehicleVO vogot=ve.getVehiclebyVN(code);
		assertEquals(vogot.getVehiclecode(),code);
		
	}
	@Test
	public void testGetByPN() throws RemoteException {
		String plateNumber="À’A1720";
		VehicleVO vo=new VehicleVO("1",plateNumber,1);
		FindVehicleMock find=new FindVehicleMock(vo);
		Vehicle ve=new Vehicle(find);
		VehicleVO  vogot=ve.getVehiclebyPN(plateNumber);
		assertEquals(vogot.getVehiclenum(),plateNumber);
	}


}
