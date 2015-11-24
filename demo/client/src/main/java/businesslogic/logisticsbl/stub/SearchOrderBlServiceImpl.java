package businesslogic.logisticsbl.stub;

import java.rmi.RemoteException;

import po.LogisticsPO;
import vo.LogisticsVO;
import businesslogicservice.logisticsblservice.SearchOrderBlService;
import dataservice.logisticsdataservice.LogisticsInfoService;

public class SearchOrderBlServiceImpl implements SearchOrderBlService{
	
	LogisticsInfoService logisticsInfoService;
	@Override
	public LogisticsVO getOrderbyOrderNumber(String orderNumber) {
		LogisticsPO po;
		try {
			po = logisticsInfoService.findLogisticsInfo(orderNumber);
		} catch (RemoteException e) {
			return null;
		}
		return new LogisticsVO(po.getState(), po.getHistory(), po.getOrdernum());
	}
	
}
