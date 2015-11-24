package businesslogic.logisticsbl.stub;

import java.rmi.RemoteException;
import java.util.List;

import po.DeliveryPO;
import po.LogisticsPO;
import vo.DeliveryVO;
import vo.ResultMessage;
import businesslogicservice.logisticsblservice.DeliveryBlService;
import dataservice.logisticsdataservice.DeliveryFormDataService;
import dataservice.logisticsdataservice.LogisticsInfoService;

public class DeliveryBlServiceImpl implements DeliveryBlService{
	
	DeliveryFormDataService deliveryFormDataService;
	LogisticsInfoService logisticsInfoService;
	
	@Override
	public ResultMessage Delivery(DeliveryVO vo) {
		long newID;
		try {
			newID = deliveryFormDataService.findLastID() + 1;
			DeliveryPO po = new DeliveryPO(newID, vo.getArrivaltime(), vo.getBarcode(), vo.getDelivorinfo());
			deliveryFormDataService.addDeliveryForm(po);
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

	@Override
	public ResultMessage update(DeliveryVO vo) {
		try {
			LogisticsPO po = logisticsInfoService.findLogisticsInfo(vo.getBarcode());
			List<String> history = po.getHistory();
			history.add("ÅÉ¼þÖÐ...");
			logisticsInfoService.update(po);
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

}
