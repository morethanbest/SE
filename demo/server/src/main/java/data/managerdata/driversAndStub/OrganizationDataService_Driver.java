//package data.managerdata.driversAndStub;
//
//import java.rmi.RemoteException;
//
//import po.Organizationtype;
//import po.OrganizationPO;
//import dataservice.managerdataservice.OrganizationDataService;
//
//public class OrganizationDataService_Driver {
//
//	public void drive(OrganizationDataService organizationDataController){
//		OrganizationPO po=new OrganizationPO(02502, "�Ͼ���¥",Organizationtype.hall );
//		try {
//			organizationDataController.addOrganization(po);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Add Failure!");
//		}
//		
//		
//		try {
//			organizationDataController.deleteOrganization(po);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Delete Failure!");
//		}
//		
//		try {
//			organizationDataController.updateOrganization(po);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Update Failure!");
//		}
//		try {
//			OrganizationPO po2=organizationDataController.findOrganization("538652");
//			if(po2==null)
//				System.out.println("No PO Exists!");
//			else
//				System.out.println("Get PO Succeed!");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Get PO Failure!");
//		}
//		
//		
//	}
//	
//	public static void main(String[] args) {
//		OrganizationDataService organizationDataController=new OrganizationDataService_Stub();
//		OrganizationDataService_Driver driver=new OrganizationDataService_Driver();
//		driver.drive(organizationDataController);
//	}
//}
