package data.accountdata;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
		return null;
	}
	@Override
	public ResultMessage deleteAccount(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage updateAccount(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AccountPO findAccount(String accountname) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
