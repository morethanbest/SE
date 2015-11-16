package businesslogic.balancebl.RecordpayPack;

import vo.RecordpayVO;
import vo.ResultMessage;

public class Recordpay {
	MockIdInfo idInfo;
	MockRecord record;
	public Recordpay(MockIdInfo idInfo,MockRecord record){
		this.idInfo=idInfo;
		this.record=record;
	}
	public ResultMessage Recordpay(RecordpayVO vo){
		long id=idInfo.getid();
		long paytime=vo.getPaytime();
		double paysum=vo.getPaysum();
		String payman=vo.getPayman();
		String payaccount=vo.getPayaccount();
		double rent=vo.getRent();
		double fee=vo.getFee();
		double salary=vo.getSalary();
		double reward=vo.getReward();
		String remark=vo.getRemark();
		record.setRecordInfo(id, paytime, paysum, payman, payaccount, rent, fee, salary, reward, remark);
		ResultMessage result=record.Recordpay();
		return result;
	}
}
