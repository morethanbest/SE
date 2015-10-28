package data.balancedata;

import java.rmi.RemoteException;
import java.util.List;

import po.DebitnotePO;
import po.Formstate;
import dataservice.balancedataservice.DebitnoteFormDataService;

public class DebitnoteFormDataService_Driver {
	public void drive(DebitnoteFormDataService debitnoteFormDataService) throws RemoteException{
		debitnoteFormDataService.addDebitnoteForm(new DebitnotePO(122345, 20140312,"南京大学医院","李刚", "南京大学", 200000, "南京汉中路"));
		List<DebitnotePO> list = debitnoteFormDataService.getDebitnoteForm(Formstate.waiting);
		System.out.println("Got it!");
		System.out.println("It has " + list.size() + " DebitnoteForm");
		System.out.println("ID is " + list.get(0).getId());
	}
	public static void main(String[] args) throws RemoteException {
		DebitnoteFormDataService debitnoteFormDataService = new DebitnoteFormDataService_Stub();
		DebitnoteFormDataService_Driver driver = new DebitnoteFormDataService_Driver();
		driver.drive(debitnoteFormDataService);
	}
}
