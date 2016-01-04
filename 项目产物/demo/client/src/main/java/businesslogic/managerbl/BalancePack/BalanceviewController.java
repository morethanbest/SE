package businesslogic.managerbl.BalancePack;

import java.rmi.RemoteException;

import vo.BalanceviewVO;
import businesslogicservice.balanceblservice.BalanceviewBlService;

public class BalanceviewController implements BalanceviewBlService {
	@Override
	public BalanceviewVO getBalanceview() {
		// TODO Auto-generated method stub
		Balanceview view=new Balanceview();
		BalanceviewVO vo=view.view();
		return  vo;

	}
}
