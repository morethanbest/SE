package businesslogic.balancebl.RecordcollectPack;

import java.util.List;

import po.Formstate;
import po.RecordcollectPO;
import vo.ResultMessage;

public class MockRecord extends Record{
	long id;
	long collectiontime;
	double collectionsum;
	String collectionman;
	List<String> allordercode;
	Formstate documentstate=Formstate.waiting;
	public void setRecordInfo(long id,long collectiontime,double collectionsum,String collectionman,List<String> allordercode){
		this.id=id;
		this.collectiontime=collectiontime;
		this.collectionsum=collectionsum;
		this.collectionman=collectionman;
		this.allordercode=allordercode;
	}
	public ResultMessage Recordcollect(){
		RecordcollectPO po=new RecordcollectPO(id, collectiontime, collectionsum, collectionman, allordercode);
		return ResultMessage.success;
	}
}
