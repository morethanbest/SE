package dataservice.accountdataservice;

import java.rmi.RemoteException;

import po.AccountPO;
import po.ResultMessage;

public interface AccountDataService {
	public ResultMessage addAccount(AccountPO po)throws RemoteException;
	
	public ResultMessage deleteAccount(AccountPO po)throws RemoteException;
	
	public ResultMessage updateAccount(AccountPO po)throws RemoteException;
	
	public AccountPO findAccount(String accountname)throws RemoteException;
}
