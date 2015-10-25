package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.Hall;
import po.RecordtransPO;
import dataservice.logisticsdataservice.RecordtransFormDataService;

public class RecordtransFormDataService_Driver {

	public void drive(RecordtransFormDataService recordtransFormDataController) throws RemoteException{
		List<String> allbarcode=new ArrayList<String>();
		allbarcode.add("2014940328");
		RecordtransPO po=new RecordtransPO(1228565, 20140214, 20140301, "0251201411200000002", "CZ3903", Hall.Nanjing, Hall.Shanghai, "0122048", "ÀîÍú", allbarcode ,200);
		recordtransFormDataController.addRecordtransForm(po);
		recordtransFormDataController.updateRecordtransForm(po);
		recordtransFormDataController.getRecordtransForm(Formstate.waiting);
	}
	public static void main(String[] args) throws RemoteException{
		RecordtransFormDataService recordtransFormDataController=new RecordtransFormDataService_Stub();
		RecordtransFormDataService_Driver driver=new RecordtransFormDataService_Driver();
		driver.drive(recordtransFormDataController);
		
	}
}
