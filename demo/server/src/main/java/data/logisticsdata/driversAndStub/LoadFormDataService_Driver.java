//package data.logisticsdata.driversAndStub;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.List;
//
//import po.Formstate;
//import po.Hall;
//import po.HallLoadPO;
//import dataservice.logisticsdataservice.HallLoadFormDataService;
//
//public class LoadFormDataService_Driver {
//
//	public void drive(HallLoadFormDataService loadFormDataController) {
//		List<String> allbarcode=new ArrayList<String>();
//		allbarcode.add("2014940328");
//		HallLoadPO po=new HallLoadPO(05510, 20131210, "02500", "025002015092100001", Hall.Shanghai, "025000001", "�Է�", "����", allbarcode, 100);
//		try {
//			loadFormDataController.addLoadForm(po);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Add Failure!");
//		}
//		try {
//			loadFormDataController.updateLoadForm(po);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Update Failure!");
//		}
//		try {
//			List<HallLoadPO> list=loadFormDataController.getLoadForm(Formstate.waiting);
//			if(list==null)
//				System.out.println("No List Exists!");
//			else
//				System.out.println("Get List Succeed!");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Get List Failure!");
//		}
//	}
//	
//	public static void main(String[] args) {
//		HallLoadFormDataService loadFormDataController=new LoadFormDataService_Stub();
//		LoadFormDataService_Driver driver=new LoadFormDataService_Driver();
//		driver.drive(loadFormDataController);
//		
//	}
//
//}
