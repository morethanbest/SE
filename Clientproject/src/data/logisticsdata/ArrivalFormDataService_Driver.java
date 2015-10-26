package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;
import po.Arrivalstate;
import po.Formstate;
import po.Hall;
import dataservice.logisticsdataservice.ArrivalFormDataService;

public class ArrivalFormDataService_Driver {
	
	
	public void drive(ArrivalFormDataService arrivalFormDataController) {
		ArrivalPO po=new ArrivalPO(1205656, "02507", 20130417, "0251201411200000002", Hall.Shanghai, Arrivalstate.intact);
		try {
			arrivalFormDataController.addArrivalForm(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Add Failure!");
		}
		try {
			arrivalFormDataController.updateArrivalForm(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Update Failure!");
		}
		
		try {
			List<ArrivalPO> list=arrivalFormDataController.getArrivalForm(Formstate.waiting);
			if(list==null)
				System.out.println("No List Exists!");
			else
				System.out.println("Get List Succeed!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Got POlist Failure");
		}
		
	}
		
	public static void main(String[] args) {
		ArrivalFormDataService arrivalFormDataController=new ArrivalFormDataService_Stub();
		ArrivalFormDataService_Driver driver= new ArrivalFormDataService_Driver();
		driver.drive(arrivalFormDataController);
		
	}

}
