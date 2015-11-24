package businesslogic.orderbl.DrvierAndStub;

import java.rmi.RemoteException;

import po.LogisticsPO;
import po.OrderPO;
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
		OrderPO po;
		try {
			po = orderFormDataService.getOrderForm(vo.getReceivingtime());
			po.setReceive(vo.getCodeofreceiving(), vo.getReceiver(), vo.getReceivingtime());
			logistics = logisticsDataService.findLogistics(vo.getCodeofreceiving());
			logistics.getHistory().add("���ռ����ռ�����" + vo.getReceiver());
			logisticsDataService.update(logistics);
			orderFormDataService.updateOrderForm(po);
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

}
