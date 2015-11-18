package data.userdata.driversAndStub;

import java.rmi.RemoteException;

import po.UserPO;
import dataservice.userdataservice.UserDataService;

public class UserDataService_Driver {
	public void drive(UserDataService userDataService) throws RemoteException{
		userDataService.add(new UserPO(0153015322, "уеоЧ", "552530", "HIGH"));
		userDataService.delete(new UserPO(01532, "уеоЧ", "552530", "HIGH"));
		userDataService.update(new UserPO(01532, "уеоЧ", "552530", "HIGH"));
		UserPO po = userDataService.find(01532);
		System.out.println("Got it!");
		System.out.println("User's name is " + po.getUsername());
	}
	public static void main(String[] args) throws RemoteException {
		UserDataService userDataService = new UserDataService_Stub();
		UserDataService_Driver driver = new UserDataService_Driver();
		driver.drive(userDataService);
	}
}
