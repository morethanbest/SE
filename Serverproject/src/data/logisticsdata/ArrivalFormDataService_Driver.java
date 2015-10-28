package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.List;

import po.ArrivalPO;
import po.Arrivalstate;
import po.Formstate;
import po.Hall;
import dataservice.logisticsdataservice.ArrivalFormDataService;

public class ArrivalFormDataService_Driver {
	
	
	public void drive(ArrivalFormDataService arrivalFormDataController) throws RemoteException{
		ArrivalPO po=new ArrivalPO(1205656, "02507", 20130417, "0251201411200000002", Hall.Shanghai, Arrivalstate.intact);
		arrivalFormDataController.addArrivalForm(po);
		arrivalFormDataController.updateArrivalForm(po);
		
		List<ArrivalPO> list=arrivalFormDataController.getArrivalForm(Formstate.waiting);
		System.out.println("get PO list succeed!\n");
	}
		
	public static void main(String[] args) throws RemoteException{
		ArrivalFormDataService arrivalFormDataController=new ArrivalFormDataService_Stub();
		ArrivalFormDataService_Driver driver= new ArrivalFormDataService_Driver();
		driver.drive(arrivalFormDataController);
		
	}

}
