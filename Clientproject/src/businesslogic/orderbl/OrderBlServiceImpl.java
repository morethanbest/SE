package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogisticsPO;
import po.OrdersPO;
import vo.OrderFareVO;
import vo.OrderVO;
import vo.ResultMessage;
import businesslogicservice.orderblservice.OrderBlService;
import dataservice.orderdataservice.LogisticsDataService;
import dataservice.orderdataservice.OrderFormDataService;

public class OrderBlServiceImpl implements OrderBlService {

	LogisticsDataService logisticsDataService;
	OrderFormDataService orderFormDataService;
	@Override
	public ResultMessage addOrder(OrderVO vo){
		long newLogisticsID;
		long newOrderID;
		try {
			newLogisticsID = logisticsDataService.findLastID() + 1;
			newOrderID = orderFormDataService.findLastID() + 1;
			LogisticsPO logistics = new LogisticsPO(newLogisticsID, "快递员已完成揽件...", new ArrayList<String>(), vo.getOrdercode());
			OrdersPO po = new OrdersPO(newOrderID, vo.getSendername(), vo.getSenderaddress(), vo.getSenderunit(), vo.getSenderphone(), vo.getSendercellphone(),vo.getReceivername(), 
					vo.getReceiveraddress(), vo.getReceiverunit(), vo.getReceiverphone(), vo.getReceivercellphone(), vo.getNumbers(), vo.getWeight(), vo.getVolume(), vo.getProductname(),
					vo.getProductsize(), vo.getPackagefee(), 0, vo.getOrdercode(), vo.getOrdertype());
			logisticsDataService.addLogistics(logistics);
			orderFormDataService.addOrderForm(po);
		} catch (RemoteException e) {
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

	@Override
	public double orderFare(OrderFareVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
