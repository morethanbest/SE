package data.managerdata;

import java.rmi.RemoteException;

import po.ConstantsPO;
import dataservice.managerdataservice.ConstantsDataService;

public class ConstantsDataService_Driver {

	public void drive(ConstantsDataService constantsDataController){
		ConstantsPO po=new ConstantsPO(00120, "Shanghai--Nanajing", 266);
		try {
			constantsDataController.addConstants(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Add Failure!");
		}
		try {
			constantsDataController.deleteConstants(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Delete Failure!");
		}
		
		try {
			constantsDataController.updateConstants(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Update Failure!");
		}
		try {
			ConstantsPO po2=constantsDataController.findConstants(112);
			if(po2==null)
				System.out.println("No PO Exists!");
			else
				System.out.println("Get PO Succeed!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Find PO Failure!");
		}
		
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		ConstantsDataService constantsDataController=new ConstantsDataService_Stub();
		ConstantsDataService_Driver driver=new ConstantsDataService_Driver();
		driver.drive(constantsDataController);
	}

}
