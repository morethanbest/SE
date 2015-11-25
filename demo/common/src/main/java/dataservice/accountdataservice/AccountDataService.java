package dataservice.accountdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.AccountPO;
import po.ResultMessage;


public interface AccountDataService extends Remote {
	public ResultMessage addAccount(AccountPO po)throws RemoteException;//po里name不可重名
	
	public ResultMessage deleteAccount(AccountPO po)throws RemoteException;
	
	public ResultMessage updateAccount(AccountPO po)throws RemoteException;
	
	public AccountPO findAccount(String accountname)throws RemoteException;
}
