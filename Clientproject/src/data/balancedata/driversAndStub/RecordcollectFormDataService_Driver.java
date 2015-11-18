package data.balancedata.driversAndStub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.RecordcollectPO;
import dataservice.balancedataservice.RecordcollectFormDataService;

public class RecordcollectFormDataService_Driver {
	public void drive(RecordcollectFormDataService recordcollectFormDataService) throws RemoteException {
		List<String> allordercode=new ArrayList<String>();
		allordercode.add("1112014245");
		recordcollectFormDataService.addRecordcollectForm(new RecordcollectPO(12244, 20140412, 140000.0, "Õı≈Ù", allordercode));
		recordcollectFormDataService.updateRecordcollectForm(new RecordcollectPO(12244, 20140412, 140000.0, "Õı≈Ù", allordercode));
		List<RecordcollectPO> list1 = recordcollectFormDataService.getallRecordcollectForm();
		System.out.println("Got it!");
		System.out.println("It has " + list1.size() + " Recordcollect");
		List<RecordcollectPO> list2 = recordcollectFormDataService.getRecordcollectForm(Formstate.waiting);
		System.out.println("Got it!");
		System.out.println("It has " + list2.size() + " Recordcollect");
	}
	public static void main(String[] args) throws RemoteException {
		RecordcollectFormDataService recordcollectFormDataService = new RecordcollectFormDataService_Stub();
		RecordcollectFormDataService_Driver driver = new RecordcollectFormDataService_Driver();
		driver.drive(recordcollectFormDataService);
	}
}
