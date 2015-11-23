package businesslogic.balancebl;

import java.rmi.RemoteException;

import businesslogicservice.balanceblservice.BalanceviewBlService;
import vo.BalanceviewVO;

public class BalanceviewBlSerivce_Stub implements BalanceviewBlService {

	@Override
	public BalanceviewVO getBalanceview() throws RemoteException {
		// TODO Auto-generated method stub
		return new BalanceviewVO(100,50,50);
	}

}
