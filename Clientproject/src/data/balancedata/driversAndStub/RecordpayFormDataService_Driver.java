package data.balancedata.driversAndStub;

import java.rmi.RemoteException;
import java.util.List;

import po.Formstate;
import po.RecordpayPO;
import dataservice.balancedataservice.RecordpayFormDataService;

public class RecordpayFormDataService_Driver {
	public void drive(RecordpayFormDataService recordpayFormDataService) throws RemoteException{
		recordpayFormDataService.addRecordpayForm(new RecordpayPO(012664, 20131230, 21000, "’≈¿ˆ", "6461335", 3346, 200, 4000, 1000, "nothing"));
		recordpayFormDataService.updateRecordpayForm(new RecordpayPO(012664, 20131230, 21000, "’≈¿ˆ", "6461335", 3346, 200, 4000, 1000, "nothing"));
		List<RecordpayPO> list1 = recordpayFormDataService.getallRecordpayForm();
		System.out.println("Got it!");
		System.out.println("It has " + list1.size() + " RecordpayForm");
		List<RecordpayPO> list2 = recordpayFormDataService.getRecordpayForm(Formstate.waiting);
		System.out.println("Got it!");
		System.out.println("It has " + list2.size() + " RecordpayForm");
	}
	public static void main(String[] args) throws RemoteException {
		RecordpayFormDataService recordpayFormDataService = new RecordpayFormDataService_Stub();
		RecordpayFormDataService_Driver driver = new RecordpayFormDataService_Driver();
		driver.drive(recordpayFormDataService);
	}
}
