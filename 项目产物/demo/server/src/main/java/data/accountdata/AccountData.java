package data.accountdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.database.accountDB.AccountDB;
import po.AccountPO;
import po.ResultMessage;
import dataservice.accountdataservice.AccountDataService;


public class AccountData extends UnicastRemoteObject implements AccountDataService{
	public AccountData() throws RemoteException{
		super();
	}

	@Override
	public ResultMessage addAccount(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return AccountDB.write(po);
		else
			return ResultMessage.failure;
	}
	@Override
	public ResultMessage deleteAccount(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return AccountDB.delete(po);
		else
			return ResultMessage.failure;
	}
	@Override
	public ResultMessage updateAccount(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if(po!=null)
			return AccountDB.update(po);
		else
			return ResultMessage.failure;
	}
	@Override
	public AccountPO findAccount(String accountname) throws RemoteException {
		// TODO Auto-generated method stub
		if(accountname!=null)
			return AccountDB.search(accountname);
		else 
			return null;
	}

	@Override
	public long getLastId() throws RemoteException {
		// TODO Auto-generated method stub
		return AccountDB.getLastId();
	}

}
