package businesslogic.balancebl.RecordcollectPack;

import java.rmi.RemoteException;
import java.util.List;

import businesslogic.logisticsbl.CenterloadPack.FindCenterload;
import businesslogicservice.balanceblservice.RecordCollectBlService;
import po.Formstate;
import po.ResultMessage;
import vo.RecordcollectVO;
import po.ResultMessage;


public class RecordcollectController implements RecordCollectBlService{
	
	@Override
	public ResultMessage Recordcollect(RecordcollectVO vo) {
		// TODO Auto-generated method stub
		Addcollect add=new Addcollect();
		Recordcollect record=new Recordcollect(add);
		ResultMessage result=record.AddRecordcollect(vo);
		return  result;
	}

	@Override
	public ResultMessage updateCollect(RecordcollectVO vo)  {
		Updatecollect update=new Updatecollect();
		Recordcollect record=new Recordcollect(update);
		ResultMessage result=record.updateRecordcollect(vo);
		return result;
	}

	@Override
	public List<RecordcollectVO> findform(Formstate state, String orgcode)  {
		Findcollect find=new Findcollect();
		Recordcollect record=new Recordcollect(find);
		List<RecordcollectVO> list=record.findforms(state,orgcode);
		return list;
	}



	@Override
	public String getid(String orgcode)  {
		IdInfo idgetter=new IdInfo();
		String id=idgetter.getid(orgcode);
		return id;
	}


}
