package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.NewbookPO;
import po.ResultMessage;

public interface NewBookDataService extends Remote {
	public ResultMessage addNewBook(NewbookPO po)throws RemoteException;
	
	public 	NewbookPO findNewBook(long time)throws RemoteException;

	
	//用于得到5个list，id和time随意写
	public NewbookPO getLastBook() throws RemoteException;

	public long getid()throws  RemoteException;
	}
