package businesslogicservice.accountblservice;

import java.rmi.RemoteException;

import po.ResultMessage;
import vo.NewbookVO;

public interface NewBookBlService {
	public ResultMessage NewBook (long id);

	public NewbookVO find(long time);


	public long getid();

}
