package businesslogic.managerbl.stub;

import java.rmi.RemoteException;

import businesslogicservice.managerblservice.BalanceviewBlService;
import vo.BalanceviewVO;

public class BalanceviewBlService_Stub implements BalanceviewBlService {

	@Override
	public BalanceviewVO Balanceview() throws RemoteException {
		// TODO Auto-generated method stub
		return new BalanceviewVO(1,1,1);
	}

	

}
