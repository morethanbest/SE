package businesslogic.balancebl.RecordcollectPack;

import java.util.List;

import vo.RecordcollectVO;
import vo.ResultMessage;

public class Recordcollect {
	MockIdInfo idInfo;
	MockRecord record;
	public Recordcollect(MockIdInfo idInfo,MockRecord record){
		this.idInfo=idInfo;
		this.record=record;
	}
	public ResultMessage Recordcollect(RecordcollectVO vo){
		long id=idInfo.getid();
		long collectiontime=vo.getCollectiontime();
		double collectionsum=vo.getCollectionsum();
		String collectionman=vo.getCollectionman();
		List<String> allordercode=vo.getAllordercode();
		record.setRecordInfo(id, collectiontime, collectionsum, collectionman, allordercode);
		ResultMessage result=record.Recordcollect();
		return result;
	}
}
