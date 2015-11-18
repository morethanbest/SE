package data.logisticsdata.driversAndStub;

import java.rmi.RemoteException;

import po.LogisticsPO;
import dataservice.logisticsdataservice.LogisticsInfoService;

public class LogisticsInfoService_Driver {

	public void drive(LogisticsInfoService logisticsInfoController) {
		try {
			LogisticsPO po=logisticsInfoController.findLogisticsInfo("2");
			if(po==null)
				System.out.println("No Logisticsinfo Exists!");
			else
				System.out.println("Get Logisticsinfo Succeed!");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("Get Info Failure!");
		}
	}
	public void main(String[] args) {
		LogisticsInfoService logisticsInfoController=new LogisticsInfoService_Stub();
		LogisticsInfoService_Driver driver=new LogisticsInfoService_Driver();
		driver.drive(logisticsInfoController);
	}

}
