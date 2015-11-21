//package data.managerdata.driversAndStub;
//
//import java.rmi.RemoteException;
//
//import po.Job;
//import po.SalaryMode;
//import po.SalaryPO;
//import dataservice.managerdataservice.SalaryDataService;
//
//public class SalaryDataService_Driver {
//
//	public void drive(SalaryDataService salaryDataController){
//		SalaryPO po=new SalaryPO(03, Job.drivers, SalaryMode.monthly,5000 , 0);
//		try {
//			salaryDataController.updateSalary(po);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Update Succeed!");
//		}
//		
//		try {
//			SalaryPO po2=salaryDataController.findSalary(22);
//			if(po2==null)
//				System.out.println("No PO Exists");
//			else
//				System.out.println("Get PO Succeed!");
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Get PO Failure");
//		}
//		
//		
//		
//		
//	}
//	
//	public static void main(String[] args) {
//		SalaryDataService salaryDataController=new SalaryDataService_Stub();
//		SalaryDataService_Driver driver=new SalaryDataService_Driver();
//		driver.drive(salaryDataController);
//	}
//
//}
