package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.Hall;
import po.LoadPO;
import dataservice.logisticsdataservice.LoadFormDataService;

public class LoadFormDataService_Driver {

	public void drive(LoadFormDataService loadFormDataController) {
		List<String> allbarcode=new ArrayList<String>();
		allbarcode.add("2014940328");
		LoadPO po=new LoadPO(05510, 20131210, "02500", "025002015092100001", Hall.Shanghai, "025000001", "’‘∑¢", "’≈¡¡", allbarcode, 100);
		try {
			loadFormDataController.addLoadForm(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Add Failure!");
		}
		try {
			loadFormDataController.updateLoadForm(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Update Failure!");
		}
		try {
			List<LoadPO> list=loadFormDataController.getLoadForm(Formstate.waiting);
			if(list==null)
				System.out.println("No List Exists!");
			else
				System.out.println("Get List Succeed!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Get List Failure!");
		}
	}
	
	public static void main(String[] args) {
		LoadFormDataService loadFormDataController=new LoadFormDataService_Stub();
		LoadFormDataService_Driver driver=new LoadFormDataService_Driver();
		driver.drive(loadFormDataController);
		
	}

}
