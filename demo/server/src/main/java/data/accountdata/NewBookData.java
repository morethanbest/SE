package data.accountdata;

import dataservice.accountdataservice.NewBookDataService;
import po.NewbookPO;
import po.ResultMessage;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class NewBookData extends UnicastRemoteObject implements NewBookDataService{

	public NewBookData() throws  RemoteException{
		super();
	}



	@Override
	public ResultMessage addNewBook(NewbookPO po) throws RemoteException {
		return null;
	}

	@Override
	public List<NewbookPO> findNewBook(long time) throws RemoteException {
		return null;
	}
}
