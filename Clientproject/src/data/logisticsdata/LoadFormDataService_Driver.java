package data.logisticsdata;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.Formstate;
import po.Hall;
import po.LoadPO;
import dataservice.logisticsdataservice.LoadFormDataService;

public class LoadFormDataService_Driver {

	public void drive(LoadFormDataService loadFormDataController) throws RemoteException{
		List<String> allbarcode=new ArrayList<String>();
		allbarcode.add("2014940328");
		LoadPO po=new LoadPO(05510, 20131210, "02500", "025002015092100001", Hall.Shanghai, "025000001", "’‘∑¢", "’≈¡¡", allbarcode, 100);
		loadFormDataController.addLoadForm(po);
		loadFormDataController.updateLoadForm(po);
		List<LoadPO> list=loadFormDataController.getLoadForm(Formstate.waiting);
	}
	
	public static void main(String[] args) throws RemoteException{
		LoadFormDataService loadFormDataController=new LoadFormDataService_Stub();
		LoadFormDataService_Driver driver=new LoadFormDataService_Driver();
		driver.drive(loadFormDataController);
		
	}

}
