package businesslogic.transportbl.VehiclePack;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.ResultMessage;
import vo.VehicleVO;

public class test {

	@Test
	public void testAdd() throws RemoteException {
		VehicleVO vo=new VehicleVO("464655","4452203",3);
		AddVehicle add=new AddVehicle();
		Vehicle ve=new Vehicle(add);
		ResultMessage result=ve.addVehicle(vo);
		
		assertEquals(result,ResultMessage.success);
	}
	@Test
	public void testDel() throws RemoteException {
		VehicleVO vo=new VehicleVO("464655","4452203",3);
		DelVehicle del=new DelVehicle();
		Vehicle ve=new Vehicle(del);
		ResultMessage result=ve.delVehicle(vo);
		assertEquals(result,ResultMessage.success);
	}
	@Test
	public void testRev() throws RemoteException {
		VehicleVO vo=new VehicleVO("464655","4452203",3);
		RevVehicle rev=new RevVehicle();
		Vehicle ve=new Vehicle(rev);
		ResultMessage result=ve.revVehicle(vo);
		assertEquals(result,ResultMessage.success);
	}
	@Test
	public void testGetByVN() throws RemoteException {
		String code="1320065";
		VehicleVO vo=new VehicleVO(code,"1",1);
		FindVehicle find=new FindVehicle(vo);
		Vehicle ve=new Vehicle(find);
		VehicleVO vogot=ve.getVehiclebyVN(code);
		assertEquals(vogot.getVehiclecode(),code);
		
	}
	@Test
	public void testGetByPN() throws RemoteException {
		String plateNumber="��A1720";
		VehicleVO vo=new VehicleVO("1",plateNumber,1);
		FindVehicle find=new FindVehicle(vo);
		Vehicle ve=new Vehicle(find);
		VehicleVO  vogot=ve.getVehiclebyPN(plateNumber);
		assertEquals(vogot.getVehiclenum(),plateNumber);
	}


}
