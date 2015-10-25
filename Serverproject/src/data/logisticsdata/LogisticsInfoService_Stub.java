package data.logisticsdata;

import java.rmi.RemoteException;

import po.LogisticsPO;
import dataservice.logisticsdataservice.LogisticsInfoService;

public class LogisticsInfoService_Stub implements LogisticsInfoService{

	@Override
	public LogisticsPO findLogisticsInfo(long ordernum) throws RemoteException {
		// TODO Auto-generated method stub
		String[] history={"Nanjing hall 02501","Nanjing center 0250"};
		LogisticsPO po=new LogisticsPO(2201255, "on the hall 02501", history,2);
		return po;
	}

	

}
