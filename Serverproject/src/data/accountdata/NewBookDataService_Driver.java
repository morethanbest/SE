package data.accountdata;

import java.rmi.RemoteException;
import java.util.List;

import po.NewbookPO;
import dataservice.accountdataservice.NewBookDataService;

public class NewBookDataService_Driver {
	
	public void drive(NewBookDataService newBookDataService){
		try {
			newBookDataService.addNewBook(new NewbookPO(12345, null, null, null, null, null));
		} catch (RemoteException e) {
			System.out.println("Add Faliure!\n");
		}
		try {
			List<NewbookPO> pos = newBookDataService.findNewBook(2015);
			System.out.println("Got it!");
			System.out.println("It has " + pos.size() +" Newbook");
			System.out.println("ID is " + pos.get(0).getId());
		} catch (RemoteException e) {
			System.out.println("Find Faliure!\n");
		}
	}
	public static void main(String[] args) {
		NewBookDataService newBookDataService = new NewBookDataService_Stub();
		NewBookDataService_Driver driver = new NewBookDataService_Driver();
		driver.drive(newBookDataService);
	}
}
