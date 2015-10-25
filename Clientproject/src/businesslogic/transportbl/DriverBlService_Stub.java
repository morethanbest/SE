package businesslogic.transportbl;

import java.rmi.RemoteException;

import businesslogicservice.transportblservice.DriverBlService;
import vo.DriverVO;
import vo.ResultMessage;

public class DriverBlService_Stub implements DriverBlService {

	@Override
	public ResultMessage addDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage delDriver() throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage revDriver(DriverVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public DriverVO getDriverbyDN(long driverNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return new DriverVO("1","abc",1,"321459193621","13214","32153",20150322);
	}

	@Override
	public DriverVO getDriverbyName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return new DriverVO("1","abc",1,"321459193621","13214","32153",20150322);
	}

}
