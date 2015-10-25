package dataservice.accountdataservice;

import java.rmi.RemoteException;

import po.AccountPO;

public interface AccountDataService {
	public void addAccount(AccountPO po)throws RemoteException;
	
	public void deleteAccount(AccountPO po)throws RemoteException;
	
	public void updateAccount(AccountPO po)throws RemoteException;
	
	public AccountPO findAccount(String accountname)throws RemoteException;
}
