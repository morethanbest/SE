package dataservice.accountdataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.NewbookPO;

public interface NewBookDataService {
	public void addNewBook(NewbookPO po)throws RemoteException;
	
	public List<NewbookPO> findNewBook(long time)throws RemoteException;
}
