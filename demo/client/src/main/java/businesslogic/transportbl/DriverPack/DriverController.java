package businesslogic.transportbl.DriverPack;

import java.rmi.RemoteException;

import vo.DriverVO;
import po.ResultMessage;
import businesslogicservice.transportblservice.DriverBlService;

public class DriverController implements DriverBlService{

	

	@Override
	public ResultMessage addDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		AddDriver add=new AddDriver();
		Driver driver=new Driver(add);
		ResultMessage result=driver.addDriver(vo);
		
		return result;
	}

	
	
	
	@Override
	public ResultMessage delDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		DelDriver del=new DelDriver();
		Driver driver=new Driver(del);
		ResultMessage result=driver.delDriver(vo);
		
		return result;
	}

	
	
	
	
	@Override
	public ResultMessage revDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		RevDriver rev=new RevDriver();
		Driver driver=new Driver(rev);
		ResultMessage result=driver.revDriver(vo);
		return result;
	}

	
	
	
	@Override
	public DriverVO getDriverbyDN(String driverNumber) throws RemoteException {
		// TODO Auto-generated method stub
		DriverVO vo=new DriverVO(driverNumber,"abc",1,"321459193621","13214","32153",20150322);
		FindDriver fd=new FindDriver(vo);
		Driver driver=new Driver(fd);
		DriverVO vogot=driver.getDriverbyDN(driverNumber);
		return vogot;
	}

	
	
	
	
	@Override
	public DriverVO getDriverbyName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		
		DriverVO vo=new DriverVO("1",name,1,"321459193621","13214","32153",20150322);
		FindDriver fd=new FindDriver(vo);
		Driver driver=new Driver(fd);
		DriverVO vogot=driver.getDriverbyName(name);
		return vogot;
	}

}
