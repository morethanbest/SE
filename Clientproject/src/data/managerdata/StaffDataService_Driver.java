package data.managerdata;

import java.rmi.RemoteException;

import po.Job;
import po.StaffPO;
import dataservice.managerdataservice.StaffDataService;

public class StaffDataService_Driver {

	public void drive(StaffDataService staffDataController){
		StaffPO po=new StaffPO(01235, "ÀîÍú", Job.transfercenter);
		try {
			staffDataController.addStaff(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Add Failure!");
		}
		try {
			staffDataController.deleteStaff(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Delete Failure!");
		}
		try {
			staffDataController.updateStaff(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Update Succeed!");
		}
		
		try {
			StaffPO po2=staffDataController.findStaff(422);
			if(po2==null)
				System.out.println("No PO Exists");
			else
				System.out.println("Get PO Succeed!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Get PO Failure!");
		}
		
	}
	
	public static void main(String[] args) {
		StaffDataService staffDataController=new StaffDataService_Stub();
		StaffDataService_Driver driver=new StaffDataService_Driver();
		driver.drive(staffDataController);
	}
}
