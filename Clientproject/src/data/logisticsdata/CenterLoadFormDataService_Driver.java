package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.CenterloadPO;
import po.Formstate;
import po.Hall;
import dataservice.logisticsdataservice.ArrivalFormDataService;
import dataservice.logisticsdataservice.CenterLoadFormDataService;

public class CenterLoadFormDataService_Driver {
	
	public void drive(CenterLoadFormDataService centerLoadFormDataController) {
		List<String> allbarcode=new ArrayList<String>();
		allbarcode.add("2014940328");
		CenterloadPO po=new CenterloadPO(156646, 20131201, "0251201304120000001", Hall.Shanghai, "0250000001", "ÀîÍú", "ÕÅ¿ª", allbarcode, 200);
		try {
			centerLoadFormDataController.addCenterLoadForm(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Add Failure!");
		}
		try {
			centerLoadFormDataController.updateCenterLoadForm(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Update Failure!");
		}
		try {
			List<CenterloadPO> list=centerLoadFormDataController.getCenterLoadForm(Formstate.waiting);
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
		CenterLoadFormDataService centerLoadFormDataController=new CenterLoadFormDataService_Stub();
		CenterLoadFormDataService_Driver driver= new CenterLoadFormDataService_Driver();
		driver.drive(centerLoadFormDataController);
		
	}

}
