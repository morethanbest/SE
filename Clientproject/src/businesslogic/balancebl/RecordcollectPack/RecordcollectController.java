package businesslogic.balancebl.RecordcollectPack;

import java.rmi.RemoteException;

import businesslogicservice.balanceblservice.RecordCollectBlService;
import vo.RecordcollectVO;
import vo.ResultMessage;


public class RecordcollectController implements RecordCollectBlService{
	
	@Override
	public ResultMessage Recordcollect(RecordcollectVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}


}