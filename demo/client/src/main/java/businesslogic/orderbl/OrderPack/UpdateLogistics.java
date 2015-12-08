package businesslogic.orderbl.OrderPack;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.orderdataservice.LogisticsDataService;
import dataservice.orderdataservice.OrderFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.LogisticsPO;
import po.OrderPO;
import po.ResultMessage;
import vo.OrderVO;

public class UpdateLogistics {
	public ResultMessage updatebyorder(OrderVO vo){
		LogisticsDataService logisticsDataService=RMIHelper.getLogisticsdata();
		OrderFormDataService orderFormDataService=RMIHelper.getOrderformdata();
		ResultMessage resultMessage=ResultMessage.failure;
		if(vo.getFormstate()==Formstate.pass){
			OrderPO po=new OrderPO(vo.getOrdercode(), vo.getSendername(), vo.getSenderaddress(), vo.getSenderunit(), 
					vo.getSenderphone(), vo.getSendercellphone(), vo.getReceivername(), vo.getReceiveraddress(),
					 vo.getReceiverunit(), vo.getReceiverphone(), vo.getReceivercellphone(), vo.getNumbers(), vo.getWeight(), 
					 vo.getVolume(), vo.getProductname(), 
					vo.getPackagetype(), vo.getTotalfee(), vo.getOrdercode(), vo.getOrdertype(), vo.getFormstate());
			try {
				orderFormDataService.updateOrderForm(po);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultMessage=ResultMessage.failure;
			}
			ArrayList<String> history=new ArrayList<String>();
			history.add("揽件");
			LogisticsPO po1=new LogisticsPO("揽件", history, vo.getOrdercode());
			
			try {
				resultMessage = logisticsDataService.addLogistics(po1);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				resultMessage=ResultMessage.failure;
			}
		}
		
		return resultMessage;
	}

}
