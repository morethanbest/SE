package businesslogic.managerbl.stub;

import java.rmi.RemoteException;

import po.Job;
import vo.ResultMessage;
import vo.StaffVO;

public class StaffBlService_Stub implements businesslogicservice.managerblservice.StaffBlService {

	@Override
	public ResultMessage addStaff(StaffVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}


	@Override
	public ResultMessage revStaff(StaffVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}


	@Override
	public ResultMessage delStaff(StaffVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public StaffVO getStaff(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return new StaffVO("1",Job.Courier);
	}

}