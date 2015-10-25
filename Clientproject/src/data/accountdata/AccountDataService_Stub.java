package data.accountdata;

import java.rmi.RemoteException;

import po.AccountPO;
import dataservice.accountdataservice.AccountDataService;

public class AccountDataService_Stub implements AccountDataService{

	@Override
	public void addAccount(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add Succeed!\n");
		
	}

	@Override
	public void deleteAccount(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
		
	}

	@Override
	public void updateAccount(AccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

	@Override
	public AccountPO findAccount(String accountname) throws RemoteException {
		// TODO Auto-generated method stub
		return new AccountPO(123456,accountname,100.00);
	}

	

}
