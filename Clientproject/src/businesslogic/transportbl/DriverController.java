package businesslogic.transportbl;

import java.rmi.RemoteException;

import vo.DriverVO;
import vo.ResultMessage;
import businesslogicservice.transportblservice.DriverBlService;

public class DriverController implements DriverBlService{

	public DriverController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultMessage addDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage revDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverVO getDriverbyDN(String driverNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DriverVO getDriverbyName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
