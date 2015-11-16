package businesslogic.balancebl.BalancePack;

import java.rmi.RemoteException;

import vo.BalanceviewVO;
import businesslogicservice.balanceblservice.BalanceviewBlService;

public class BalanceviewController implements BalanceviewBlService {
	@Override
	public BalanceviewVO getBalanceview() throws RemoteException {
		// TODO Auto-generated method stub
		return new BalanceviewVO(100,50,50);
	}
}
