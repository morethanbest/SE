package dataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.NewbookPO;
import po.ResultMessage;

public interface NewBookDataService {
	public ResultMessage addNewBook(NewbookPO po)throws RemoteException;
	
	public List<NewbookPO> findNewBook(long time)throws RemoteException;
}
