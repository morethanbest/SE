package businesslogic.balancebl.BalancePack;

import java.util.ArrayList;
import java.util.List;

import po.RecordcollectPO;
import po.RecordpayPO;
import vo.BalanceviewVO;

public class MockBalanceview extends Balanceview{
	public BalanceviewVO getBalanceview(){
		//假设已经调到收支的po
		List<RecordcollectPO> collect = new ArrayList<RecordcollectPO>();
		List<RecordpayPO> pay = new ArrayList<RecordpayPO>();
		List<String> allordercode =new ArrayList<String>();
		collect.add(new RecordcollectPO(1, 20150101, 100, "ss",allordercode ));
		pay.add(new RecordpayPO(1, 20150112, 1, "sk", "charge", 0, 0, 0, 0, "wu"));
		double collectsum=0;
		double paysum=0;
		double interest=0;
		for(int i=0;i<collect.size();i++){
			collectsum+=collect.get(i).getCollectionsum();
		}
		for(int i=0;i<pay.size();i++){
			paysum+=pay.get(i).getPaysum();
		}
		interest=collectsum-paysum;
		BalanceviewVO vo=new BalanceviewVO(collectsum, paysum, interest);
		return vo;
		
	}

}
