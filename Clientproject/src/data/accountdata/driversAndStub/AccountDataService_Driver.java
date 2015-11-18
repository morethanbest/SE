package data.accountdata.driversAndStub;

import java.rmi.RemoteException;

import po.AccountPO;
import dataservice.accountdataservice.AccountDataService;

public class AccountDataService_Driver {

	public void drive(AccountDataService accountDataService) {
		try {
			accountDataService.addAccount(new AccountPO(00001, "qinliu", 0));
		} catch (RemoteException e) {
			System.out.println("Add Faliure!\n");
		}
		try {
			accountDataService.deleteAccount(new AccountPO(00001, "qinliu", 0));
		} catch (RemoteException e) {
			System.out.println("Delete Faliure!\n");
		}
		try {
			accountDataService.updateAccount(new AccountPO(00001, "qinliu", 0));
		} catch (RemoteException e1) {
			System.out.println("Update Faliure!\n");
		}
		try {
			AccountPO po = accountDataService.findAccount("qinliu");
			if(po != null){
				System.out.println("Got it!");
				System.out.println("ID is " + po.getId());
				System.out.println("Accountname is " + po.getAccountname());
				System.out.println("Accountsum is " + po.getAccountsum());
			}else{
				System.out.println("Got nothing!");
			}
		} catch (RemoteException e) {
			System.out.println("Find Faliure!\n");
		}
	}
	public static void main(String[] args) {
		AccountDataService accountDataService = new AccountDataService_Stub();
		AccountDataService_Driver driver = new AccountDataService_Driver();
		driver.drive(accountDataService);
	}
}
