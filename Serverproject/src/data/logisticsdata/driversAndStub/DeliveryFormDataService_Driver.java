//package data.logisticsdata.driversAndStub;
//
//import java.rmi.RemoteException;
//import java.util.List;
//
//import po.DeliveryPO;
//import po.Formstate;
//import dataservice.logisticsdataservice.ArrivalFormDataService;
//import dataservice.logisticsdataservice.DeliveryFormDataService;
//
//public class DeliveryFormDataService_Driver {
//	
//	
//	public void drive(DeliveryFormDataService deliveryFormDataController) {
//		DeliveryPO po=new DeliveryPO(12056, 20150121, "0120641289", "�｡");
//		try {
//			deliveryFormDataController.addDeliveryForm(po);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Add Failure!");
//		}
//		try {
//			deliveryFormDataController.updateDeliveryForm(po);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Update Failure!");
//		}
//		try {
//			List<DeliveryPO> list=deliveryFormDataController.getDeliveryForm(Formstate.waiting);
//			if(list==null)
//				System.out.println("No List Exists!");
//			else 
//				System.out.println("Get List Succeed!");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Get List Failure!");
//		}
//		
//	}
//	public static void main(String[] args) {
//		DeliveryFormDataService deliveryFormDataController=new DeliveryFormDataService_Stub();
//		DeliveryFormDataService_Driver driver= new DeliveryFormDataService_Driver();
//		driver.drive(deliveryFormDataController);
//		
//	}
//
//}
