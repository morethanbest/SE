package businesslogic.balancebl.BalancePack;

import vo.BalanceviewVO;

public class Balance {
	MockIdInfo idInfo;
	MockBalanceview balanceview=new MockBalanceview();
	public Balance(MockIdInfo idInfo){
		this.idInfo=idInfo;
	}
	public BalanceviewVO getBalanceview(){
		BalanceviewVO vo=balanceview.getBalanceview();
		return vo;
	}

}
