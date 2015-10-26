package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.Hall;
import po.RecordtransPO;
import dataservice.logisticsdataservice.RecordtransFormDataService;

public class RecordtransFormDataService_Driver {

	public void drive(RecordtransFormDataService recordtransFormDataController) {
		List<String> allbarcode=new ArrayList<String>();
		allbarcode.add("2014940328");
		RecordtransPO po=new RecordtransPO(1228565, 20140214, 20140301, "0251201411200000002", "CZ3903", Hall.Nanjing, Hall.Shanghai, "0122048", "ÀîÍú", allbarcode ,200);
		try {
			recordtransFormDataController.addRecordtransForm(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Add Failure!");
		}
		try {
			recordtransFormDataController.updateRecordtransForm(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Update Failure!");
		}
		try {
			List<RecordtransPO> list=recordtransFormDataController.getRecordtransForm(Formstate.waiting);
			if(list==null)
				System.out.println("Get No List !");
			else
				System.out.println("Get List Succeed!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Get List Failure!");
		}
	}
	public static void main(String[] args) {
		RecordtransFormDataService recordtransFormDataController=new RecordtransFormDataService_Stub();
		RecordtransFormDataService_Driver driver=new RecordtransFormDataService_Driver();
		driver.drive(recordtransFormDataController);
		
	}
}
