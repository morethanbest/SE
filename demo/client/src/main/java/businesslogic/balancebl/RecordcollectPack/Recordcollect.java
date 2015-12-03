package businesslogic.balancebl.RecordcollectPack;

import java.util.List;

import po.Formstate;
import vo.RecordcollectVO;
import po.ResultMessage;

public class Recordcollect {
	Addcollect add;
	Updatecollect update;
	Findcollect find;
	public Recordcollect(Addcollect add){

		this.add=add;
	}
	public Recordcollect(Updatecollect update){this.update=update;}
	public Recordcollect(Findcollect find){this.find=find;}


	public ResultMessage AddRecordcollect(RecordcollectVO vo){
		String  id=vo.getid();
		long collectiontime=vo.getCollectiontime();
		double collectionsum=vo.getCollectionsum();
		String collectionman=vo.getCollectionman();
		List<String> allordercode=vo.getAllordercode();
		Formstate state=vo.getFormstate();


		return result;
	}
}
