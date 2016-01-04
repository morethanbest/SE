package businesslogic.transportbl.DriverPack;

import java.rmi.RemoteException;
import java.util.List;

import vo.DriverVO;
import po.ResultMessage;
import businesslogicservice.transportblservice.DriverBlService;

public class DriverController implements DriverBlService{

	

	@Override
	public ResultMessage addDriver(DriverVO vo)  {
		// TODO Auto-generated method stub

		AddDriver add=new AddDriver();
		Driver driver=new Driver(add);
		ResultMessage result=driver.addDriver(vo);
		
		return result;
	}

	
	
	
	@Override
	public ResultMessage delDriver(DriverVO vo)  {
		// TODO Auto-generated method stub
		DelDriver del=new DelDriver();
		Driver driver=new Driver(del);
		ResultMessage result=driver.delDriver(vo);
		
		return result;
	}

	
	
	
	
	@Override
	public ResultMessage revDriver(DriverVO vo) {
		// TODO Auto-generated method stub
		RevDriver rev=new RevDriver();
		Driver driver=new Driver(rev);
		ResultMessage result=driver.revDriver(vo);
		return result;
	}

	
	
	
	@Override
	public DriverVO getDriverbyDN(String driverNumber,String orgcode) {
		// TODO Auto-generated method stub

		FindDriver fd=new FindDriver();
		Driver driver=new Driver(fd);
		DriverVO vogot=driver.getDriverbyDN(driverNumber,orgcode);
		return vogot;
	}

	
	
	
	
	@Override
	public List<DriverVO> getDriverbyName(String name,String orgcode)  {
		// TODO Auto-generated method stub
		

		FindDriver fd=new FindDriver();
		Driver driver=new Driver(fd);
		List<DriverVO> list=driver.getDriverbyName(name,orgcode);
		return list;
	}

	@Override
	public String getid(String orgcode)  {
		DriverId idgetter=new DriverId();
		String id=idgetter.getid(orgcode);
		return id;
	}



}
