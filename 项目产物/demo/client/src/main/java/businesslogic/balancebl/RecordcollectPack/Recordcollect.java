package businesslogic.balancebl.RecordcollectPack;

import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.RecordcollectPO;
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
		String accountcode=vo.getAccountcode();
		double collectionsum=vo.getCollectionsum();
		String collectionman=vo.getCollectionman();
		List<String> allordercode=vo.getAllordercode();
		Formstate state=vo.getFormstate();

		add.set(id,collectiontime,accountcode,collectionsum,collectionman,allordercode,state);
		ResultMessage result=add.passadd();
		return result;
	}

	public ResultMessage updateRecordcollect(RecordcollectVO vo){
		String  id=vo.getid();
		long collectiontime=vo.getCollectiontime();
		String accountcode=vo.getAccountcode();
		double collectionsum=vo.getCollectionsum();
		String collectionman=vo.getCollectionman();
		List<String> allordercode=vo.getAllordercode();
		Formstate state=vo.getFormstate();

		update.set(id, collectiontime, accountcode, collectionsum, collectionman, allordercode, state);
		ResultMessage result=update.passupdate();
		return result;
	}

	public List<RecordcollectVO>  findforms(Formstate state,String orgcode){
		List<RecordcollectPO> pos=find.findforms(state,orgcode);
		List<RecordcollectVO> list=new ArrayList<RecordcollectVO>();
		for(int i=0;i<=pos.size()-1;i++) {
			RecordcollectPO po=pos.get(i);
			String id=po.getId();
			long collectiontime=po.getCollectiontime();

			String accountcode=po.getAccountcode();
			double collectionsum=po.getCollectionsum();
			String collectionman=po.getCollectionman();
			List<String> allordercode=po.getAllordercode();
			Formstate documentstate=po.getDocumentstate();

			RecordcollectVO vo=new RecordcollectVO(id,collectiontime,accountcode,collectionsum,collectionman,allordercode,documentstate);
			list.add(vo);

		}
		return list;



	}

}
