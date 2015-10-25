package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.List;

import po.DeliveryPO;
import po.Formstate;
import dataservice.logisticsdataservice.ArrivalFormDataService;
import dataservice.logisticsdataservice.DeliveryFormDataService;

public class DeliveryFormDataService_Driver {
	
	
	public void drive(DeliveryFormDataService deliveryFormDataController) throws RemoteException{
		DeliveryPO po=new DeliveryPO(12056, 20150121, "0120641289", "Ëï½¡");
		deliveryFormDataController.addDeliveryForm(po);
		deliveryFormDataController.updateDeliveryForm(po);
		List<DeliveryPO> list=deliveryFormDataController.getDeliveryForm(Formstate.waiting);
		
	}
	public static void main(String[] args) throws RemoteException{
		DeliveryFormDataService deliveryFormDataController=new DeliveryFormDataService_Stub();
		DeliveryFormDataService_Driver driver= new DeliveryFormDataService_Driver();
		driver.drive(deliveryFormDataController);
		
	}

}
