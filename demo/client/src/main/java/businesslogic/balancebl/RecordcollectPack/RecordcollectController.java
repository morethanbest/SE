package businesslogic.balancebl.RecordcollectPack;

import java.rmi.RemoteException;
import java.util.List;

import businesslogicservice.balanceblservice.RecordCollectBlService;
import po.Formstate;
import po.ResultMessage;
import vo.RecordcollectVO;
import vo.ResultMessage;


public class RecordcollectController implements RecordCollectBlService{
	
	@Override
	public ResultMessage Recordcollect(RecordcollectVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

	@Override
	public ResultMessage updateCollect(RecordcollectVO vo) throws RemoteException {
		return null;
	}

	@Override
	public List<RecordcollectVO> findforms(String orgcode, Formstate state) throws RemoteException {
		return null;
	}

	@Override
	public String getid(String orgcode) throws RemoteException {
		return null;
	}


}
