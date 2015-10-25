package businesslogic.managerbl;

import java.rmi.RemoteException;

import po.Job;
import vo.ResultMessage;
import vo.StaffVO;

public class StaffBlService implements businesslogicservice.managerblservice.StaffBlService {

	@Override
	public ResultMessage addStaff(StaffVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public StaffVO delStaff() throws RemoteException {
		// TODO Auto-generated method stub
		return new StaffVO("1",Job.Courier);
	}

	@Override
	public ResultMessage revStaff(StaffVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage getStaff(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
