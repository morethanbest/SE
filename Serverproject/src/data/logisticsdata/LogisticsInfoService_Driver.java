package data.logisticsdata;

import java.rmi.RemoteException;

import po.LogisticsPO;
import dataservice.logisticsdataservice.LogisticsInfoService;

public class LogisticsInfoService_Driver {

	public void drive(LogisticsInfoService logisticsInfoController) throws RemoteException{
		LogisticsPO po=logisticsInfoController.findLogisticsInfo(2);
	}
	public void main(String[] args) throws RemoteException{
		LogisticsInfoService logisticsInfoController=new LogisticsInfoService_Stub();
		LogisticsInfoService_Driver driver=new LogisticsInfoService_Driver();
		driver.drive(logisticsInfoController);
	}

}
