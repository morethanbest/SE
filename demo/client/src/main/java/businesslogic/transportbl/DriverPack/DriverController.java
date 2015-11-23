package businesslogic.transportbl.DriverPack;

import java.rmi.RemoteException;

import vo.DriverVO;
import vo.ResultMessage;
import businesslogicservice.transportblservice.DriverBlService;

public class DriverController implements DriverBlService{

	

	@Override
	public ResultMessage addDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		AddDriverMock add=new AddDriverMock();
		Driver driver=new Driver(add);
		ResultMessage result=driver.addDriver(vo);
		
		return result;
	}

	
	
	
	@Override
	public ResultMessage delDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		DelDriverMock del=new DelDriverMock();
		Driver driver=new Driver(del);
		ResultMessage result=driver.delDriver(vo);
		
		return result;
	}

	
	
	
	
	@Override
	public ResultMessage revDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		RevDriverMock rev=new RevDriverMock();
		Driver driver=new Driver(rev);
		ResultMessage result=driver.revDriver(vo);
		return result;
	}

	
	
	
	@Override
	public DriverVO getDriverbyDN(String driverNumber) throws RemoteException {
		// TODO Auto-generated method stub
		DriverVO vo=new DriverVO(driverNumber,"abc",1,"321459193621","13214","32153",20150322);
		FindDriverMock fd=new FindDriverMock(vo);
		Driver driver=new Driver(fd);
		DriverVO vogot=driver.getDriverbyDN(driverNumber);
		return vogot;
	}

	
	
	
	
	@Override
	public DriverVO getDriverbyName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		
		DriverVO vo=new DriverVO("1",name,1,"321459193621","13214","32153",20150322);
		FindDriverMock fd=new FindDriverMock(vo);
		Driver driver=new Driver(fd);
		DriverVO vogot=driver.getDriverbyName(name);
		return vogot;
	}

}
