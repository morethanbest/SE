package businesslogic.orderbl.ReceptionPack;

import java.rmi.RemoteException;

import dataservice.logisticsdataservice.LogisticsInfoService;
import dataservice.orderdataservice.OrderFormDataService;
import init.RMIHelper;
import po.Formstate;
import po.LogisticsPO;
import po.OrderPO;
import po.ResultMessage;

public class RecordReception {
	String ordercode;
	String receiver;
	long receivingtime;
	public void setRecordInfo(String ordercode, String receiver, long receivingtime){
		this.ordercode=ordercode;
		this.receiver=receiver;
		this.receivingtime=receivingtime;
	}
	public ResultMessage Record(){
		OrderFormDataService order=RMIHelper.getOrderformdata();
		OrderPO po;
		ResultMessage result;
		try {
			po=order.getOrderForm(ordercode);
			po.setReceiver(receiver);
			po.setReceivingtime(receivingtime);
			updateLogistics();
		    result=order.updateOrderForm(po);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result=ResultMessage.failure;
			System.out.println("Reception fail");
		}
		return result;
	}
	
	public ResultMessage updateLogistics(){
		LogisticsInfoService log=RMIHelper.getLogisticsinfo();
        LogisticsPO po=null;
        try {
            po=log.findLogisticsInfo(ordercode);
            String State=receiver+"已签收";
            po.getHistory().add(State);
            po.setState(State);
            return log.update(po);
        } catch (RemoteException e) {
            System.out.println("delivery update logistics state failed!!!");
            e.printStackTrace();
        }
        return ResultMessage.failure;
	}

}
