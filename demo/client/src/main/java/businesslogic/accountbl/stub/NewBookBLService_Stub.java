package businesslogic.accountbl.stub;

import java.rmi.RemoteException;

import businesslogicservice.accountblservice.NewBookBlService;
import vo.NewbookVO;
import vo.ResultMessage;

public class NewBookBLService_Stub implements NewBookBlService {

	@Override
	public ResultMessage NewBook(NewbookVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}

}
