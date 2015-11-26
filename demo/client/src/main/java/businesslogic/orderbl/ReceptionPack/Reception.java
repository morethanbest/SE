package businesslogic.orderbl.ReceptionPack;

import po.ResultMessage;
import vo.ReceptionVO;

public class Reception {
	RecordReception record;
	public Reception(RecordReception record){
		this.record=record;
	}
	public ResultMessage record(ReceptionVO vo){
		String ordercode=vo.getCodeofreceiving();
		String receiver=vo.getReceiver();
		long receivingtime=vo.getReceivingtime();
		record.setRecordInfo(ordercode, receiver, receivingtime);
		ResultMessage result=record.Record();
		return result;
	}

}
