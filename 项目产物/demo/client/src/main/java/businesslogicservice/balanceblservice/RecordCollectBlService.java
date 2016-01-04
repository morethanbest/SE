package businesslogicservice.balanceblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.RecordcollectVO;

public interface RecordCollectBlService {//营业厅的收款单
	public ResultMessage Recordcollect(RecordcollectVO vo);

	public ResultMessage updateCollect(RecordcollectVO vo) ;

	public List<RecordcollectVO> findform(Formstate state,String orgcode);

	public String getid(String orgcode);







}
