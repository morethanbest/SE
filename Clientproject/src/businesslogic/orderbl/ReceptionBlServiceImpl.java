package businesslogic.orderbl;

import java.rmi.RemoteException;

import po.LogisticsPO;
import po.OrdersPO;
import vo.ReceptionVO;
import vo.ResultMessage;
import businesslogicservice.orderblservice.ReceptionBlService;
import dataservice.orderdataservice.LogisticsDataService;
import dataservice.orderdataservice.OrderFormDataService;

public class ReceptionBlServiceImpl implements ReceptionBlService{
	LogisticsDataService logisticsDataService;
	OrderFormDataService orderFormDataService;
	@Override
	public ResultMessage addReception(ReceptionVO vo){
		LogisticsPO logistics;
		OrdersPO po;
		try {
			po = orderFormDataService.getOrderForm(vo.getReceivingtime());
			po.setReceive(vo.getCodeofreceiving(), vo.getReceiver(), vo.getReceivingtime());
			logistics = logisticsDataService.findLogistics(vo.getCodeofreceiving());
			logistics.getHistory().add("已收件，收件人是" + vo.getReceiver());
			logisticsDataService.update(logistics);
			orderFormDataService.updateOrderForm(po);
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

}
