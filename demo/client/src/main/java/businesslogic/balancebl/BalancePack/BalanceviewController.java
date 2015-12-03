package businesslogic.balancebl.BalancePack;

import java.rmi.RemoteException;

import vo.BalanceviewVO;
import businesslogicservice.balanceblservice.BalanceviewBlService;

public class BalanceviewController implements BalanceviewBlService {
	@Override
	public BalanceviewVO getBalanceview() throws RemoteException {
		Balanceview balance=new Balanceview();
		BalanceviewVO vo=balance.viewbalance();
		return vo;
	}
}
