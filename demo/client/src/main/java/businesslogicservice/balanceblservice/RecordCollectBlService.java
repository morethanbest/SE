package businesslogicservice.balanceblservice;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.ResultMessage;
import vo.RecordcollectVO;

public interface RecordCollectBlService {//营业厅的收款单
	public ResultMessage Recordcollect(RecordcollectVO vo)throws RemoteException;

	public ResultMessage updateCollect(RecordcollectVO vo) throws  RemoteException;

	public List<RecordcollectVO> findform(Formstate state,String orgcode)throws RemoteException;

	public String getid(String orgcode)throws  RemoteException;







}
