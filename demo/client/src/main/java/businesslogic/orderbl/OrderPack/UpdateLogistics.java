package businesslogic.orderbl.OrderPack;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.orderdataservice.LogisticsDataService;
import init.RMIHelper;
import po.LogisticsPO;
import po.ResultMessage;
import vo.OrderVO;

public class UpdateLogistics {
	public ResultMessage updatebyorder(OrderVO vo){
		LogisticsDataService logisticsDataService=RMIHelper.getLogisticsdata();
		ArrayList<String> history=new ArrayList<String>();
		history.add("揽件");
		LogisticsPO po=new LogisticsPO("揽件", history, vo.getOrdercode());
		ResultMessage resultMessage;
		try {
			resultMessage = logisticsDataService.addLogistics(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultMessage=ResultMessage.failure;
		}
		return resultMessage;
	}

}
