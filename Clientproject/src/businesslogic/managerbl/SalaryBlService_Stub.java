package businesslogic.managerbl;

import java.rmi.RemoteException;

import businesslogicservice.managerblservice.SalaryBlSrevice;
import vo.ResultMessage;
import vo.SalaryVO;

public class SalaryBlService_Stub implements SalaryBlSrevice {

	@Override
	public ResultMessage salary(SalaryVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
