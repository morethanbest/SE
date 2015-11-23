package businesslogic.accountbl.NewBookPack;

import java.rmi.RemoteException;

import vo.NewbookVO;
import vo.ResultMessage;
import businesslogicservice.accountblservice.NewBookBlService;

public class NewBookController implements NewBookBlService {
	public ResultMessage NewBook(NewbookVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.success;
	}
}
