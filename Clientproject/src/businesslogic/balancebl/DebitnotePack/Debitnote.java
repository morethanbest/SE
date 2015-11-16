package businesslogic.balancebl.DebitnotePack;

import vo.DebitnoteVO;
import vo.ResultMessage;

public class Debitnote {
	MockIdInfo idInfo;
	MockRecord record;
	public Debitnote(MockIdInfo idInfo,MockRecord record){
		this.idInfo=idInfo;
		this.record=record;
	}
	public ResultMessage RecordDebitnote(DebitnoteVO vo){
		long id=idInfo.getid();
		long debittime=vo.getDebittime();
		String debitunit=vo.getDebitunit();
		String debitor=vo.getDebitor();
		String debitside=vo.getDebitside();
		double sum=vo.getSum();
		String location=vo.getLocation();
		record.setRecordInfo(id, debittime, debitunit, debitor, debitside, sum, location);
		ResultMessage result=record.RecordDebitnote();
		return result;
	}
}
