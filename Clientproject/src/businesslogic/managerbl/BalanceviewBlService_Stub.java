package businesslogic.managerbl;

import java.rmi.RemoteException;

import businesslogicservice.balanceblservice.BalanceviewBlService;
import vo.BalanceviewVO;

public class BalanceviewBlService_Stub implements BalanceviewBlService {

	@Override
	public BalanceviewVO getBalanceview() throws RemoteException {
		// TODO Auto-generated method stub
		return new BalanceviewVO(1,1,1);
	}

}
